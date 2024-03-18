package org.msu.adiesha;

import org.msu.adiesha.utils.SuffixTree;
import org.msu.adiesha.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class MaximalIncreasingSubstrings {

    /**
     * This method will create suffix tree for the source string, then it will use the suffix tree to find the maximal
     * increasing subsequences of the target string relative to the source string.
     *
     * @param source
     * @param target
     */
    public static List<List<Result>> findMaximalIncreasingSubsequences(String source, String target) {
        // check the alphabet of the source and target string. If they are not the same assert false
        assert Utils.checkAlphabet(source, target);
        SuffixTree suffixTree = new SuffixTree(source);
        // created the suffix tree
        // we know that the source and target strings have the same alphabet
        List<Result> results = new ArrayList<>();
        int i = 0;
        while (i < target.length()) {
            int count = suffixTree.findMaxPrefix(target, i);
            Result currentresult = new Result(i, count);
            results.add(currentresult);
            i += count;
        }
        List<List<Result>> listOfResults = getSubsequenceTuples(results, source, target);
        return listOfResults;
    }

    public static List<Result> findLZPhrases(String source, String target) {
//        assert Utils.checkAlphabet(source, target);
        SuffixTree suffixTree = new SuffixTree(source);
        // created the suffix tree
        // we know that the source and target strings have the same alphabet
        List<Result> results = new ArrayList<>();
        int i = 0;
        while (i < target.length()) {
            int count = suffixTree.findMaxPrefix(target, i);
            Result currentresult = new Result(i, count);
            results.add(currentresult);
            i += count;
        }
        return results;
    }

    public static List<List<Result>> getSubsequenceTuples(List<Result> tuples, String source, String target) {
        List<List<Result>> result = new ArrayList<>();

        String substring = "";
        List<Result> concatanatedTuples = new ArrayList<>();
        for (Result t : tuples) {
            substring = substring + target.substring(t.index, t.index + t.size);

            if (isSubsequence(substring, source)) {
                concatanatedTuples.add(t);
            } else {
                result.add(concatanatedTuples);
                concatanatedTuples = new ArrayList<>();
                substring = target.substring(t.index, t.index + t.size);
                concatanatedTuples.add(t);
            }
        }
        result.add(concatanatedTuples);

        return result;
    }

    public static boolean isSubsequence(String str, String source) {
        int i = 0;
        int j = 0;
        while (i < str.length() && j < source.length()) {
            if (str.charAt(i) == source.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == str.length();
    }

    public static class Result {
        public int index = 0;
        public int size = 0;

        public Result(int index, int size) {
            this.index = index;
            this.size = size;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "index=" + index +
                    ", size=" + size +
                    '}';
        }
    }
}
