package org.msu.adiesha.test.finaltests;

import com.google.ortools.linearsolver.MPSolver;
import org.javatuples.Pair;
import org.javatuples.Triplet;
import org.msu.adiesha.MaximalIncreasingSubstrings;
import org.msu.adiesha.utils.FeedBackArchSetSolverMIP;
import org.msu.adiesha.utils.ReadMTGeneOrder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class AncestralGeneOrderConstructionTests {
    public static void main(String[] args) {

        String sourcePath = "data/mitochondrialdna/Siphonopidae/Siphonops_annulatus/Siphonops_annulatus_final_final.txt";
        String targetPath = "data/mitochondrialdna/Macrouridae/Trachyrincus_murrayi/Trachyrincus_murrayi_final.txt";
        Triplet<String, String, Map<String, Character>> initialMapping = AncestralGeneOrderConstructionTests.
                getSourceAndTargetStrings(sourcePath, targetPath, "Siphonops_annulatus", "Trachyrincus_murrayi");

        String source = initialMapping.getValue0();
        String target = initialMapping.getValue1();
        Pair<Integer[], Integer[]> chains = AncestralGeneOrderConstructionTests.createTheChains(source, target);
        int[][] dag = AncestralGeneOrderConstructionTests.createDag(chains.getValue0(), chains.getValue1());
        for (int i = 0; i < dag.length; i++) {
            for (int j = 0; j < dag.length; j++) {
                System.out.print(dag[i][j] + " ");
            }
            System.out.println();
        }
    }


    // given two paths to two gene orders, find the ancestral gene order and output it
    // we need to read the file, map it to some strings
    // then find the mapping between characters
    // need to use the MIS calculator to find the subsequences
    // then generate the full DG
    // need to keep track of the characters and vertex index
    // run feedbackarcset
    // run topo sort on the result
    // get a possible ordering and return a possible ancestral gene order


    public static Triplet<String, String, Map<String, Character>> getSourceAndTargetStrings(String sourcePath, String targetPath, String sourceName, String targetName) {
        System.out.println("+_+_+_+_+_+_+_+_+_+_+_");
        System.out.println("Reading the source and target strings from the files");

        List<String> geneOrder_vertebrate = ReadMTGeneOrder.readGeneOrderFromCustomFiles(sourcePath);
        List<String> geneOrder_target = ReadMTGeneOrder.readGeneOrderFromCustomFiles(targetPath);

        Map<String, Character> out;
        out = ReadMTGeneOrder.assignCharsToStringList(geneOrder_vertebrate);
        System.out.println(sourceName);
        String str1 = ReadMTGeneOrder.getTheChangedOutput(geneOrder_vertebrate, out);
        System.out.println(str1);
        System.out.println(targetName);
        String str2 = ReadMTGeneOrder.getTheChangedOutput(geneOrder_target, out);
        System.out.println(str2);

        System.out.println(out);
        Triplet<String, String, Map<String, Character>> result = new Triplet<>(str1, str2, out);
        return result;
    }

    public static Pair<Integer[], Integer[]> createTheChains(String source, String target) {
        // source should be the identity permutation
        Integer[] sourceChain = new Integer[source.length()];
        Integer[] targetChain = new Integer[target.length()];

        for (int i = 0; i < sourceChain.length; i++) {
            sourceChain[i] = i;
        }

        List<List<MaximalIncreasingSubstrings.Result>> mis = MaximalIncreasingSubstrings.
                findMaximalIncreasingSubsequences(source, target);
        List<String> misinstring = new ArrayList<>();
        for (List<MaximalIncreasingSubstrings.Result> onemis : mis) {
            StringBuilder stringBuilder = new StringBuilder();
            for (MaximalIncreasingSubstrings.Result result : onemis) {
                stringBuilder.append(target, result.index, result.index + result.size);
            }
            misinstring.add(stringBuilder.toString());
        }
        System.out.println(misinstring);

        int i = 0; // beginning of the source string
        int j = 0; // current index of the targetChain that we are trying to map
        int k = 0; // beginning of the mis string
        for (String is : misinstring) {
            // for each mis we start mapping from the beginning of the source and mis
            i = 0;
            k = 0;
            while (i < source.length() && k < is.length() && j < target.length()) {
                if (is.charAt(k) == source.charAt(i)) {
                    // found a match at i
                    targetChain[j++] = i;
                    k++;
                }
                i++;
            }
            assert k == is.length(); // for each mis string we must have found a mapping for each character in mis
            // therefore k == is.length() - 1 + 1
        }
        assert j == target.length(); // if we have not mapped all the characters then there must be a problem

        System.out.println(Arrays.toString(sourceChain));
        System.out.println(Arrays.toString(targetChain));


        return new Pair<>(sourceChain, targetChain);
    }

    public static int[][] createDag(Integer[] sourceChain, Integer[] targetChain) {
        // create the matrix, 
        int[][] adj = new int[sourceChain.length][sourceChain.length];
        for (int i = 0; i < sourceChain.length - 1; i++) {
            // goes from 0 -> length() -2
            int from = sourceChain[i];
            int to = sourceChain[i + 1];
            if (from != to) {
                adj[from][to] = 1;
            }
        }


        for (int i = 0; i < targetChain.length - 1; i++) {
            int from = targetChain[i];
            int to = targetChain[i + 1];
            if (from != to) {
                // slightly changed the logic to add edge weights,
                adj[from][to] += 1;
            }
        }

        return adj;
    }


    public static MPSolver.ResultStatus runFeedBackArcSet(int[][] adjMatrix) {
        int v = adjMatrix.length;
        MPSolver.ResultStatus result = FeedBackArchSetSolverMIP.calculateFeedBackArcSet(v, adjMatrix);

        return result;
    }
}
