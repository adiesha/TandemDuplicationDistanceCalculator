package org.msu.adiesha.test;

import com.google.ortools.Loader;
import com.google.ortools.linearsolver.MPConstraint;
import com.google.ortools.linearsolver.MPObjective;
import com.google.ortools.linearsolver.MPSolver;
import com.google.ortools.linearsolver.MPVariable;

public class TestGrpahWithMIP {

    public static void main(String[] args) {
        Loader.loadNativeLibraries();

        MPSolver solver = MPSolver.createSolver("SCIP");
        if (solver == null) {
            System.out.println("problem");
            return;
        }


        MPVariable y_01 = solver.makeIntVar(0, 1, String.format("y_{%d,%d}", 0, 1));
        MPVariable y_12 = solver.makeIntVar(0, 1, String.format("y_{%d,%d}", 1, 2));
        MPVariable y_02 = solver.makeIntVar(0, 1, String.format("y_{%d,%d}", 1, 3));

        MPConstraint constraint1 = solver.makeConstraint(Integer.MIN_VALUE, 1, String.format("cn_{%d,%d,%d}", 0, 1, 2));
        constraint1.setCoefficient(y_01, 1);
        constraint1.setCoefficient(y_12, 1);
        constraint1.setCoefficient(y_02, -1);

        MPConstraint constraint2 = solver.makeConstraint(Integer.MIN_VALUE, 0, String.format("cn___{%d,%d,%d}", 0, 1, 2));
        constraint2.setCoefficient(y_01, -1);
        constraint2.setCoefficient(y_12, -1);
        constraint2.setCoefficient(y_02, 1);

        MPObjective objective = solver.objective();
        objective.setCoefficient(y_01, -1);
        objective.setCoefficient(y_02, 1);
        objective.setCoefficient(y_12, 1);

        objective.setMinimization();
        final MPSolver.ResultStatus resultStatus = solver.solve();
        System.out.println(String.format("y_{%d, %d}", 0, 1) + y_01.solutionValue());
        System.out.println(String.format("y_{%d, %d}", 1, 2) + y_12.solutionValue());
        System.out.println(String.format("y_{%d, %d}", 0, 2) + y_02.solutionValue());

        System.out.println();
        System.out.println("Problem solved in " + solver.wallTime() + " milliseconds");
        System.out.println("Problem solved in " + solver.iterations() + " iterations");
        System.out.println("Problem solved in " + solver.nodes() + " branch-and-bound nodes");
    }

}
