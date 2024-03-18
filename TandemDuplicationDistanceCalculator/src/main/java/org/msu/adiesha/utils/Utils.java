package org.msu.adiesha.utils;

import org.apache.commons.lang.ArrayUtils;
import org.msu.adiesha.MaximalIncreasingSubstrings;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;

public class Utils {

    public static boolean checkAlphabet(String source, String target) {
        Set<Character> alphabetSource = new HashSet<>(List.of(ArrayUtils.toObject(source.toCharArray())));
        Set<Character> alphabetTarget = new HashSet<>(List.of(ArrayUtils.toObject(target.toCharArray())));
        return alphabetSource.size() == alphabetTarget.size() && alphabetTarget.containsAll(alphabetSource);
    }


    public static double log_2(int val) {
        return Math.log10(val) / Math.log10(2);
    }

    public static void printMaximalIncreasingSubsequenceResults(List<List<MaximalIncreasingSubstrings.Result>> results, String target) {
        for (List<MaximalIncreasingSubstrings.Result> result : results) {
            for (MaximalIncreasingSubstrings.Result result1 : result) {
                System.out.print(target.substring(result1.index, result1.index + result1.size));
                System.out.print(",");
            }
            System.out.print(" ,");
        }
        System.out.println();
    }

    public static void writeResultsToFile(ResultSet resultSet, String path) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(path, true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.write("---------------------\n");
            printWriter.write("Source: " + resultSet.sourceName + "\n");
            printWriter.write("Target: " + resultSet.targetName + "\n");
            printWriter.write("---------------------\n");
            printWriter.write("MIS#: " + resultSet.noOfmis + "\n");
            printWriter.write("TD#: " + resultSet.tds + "\n");
            printWriter.write("Deletions#: " + resultSet.deletions + "\n");
            printWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeResultsToFile(ResultSet resultSet, StabilizedPermutations.StabilizedPermsDTO stabilizedPermsDTO,
                                          int kendalTau, String path) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(path, true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.write("---------------------\n");
            printWriter.write("Source: " + resultSet.sourceName + "\n");
            printWriter.write("Target: " + resultSet.targetName + "\n");
            printWriter.write("---------------------\n");
            printWriter.write("KT#: " + kendalTau + "\n");
            printWriter.write("SourceAddition#: " + stabilizedPermsDTO.source_additions + "\n");
            printWriter.write("TargetDeletions#: " + stabilizedPermsDTO.target_reduction + "\n");
            printWriter.write("\n***************************");
            printWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This method will take a string that consists of genes with normal names and covert it to sequence with one letter
     * abbreviations
     *
     * @param source string that consists of genes with normal names with space as delimiter
     * @return string with one letter abbreviations
     */
    public static String printGeneOrderWithOneLetterAbbreviation(String source) {
        Map<String, String> oneLetterAbb = new HashMap<>();

        oneLetterAbb.put("tRNA-Ala", "A");
        oneLetterAbb.put("tRNA-Arg", "R");
        oneLetterAbb.put("tRNA-Asn", "N");
        oneLetterAbb.put("tRNA-Asp", "D");
        oneLetterAbb.put("tRNA-Cys", "C");
        oneLetterAbb.put("tRNA-Gln", "Q");
        oneLetterAbb.put("tRNA-Glu", "E");
        oneLetterAbb.put("tRNA-Gly", "G");
        oneLetterAbb.put("tRNA-His", "H");
        oneLetterAbb.put("tRNA-Ile", "I");
        oneLetterAbb.put("tRNA-Leu", "L");
        oneLetterAbb.put("tRNA-Lys", "K");
        oneLetterAbb.put("tRNA-Met", "M");
        oneLetterAbb.put("tRNA-Phe", "F");
        oneLetterAbb.put("tRNA-Pro", "P");
        oneLetterAbb.put("tRNA-Pyl", "O");
        oneLetterAbb.put("tRNA-Ser", "S");
        oneLetterAbb.put("tRNA-Sec", "U");
        oneLetterAbb.put("tRNA-Thr", "T");
        oneLetterAbb.put("tRNA-Trp", "W");
        oneLetterAbb.put("tRNA-Tyr", "Y");
        oneLetterAbb.put("tRNA-Val", "V");
        oneLetterAbb.put("tRNA-Asx", "B");
        oneLetterAbb.put("tRNA-Glx", "Z");
        oneLetterAbb.put("tRNA-Xaa", "X");
        oneLetterAbb.put("tRNA-Xle", "J");

        StringBuilder stringBuilder = new StringBuilder();
        String[] split = source.split(" ");
        for (String s : split) {
            stringBuilder.append(oneLetterAbb.getOrDefault(s, s)).append(" ");
        }

        return stringBuilder.toString();
    }

    public static <V, K> Map<V, K> invertMap(Map<K, V> map) {
        Map<V, K> inversedMap = map.entrySet().stream().collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));
        return inversedMap;
    }

    public static void createBoxedLatex(String s1, String s2, String s3) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] split = s1.split(" ");
        for (String s: split) {
            stringBuilder.append("\\boxed{").append(s).append("} ");
        }
        System.out.println(stringBuilder.toString());
        stringBuilder = new StringBuilder();
        split = s2.split(" ");
        for (String s: split) {
            stringBuilder.append("\\boxed{").append(s).append("} ");
        }
        System.out.println(stringBuilder.toString());
        stringBuilder = new StringBuilder();
        split = s3.split(" ");
        for (String s: split) {
            stringBuilder.append("\\boxed{").append(s).append("} ");
        }
        System.out.println(stringBuilder.toString());
    }

    public static class ResultSet {

        public int noOfmis;
        public int tds;
        public int deletions;

        public String sourceName;
        public String targetName;
    }
}
