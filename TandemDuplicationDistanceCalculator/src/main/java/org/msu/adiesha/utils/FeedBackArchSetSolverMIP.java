package org.msu.adiesha.utils;

import com.google.ortools.Loader;
import com.google.ortools.linearsolver.MPConstraint;
import com.google.ortools.linearsolver.MPObjective;
import com.google.ortools.linearsolver.MPSolver;
import com.google.ortools.linearsolver.MPVariable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FeedBackArchSetSolverMIP {

    public static void main(String[] args) {

        int[][] adj = new int[3][3];
        adj[0] = new int[]{0, 1, 0};
        adj[1] = new int[]{0, 0, 1};
        adj[2] = new int[]{1, 0, 0};
        calculateFeedBackArcSet(3, adj);

        adj = new int[3][3];
        adj[0] = new int[]{0, 0, 1};
        adj[1] = new int[]{1, 0, 1};
        adj[2] = new int[]{0, 0, 0};
        calculateFeedBackArcSet(3, adj);

        int[][] adj2 = new int[2][2];
        adj[0] = new int[]{0, 1};
        adj[1] = new int[]{1, 0};
        calculateFeedBackArcSet(2, adj2);

        adj[0] = new int[]{0, 1, 1};
        adj[1] = new int[]{0, 0, 1};
        adj[2] = new int[]{0, 0, 0};
        calculateFeedBackArcSet(3, adj);

        int[][] adj3 = new int[8][8];
        adj3[0] = new int[]{0, 1, 0, 0, 0, 0, 0, 1};
        adj3[1] = new int[]{1, 0, 1, 0, 0, 0, 0, 0};
        adj3[2] = new int[]{0, 0, 0, 1, 0, 0, 1, 0};
        adj3[3] = new int[]{0, 0, 0, 0, 1, 0, 0, 0};
        adj3[4] = new int[]{0, 0, 0, 0, 0, 1, 0, 0};
        adj3[5] = new int[]{0, 0, 0, 0, 0, 0, 1, 0};
        adj3[6] = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
        adj3[7] = new int[]{0, 0, 1, 0, 0, 0, 0, 0};

        calculateFeedBackArcSet(8, adj3);

        int[][] adj4 = new int[4][4];
        adj4[0] = new int[]{0, 1, 0, 0};
        adj4[1] = new int[]{0, 0, 1, 0};
        adj4[2] = new int[]{1, 0, 0, 1};


        adj4[3] = new int[]{1, 0, 1, 0};
        calculateFeedBackArcSet(4, adj4);

        int[][] adj5 = new int[5][5];
        adj5[0] = new int[]{0, 1, 0, 0, 0};
        adj5[1] = new int[]{0, 0, 1, 0, 0};
        adj5[2] = new int[]{1, 0, 0, 1, 0};
        adj5[3] = new int[]{1, 0, 0, 0, 1};
        adj5[4] = new int[]{1, 0, 0, 1, 0};
        calculateFeedBackArcSet(5, adj5);


    }

    /**
     * This method requires size of the directed graph, adjacency matrix to represent the directed graph
     *
     * @param v         Number of vertices in the graph
     * @param adjMatrix adjacency matrix
     */
    public static void calculateFeedBackArcSet(int v, int[][] adjMatrix) {
        // Load the native libs
        Loader.loadNativeLibraries();
        // Create the linear solver with the SCIP backend.
        MPSolver solver = MPSolver.createSolver("SCIP");
        if (solver == null) {
            System.out.println("Could not create solver SCIP");
            return;
        }


        // create binary variables
        MPVariable[][] yVars = new MPVariable[v][v];
        for (int i = 0; i < yVars.length; i++) {
            for (int j = i; j < yVars.length; j++) {
                if (i != j)
                    yVars[i][j] = solver.makeIntVar(0, 1, String.format("y_{%d,%d}", i, j));
            }
        }


//        for (int i = 0; i < yVars.length; i++) {
//            for (int j = i; j < yVars.length; j++) {
//                if (i != j)
//                    System.out.println(yVars[i][j].toString());
//                System.out.println(String.format("y_{%d,%d}", i, j));
//            }
//        }

        // create the coefficients (c_{i,j}) for each edge in the graph, set all the other coefficients 0
        int[][] coefs = new int[v][v];
        // create the constraints
        for (int i = 0; i < yVars.length; i++) {
            for (int j = 0; j < yVars.length; j++) {
                coefs[i][j] = (adjMatrix[i][j] == 1) ? 1 : 0;
            }
        }

        // create the constraints
        for (int i = 0; i < v; i++) {
            for (int j = i + 1; j < v; j++) {
                for (int k = j + 1; k < v; k++) {
                    // yi,j + yj,k − yi,k ≤ 1, 1 ≤ i < j < k ≤ n
                    MPConstraint constraint1 = solver.makeConstraint(Integer.MIN_VALUE, 1, String.format("cn_{%d,%d,%d}", i, j, k));

                    constraint1.setCoefficient(yVars[i][j], 1);
                    constraint1.setCoefficient(yVars[j][k], 1);
                    constraint1.setCoefficient(yVars[i][k], -1);


                    MPConstraint constraint2 = solver.makeConstraint(Integer.MIN_VALUE, 0, String.format("cn___{%d,%d,%d}", i, j, k));
                    constraint2.setCoefficient(yVars[i][j], -1);
                    constraint2.setCoefficient(yVars[j][k], -1);
                    constraint2.setCoefficient(yVars[i][k], 1);

                }
            }
        }

        System.out.println("Number of constraints = " + solver.numConstraints());


        // create the objective function

        MPObjective objective = solver.objective();
        Map<MPVariable, Integer> variableWithCoefs = new HashMap<>();
        for (int j = 0; j < v; j++) {

            for (int k = 0; k < j; k++) {
                updateCoefs(yVars[k][j], coefs[k][j], variableWithCoefs);
            }

            for (int l = j + 1; l < v; l++) {
                updateCoefs(yVars[j][l], -coefs[l][j], variableWithCoefs);
            }
        }

        for (Map.Entry<MPVariable, Integer> entry : variableWithCoefs.entrySet()) {
            objective.setCoefficient(entry.getKey(), entry.getValue());
        }

        objective.setMinimization();

        final MPSolver.ResultStatus resultStatus = solver.solve();
//        System.out.println(solver.exportModelAsLpFormat());
        System.out.println("+++++++++++++++++++++++++++");
//        System.out.println(solver.exportModelAsMpsFormat());
        if (resultStatus == MPSolver.ResultStatus.OPTIMAL) {
            System.out.println("Objective value = " + objective.value());
            for (int i = 0; i < v; i++) {
                for (int j = i; j < v; j++) {
                    if (i != j)
                        System.out.println(String.format("y_{%d, %d}", i, j) + yVars[i][j].solutionValue());
                }
            }

            System.out.println();
            System.out.println("Problem solved in " + solver.wallTime() + " milliseconds");
            System.out.println("Problem solved in " + solver.iterations() + " iterations");
            System.out.println("Problem solved in " + solver.nodes() + " branch-and-bound nodes");
        }
        print2d(adjMatrix);
        System.out.println("^*********^");
        updateDAG(adjMatrix, yVars);
        print2d(adjMatrix);
    }

    public static void print2d(int[][] adj) {
        if (adj.length == 0)
            return;
        for (int i = 0; i < adj.length; i++) {
            for (int j = 0; j < adj[0].length; j++) {
                System.out.print(adj[i][j] + ", ");
            }
            System.out.println();
        }
    }

    private static void updateCoefs(MPVariable var, int i, Map<MPVariable, Integer> map) {
        if (map.containsKey(var)) {
            map.put(var, map.get(var) + i);
        } else {
            map.put(var, i);
        }
    }


    public static void updateDAG(int[][] adj, MPVariable[][] result) {
        for (int i = 0; i < adj.length; i++) {
            for (int j = 0; j < adj.length; j++) {
                if (i != j) {
                    if (adj[i][j] == 1) {
                        // i->j edge exist
                        if (i < j) {
                            int order = (int) result[i][j].solutionValue();
                            if (order == 1) { // j precedes i in the solution therefore i->j cannot exist
                                adj[i][j] = 0;
                            }
                        } else {
                            int order = (int) result[j][i].solutionValue();
                            if (order == 0) { // j precedes i
                                adj[i][j] = 0;
                            }
                        }
                    }
                }
            }
        }
    }
}
