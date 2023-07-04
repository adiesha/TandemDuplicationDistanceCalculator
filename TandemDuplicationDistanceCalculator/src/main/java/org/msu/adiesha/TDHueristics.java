package org.msu.adiesha;

import org.msu.adiesha.utils.LCS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

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
                    coverofsource[j] = true;
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
        StringBuilder stringBuilder = new StringBuilder("asdfsdfs");

        stringBuilder.insert(0, 'z');
        System.out.println(stringBuilder);

        StringBuilder newtarget = new StringBuilder(target);
        int offset = 0;
        int coveredletters = 0;
        for (int j = 0; j < coverofsource.length; j++) {
            if (coverofsource[j]) {
                coveredletters++;
                continue;
            } else {
                int index = coveredletters == 0 ? 0 : skeletonindices.get(coveredletters - 1);
                newtarget.insert(coveredletters == 0 ? 0 : index + 1 + offset, source.charAt(j));
                offset++;
            }

        }

        System.out.println(newtarget);
    }


    public static void main(String[] args) {
        TDHueristics tdHueristics = new TDHueristics();
        tdHueristics.run("AGTCGTT", "AGGTTTTACCAATATTTACGGCA");
        System.out.println("----------------");
        tdHueristics.run("AGTCGAAGTAAGTTG", "AGTCGAAGTAAAAGTAAGTTG");
        System.out.println("----------------");
        tdHueristics.run("vwxyz", "wvxwyxzyyxwxwvzyxzyxwyxwvzyxwv");
    }
}
