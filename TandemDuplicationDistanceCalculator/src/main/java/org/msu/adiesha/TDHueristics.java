package org.msu.adiesha;

import org.msu.adiesha.utils.LCS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TDHueristics {

    private LCS lcs;

    public TDHueristics() {

    }

    public void run(String source, String target) throws Exception {

        char[] sequence = LCS.lcs(source, target, source.length(), target.length());
        System.out.println(sequence);

        List<Integer> skeletonindices = new ArrayList<>();
        int i = 0;
        for (char c :
                sequence) {
            while (i < target.length()) {
                if (target.charAt(i) == c) {
                    skeletonindices.add(i);
                    i++;
                    break;
                } else {
                    i++;
                }
            }
        }
        System.out.println(skeletonindices);

        boolean[] coverofsource = new boolean[source.length()];

        i = 0;
        for (int j = 0; j < sequence.length; j++) {
            while (i < source.length()) {
                if (sequence[j] == source.charAt(i)) {
                    coverofsource[i] = true;
                    i++;
                    break;
                }
                i++;
            }
        }

        for (boolean b :
                coverofsource) {
            System.out.print(b + ", ");
        }

        System.out.println();
//        System.out.println("The number of deletions: " + (source.length() - sequence.length));
        int countOfDeletions = findTheNumberOfDeletedSubstrings(coverofsource);
        System.out.println("The number of deletions: " + countOfDeletions);


        StringBuilder newtarget = new StringBuilder(target);
        int offset = 0;
        int coveredletters = 0;
        for (int j = 0; j < coverofsource.length; j++) {
            if (coverofsource[j]) {
                coveredletters++;
                continue;
            } else {
                int index = coveredletters == 0 ? 0 : skeletonindices.get(coveredletters - 1);
                newtarget.insert(coveredletters == 0 ? 0 + offset : index + 1 + offset, source.charAt(j));
                offset++;
            }

        }

        System.out.println(newtarget);
        char[] result = LCS.lcs(source, newtarget.toString(), source.length(), newtarget.length());
        assert source.equals(String.copyValueOf(result));

        skeletonindices = new ArrayList<>();
        i = 0;
        for (char c :
                result) {
            while (i < newtarget.length()) {
                if (newtarget.charAt(i) == c) {
                    skeletonindices.add(i);
                    i++;
                    break;
                } else {
                    i++;
                }
            }
        }
        System.out.println(skeletonindices);

        Set<Integer> skeletonindicesset = new HashSet<>(skeletonindices);

        for (int j = 0; j < newtarget.length(); j++) {
            for (int k = j + 1; k < newtarget.length(); k++) {
                if (checkTDbility(newtarget.toString(), j, k))
                    System.out.println(j + "," + k);
            }
        }

        int countOfTDOperations = 0;
        int lengthofTD = newtarget.length() / 2;
        while (lengthofTD > 0) {
            int k = 0;
            while (k + lengthofTD * 2 < newtarget.length()) {
                if (checkWhetherTDisPossible(skeletonindices, k, k + lengthofTD)) {
                    if (checkTDbility(newtarget.toString(), k, k + lengthofTD)) {
                        deductXFromElementsInAGivenRange(skeletonindices, lengthofTD, k + lengthofTD, newtarget.length() - 1);
                        newtarget.delete(k + lengthofTD, k + 2 * lengthofTD);
                        countOfTDOperations++;
                    }
                }
                k++;

            }
            lengthofTD--;
        }

        System.out.println("Number of TDS " + countOfTDOperations);

        System.out.println("+++++++++++++++++");
        System.out.println(newtarget);
        System.out.println(LCS.lcs(source, newtarget.toString(), source.length(), newtarget.length()));

        System.out.println("***********************");
        System.out.println(skeletonindices);
        List<String> insertSubstrings = findTheSubstringsThatAreNotCovered(newtarget.toString(), skeletonindices);

        LZ77Updated lz77Updated = new LZ77Updated();
        int countOfInsertions = 0;
        for (String substring :
                insertSubstrings) {
            lz77Updated.compress(source, substring);
            lz77Updated.printCompressed();
            countOfInsertions = countOfInsertions + lz77Updated.getNumberOfPhrases();
        }

        System.out.println("Number of insertions " + countOfInsertions);

        System.out.println("Total Number of Operations: " + countOfDeletions + "+" + countOfTDOperations + "+" + countOfInsertions * 2 + "= " + (countOfDeletions + countOfTDOperations + 2 * countOfInsertions));
    }

    public int findTheNumberOfDeletedSubstrings(boolean[] coverOfSource) {
        int numberOfSubstrings = 0;
        boolean previous = true;
        for (boolean current :
                coverOfSource) {
            if (previous)
                previous = current;
            else {
                if (current) {
                    numberOfSubstrings++;
                    previous = current;
                } else {
                    previous = current;
                }
            }

        }
        if (!previous)
            numberOfSubstrings++;
        return numberOfSubstrings;
    }

    public List<String> findTheSubstringsThatAreNotCovered(String input, List<Integer> skeleton) {
        System.out.println(input);
        System.out.println(skeleton);
        List<String> results = new ArrayList<>();
        int i = 0; // starting index
        for (int j = 0; j < skeleton.size(); j++) {
            if (skeleton.get(j) - i == 0) {
                // nothing to add
            } else {
                results.add(input.substring(i, skeleton.get(j)));
            }
            i = skeleton.get(j) + 1;
        }

        if (input.length() - 1 - i > 0) {
            results.add(input.substring(i));
        }

        System.out.println(results);

        return results;
    }

    public boolean checkWhetherTDisPossible(List<Integer> list, int i, int j) {
        int dist = j - i;
        int ileft = i;
        int iright = i + dist - 1;

        int jleft = j;
        int jright = j + dist - 1;

        if (searchTargetInaRange(list, ileft, iright)) {
            if (searchTargetInaRange(list, jleft, jright)) {
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }

    public void deductXFromElementsInAGivenRange(List<Integer> list, int x, int lo, int hi) throws Exception {
        if (lo > hi) {
            throw new Exception("lo is higher than hi");
        }
        for (int i = 0; i < list.size(); i++) {
            int temp = list.get(i);
            if (lo <= temp && temp <= hi) {
                list.set(i, temp - x);
            }
        }

    }

    public boolean searchTargetInaRange(List<Integer> list, int i, int j) {
        int result = binarySearch(list, 0, list.size() - 1, i, j);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    private int binarySearch(List<Integer> list, int lo, int hi, int i, int j) {
        if (lo > hi) {
            return -1;
        }
        int mid = (lo + hi) / 2;
        int target = list.get(mid);
        if (i <= target && target <= j) {
            return target;
        } else if (target < i) {
            return binarySearch(list, mid + 1, hi, i, j);
        } else {
            return binarySearch(list, lo, mid - 1, i, j);
        }
    }

    public boolean checkTDbility(String str, int i, int j) {
        if (i >= j) {
            System.out.println("i and j values are not valid");
            return false;
        } else {
            int dist = j - i;
            if (dist > str.length() - j) {
                return false;
            } else {
                if (str.charAt(i) == str.charAt(j) && str.charAt(i + dist - 1) == str.charAt(j + dist - 1)) {
                    return str.substring(i, i + dist - 1).equals(str.substring(j, j + dist - 1));
                } else {
                    //System.out.println("Last and first chars does not match");
                    return false;
                }
            }
        }

    }

    public static void main(String[] args) throws Exception {
        TDHueristics tdHueristics = new TDHueristics();
        tdHueristics.run("AGTCGTT", "AGGTTTTACCAATATTTACGGCA");
        System.out.println("----------------");
        tdHueristics.run("AGTCGAAGTAAGTTG", "AGTCGAAGTAAAAGTAAGTTG");
        System.out.println("----------------");
        tdHueristics.run("vwxyz", "wvxwyxzyyxwxwvzyxzyxwyxwvzyxwv");
        System.out.println("----------------");
        tdHueristics.run("AGTCGAAGTAAGTTG", "AGTGGAAGTAAGTTG");
        System.out.println("----------------");
        tdHueristics.run("ACTCGAACT", "TCGAATTTGGAACG");
        System.out.println("----------------");
        tdHueristics.run("ACGT", "TGCA");


    }
}
