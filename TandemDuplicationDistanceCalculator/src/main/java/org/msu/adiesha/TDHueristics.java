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

    public void run(String source, String target) {

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

    public static void main(String[] args) {
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
