package org.msu.adiesha;

import org.apache.commons.lang.ArrayUtils;
import org.msu.adiesha.utils.SuffixTree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MaximalIncreasingSubstrings {

    /**
     * This method will create suffix tree for the source string, then it will use the suffix tree to find the maximal
     * increasing subsequences of the target string relative to the source string.
     *
     * @param source
     * @param target
     */
    public static List<Result> findMaximalIncreasingSubsequences(String source, String target) {
        // check the alphabet of the source and target string. If they are not the same assert false
        assert checkAlphabet(source, target);
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

    public static boolean checkAlphabet(String source, String target) {
        Set<Character> alphabetSource = new HashSet<>(List.of(ArrayUtils.toObject(source.toCharArray())));
        Set<Character> alphabetTarget = new HashSet<>(List.of(ArrayUtils.toObject(target.toCharArray())));
        return alphabetSource.size() == alphabetTarget.size() && alphabetTarget.containsAll(alphabetSource);
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
