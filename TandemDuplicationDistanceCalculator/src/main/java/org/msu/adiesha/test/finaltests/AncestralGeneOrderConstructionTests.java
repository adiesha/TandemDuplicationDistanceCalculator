package org.msu.adiesha.test.finaltests;

import com.google.ortools.linearsolver.MPSolver;
import org.javatuples.Pair;
import org.javatuples.Triplet;
import org.msu.adiesha.MaximalIncreasingSubstrings;
import org.msu.adiesha.utils.FeedBackArchSetSolverMIP;
import org.msu.adiesha.utils.ReadMTGeneOrder;
import org.msu.adiesha.utils.TopologicalSort;
import org.msu.adiesha.utils.Utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class AncestralGeneOrderConstructionTests {
    public static void main(String[] args) throws IOException {

        // Test 1 vs 6
        String sourcePath = "data/mitochondrialdna/Siphonopidae/Siphonops_annulatus/Siphonops_annulatus_final_final.txt";
        String targetPath = "data/mitochondrialdna/Macrouridae/Trachyrincus_murrayi/Trachyrincus_murrayi_final.txt";
        runAncestralGenePredictionTest(sourcePath, targetPath, "Siphonops annulatus", "Trachyrincus murrayi");

        // Test 01 04
        sourcePath = "data/mitochondrialdna/Siphonopidae/Siphonops_annulatus/Siphonops_annulatus_final_final.txt";
        targetPath = "data/mitochondrialdna/Benthophilinae/Ponticola_kessleri/Ponticola_kessleri_final.txt";
        runAncestralGenePredictionTest(sourcePath, targetPath, "Siphonops annulatus", "Ponticola kessleri");

        // test 04 01
        sourcePath = "data/mitochondrialdna/Benthophilinae/Ponticola_kessleri/Ponticola_kessleri_final.txt";
        targetPath = "data/mitochondrialdna/Siphonopidae/Siphonops_annulatus/Siphonops_annulatus_final_final.txt";
        runAncestralGenePredictionTest(sourcePath, targetPath, "Ponticola kessleri", "Siphonops annulatus");

        // test 01 04
        targetPath = "data/mitochondrialdna/Siphonopidae/Siphonops_annulatus/Siphonops_annulatus_final_final.txt";
        sourcePath = "data/mitochondrialdna/Chamaeleonidae/Chamaeleo_africanus/Chamaeleo_africanus_final.txt";
        runAncestralGenePredictionTest(sourcePath, targetPath, "hamaeleo_africanus", "Siphonops annulatus");

        // test 01 10
        sourcePath = "data/mitochondrialdna/Siphonopidae/Siphonops_annulatus/Siphonops_annulatus_final_final.txt";
        targetPath = "data/mitochondrialdna/Lampridae/Lampris_guttatus/Lampris_guttatus_final.txt";
        runAncestralGenePredictionTest(sourcePath, targetPath, "Siphonops annulatus", "Lampris Guttatus");

        // test 03 01
        sourcePath = "data/mitochondrialdna/Rhineuridae/Rhineura_floridana/Rhineura_floridana_final_final.txt";
        targetPath = "data/mitochondrialdna/Siphonopidae/Siphonops_annulatus/Siphonops_annulatus_final_final.txt";
        runAncestralGenePredictionTest(sourcePath, targetPath, "Rhineura floridana","Siphonops annulatus");


        // test 01 10
        sourcePath = "data/mitochondrialdna/Siphonopidae/Siphonops_annulatus/Siphonops_annulatus_final_final.txt";
        targetPath = "data/mitochondrialdna/Hapalogenyidae/Hapalogenys_analis/Hapalogenys_analis_final.txt";
        runAncestralGenePredictionTest(sourcePath, targetPath, "Siphonops annulatus", "Hapalogenys analis");

        // test 08 03
        sourcePath = "data/mitochondrialdna/Platytroctidae/Normichthys_operosus/Normichthys_operosus_final.txt";
        targetPath = "data/mitochondrialdna/Nototheniidae/Pagothenia-borchgrevinki/Pagothenia-borchgrevinki_final.txt";
        runAncestralGenePredictionTest(sourcePath, targetPath, "Normichthys operosus", "Pagothenia borchgrevinki");


        // test 09 02
        sourcePath = "data/mitochondrialdna/Umbridae/Dallia_pectoralis/Dallia_pectoralis_final.txt";
        targetPath = "data/mitochondrialdna/Muraenesox_bagio/Muraenesox_bagio.txt";
        runAncestralGenePredictionTest(sourcePath, targetPath, "Dallia pectoralis", "Muraenesox bagio");


        // test 09 06
        sourcePath = "data/mitochondrialdna/Umbridae/Dallia_pectoralis/Dallia_pectoralis_final.txt";
        targetPath = "data/mitochondrialdna/Macrouridae/Squalogadus_modificatus/Squalogadus_modificatus_final.txt";
        runAncestralGenePredictionTest(sourcePath, targetPath, "Dallia pectoralis", "Squalogadus modificatus");

        // test 11 07
        sourcePath = "data/mitochondrialdna/Cottidae/Clinocottus_analis/Clinocottus_analis_final.txt";
        targetPath = "data/mitochondrialdna/Aulorhynchidae/Aulorhynchus_flavidus/Aulorhynchus_flavidus_final.txt";
        runAncestralGenePredictionTest(sourcePath, targetPath, "Clinocottus analis", "Aulorhynchus flavidus");


        // test 05 08
        sourcePath = "data/mitochondrialdna/Macrouridae/Ventrifossa_garmani/Ventrifossa_garmani_final.txt";
        targetPath = "data/mitochondrialdna/Platytroctidae/Normichthys_operosus/Normichthys_operosus_final.txt";
        runAncestralGenePredictionTest(sourcePath, targetPath, "Ventrifossa garmani", "Normichthys operosus");

        // test 07 04
        sourcePath = "data/mitochondrialdna/Aulorhynchidae/Aulorhynchus_flavidus/Aulorhynchus_flavidus_final.txt";
        targetPath = "data/mitochondrialdna/Benthophilinae/Ponticola_kessleri/Ponticola_kessleri_final.txt";
        runAncestralGenePredictionTest(sourcePath, targetPath, "Aulorhynchus flavidus", "Ponticola kessleri");

        // test 03 04
        sourcePath = "data/mitochondrialdna/Rhineuridae/Rhineura_floridana/Rhineura_floridana_final_final.txt";
        targetPath = "data/mitochondrialdna/Chamaeleonidae/Chamaeleo_africanus/Chamaeleo_africanus_final.txt";
        runAncestralGenePredictionTest(sourcePath, targetPath, "Rhineura floridana", "Chamaeleo africanus");


        // test 03 04
        sourcePath = "data/mitochondrialdna/Rhineuridae/Rhineura_floridana/Rhineura_floridana_final_final.txt";
        targetPath = "data/mitochondrialdna/Chamaeleonidae/Chamaeleo_africanus/Chamaeleo_africanus_final.txt";
        runAncestralGenePredictionTest(sourcePath, targetPath, "Rhineura floridana", "Chamaeleo africanus");

        // test 02 05
        sourcePath = "data/mitochondrialdna/Nettastomatidae/Hoplunnis_punctata/Hoplunnis_punctata_final.txt";
        targetPath = "data/mitochondrialdna/Macrouridae/Ventrifossa_garmani/Ventrifossa_garmani_final.txt";
        runAncestralGenePredictionTest(sourcePath, targetPath, "Hoplunnis punctata", "Ventrifossa garmani");

        // test __ 04
        sourcePath = "data/mitochondrialdna/Hemisotidae/Hemisus_marmoratus/Hemisus_marmoratus_final_final.txt";
        targetPath = "data/mitochondrialdna/Chamaeleonidae/Chamaeleo_arabicus/Chamaeleo_arabicus_final.txt";
        runAncestralGenePredictionTest(sourcePath, targetPath, "Hemisus marmoratus", "Chamaeleo arabicus");

        // special test 1
        sourcePath = "data/mitochondrialdna/Hemisotidae/Hemisus_marmoratus/Hemisus_marmoratus_final_final.txt";
        targetPath = "data/mitochondrialdna/Hyperoliidae/Hyperolius_marmoratus/Hyperolius_marmoratus_final.txt";
        runAncestralGenePredictionTest(sourcePath, targetPath, "Hemisus marmoratus", "Hyperolius marmoratus");

        // special test 2.1
        sourcePath = "data/mitochondrialdna/Hyperoliidae/Hyperolius_marmoratus/Hyperolius_marmoratus_final.txt";
        targetPath = "data/mitochondrialdna/Arthroleptidae/Trichobatrachus_robustus/Trichobatrachus_robustus_final_final.txt";
        runAncestralGenePredictionTest(sourcePath, targetPath, "Hyperolius marmoratus", "Trichobatrachus robustus");


        // special test 2.2
        sourcePath = "data/mitochondrialdna/Hyperoliidae/Hyperolius_marmoratus/Hyperolius_marmoratus_final_best.txt";
        targetPath = "data/mitochondrialdna/Arthroleptidae/Trichobatrachus_robustus/Trichobatrachus_robustus_final_final_best.txt";
        runAncestralGenePredictionTest(sourcePath, targetPath, "Hyperolius marmoratus", "Trichobatrachus robustus");

        // special test 3
        sourcePath = "data/mitochondrialdna/Hyperoliidae/Hyperolius_marmoratus/Hyperolius_marmoratus_final_best.txt";
        targetPath = "data/mitochondrialdna/Microhyloidea/Breviceps_adspersus/Breviceps_adspersus_final_final.txt";
        runAncestralGenePredictionTest(sourcePath, targetPath, "Hyperolius marmoratus", "Breviceps adspersus");

    }

    public static void runAncestralGenePredictionTest(String sourcePath, String targetPath, String sourceName, String targetName) throws IOException {

        File ancestorGeneration = new File("data/result/ancestorGeneration.txt");
        if (!ancestorGeneration.exists())
            ancestorGeneration.createNewFile();
        FileWriter fileWriter = new FileWriter(ancestorGeneration, true);
        fileWriter.write("---------------------------------------------------------------------\n");
        fileWriter.write("Generating ancestor\n");
        fileWriter.write("Source: " + sourceName + "\n");
        fileWriter.write("Target: " + targetName + "\n");

        Triplet<String, String, Map<String, Character>> initialMapping = AncestralGeneOrderConstructionTests.
                getSourceAndTargetStrings(sourcePath, targetPath, sourceName, targetName);

        String source = initialMapping.getValue0();
        String target = initialMapping.getValue1();
        fileWriter.write("Mapped source and target to character array-----> \n");
        fileWriter.write(source + "\n");
        fileWriter.write(target + "\n");
        fileWriter.write("\nCreating chains for directed graph generation\n");
        Pair<Integer[], Integer[]> chains = AncestralGeneOrderConstructionTests.createTheChains(source, target);
        fileWriter.write(Arrays.toString(chains.getValue0()) + "\n");
        fileWriter.write(Arrays.toString(chains.getValue1()) + "\n");
        int[][] dag = AncestralGeneOrderConstructionTests.createDag(chains.getValue0(), chains.getValue1());
        for (int i = 0; i < dag.length; i++) {
            for (int j = 0; j < dag.length; j++) {
                System.out.print(dag[i][j] + " ");
            }
            System.out.println();
        }

        var mipResult = AncestralGeneOrderConstructionTests.runFeedBackArcSet(dag);
        fileWriter.write(mipResult.getValue0().toString() + "\n");
        MPSolver solver = mipResult.getValue1();

        fileWriter.write("Problem solved in " + solver.wallTime() + " milliseconds" + " \n");
        fileWriter.write("Problem solved in " + solver.iterations() + " iterations" + " \n");
        fileWriter.write("Problem solved in " + solver.nodes() + " branch-and-bound nodes" + " \n");

        fileWriter.write("********\n");
        String ancestor = AncestralGeneOrderConstructionTests.findAncestorFromTheDag(dag, source, target);
        System.out.println(ancestor);
        fileWriter.write(ancestor + "\n");
        System.out.println("---------------->");
        String initialMappingSource = printSequenceWithInitialMapping(source, initialMapping.getValue2());
        String ancestorWithInitialCharacters = printSequenceWithInitialMapping(ancestor, initialMapping.getValue2());
        String initialMappingTarget = printSequenceWithInitialMapping(target, initialMapping.getValue2());

        fileWriter.write(initialMappingSource + "\n" + ancestorWithInitialCharacters + "\n" + initialMappingTarget + "\n");
        String sourceWithOneLetterAbb = Utils.printGeneOrderWithOneLetterAbbreviation(initialMappingSource);
        String ancestorWithOneLetterAbb = Utils.printGeneOrderWithOneLetterAbbreviation(ancestorWithInitialCharacters);
        String targetWithOneLetterAbb = Utils.printGeneOrderWithOneLetterAbbreviation(initialMappingTarget);
        System.out.println(sourceWithOneLetterAbb);
        System.out.println(ancestorWithOneLetterAbb);
        System.out.println(targetWithOneLetterAbb);
        fileWriter.write(sourceWithOneLetterAbb + "\n" + ancestorWithOneLetterAbb + "\n" + targetWithOneLetterAbb + "\n");
        fileWriter.write("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n");
        fileWriter.close();

    }

    public static String findAncestorFromTheDag(int[][] dag, String source, String target) {
        var stack = TopologicalSort.topoSort(dag.length, dag);
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            int temp = stack.pop();
            int loop = dag[temp][temp] > 0 ? 1 + dag[temp][temp] : 1;
            if (loop > 1) System.out.println(source.charAt(temp) + " is repeated " + loop + " times");
            stringBuilder.append(String.valueOf(source.charAt(temp)).repeat(loop));
            System.out.println(temp + " -> " + source.charAt(temp));
        }
        System.out.println(stringBuilder.toString());
        return stringBuilder.toString();
    }

    public static String printSequenceWithInitialMapping(String string, Map<String, Character> mapping) {
        Map<Character, String> invertedMap = Utils.invertMap(mapping);
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : string.toCharArray()) {
            stringBuilder.append(invertedMap.get(c)).append(" ");
        }
        System.out.println(stringBuilder);
        return stringBuilder.toString();
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
            //removed if (from != to) check to include self loops, however feedback arc set instance should not consider
            // it
            // slightly changed the logic to add edge weights,
            adj[from][to] += 1;

        }

        return adj;
    }


    public static Pair<MPSolver.ResultStatus, MPSolver> runFeedBackArcSet(int[][] adjMatrix) {
        int v = adjMatrix.length;
        var result = FeedBackArchSetSolverMIP.calculateFeedBackArcSet(v, adjMatrix);

        return result;
    }
}
