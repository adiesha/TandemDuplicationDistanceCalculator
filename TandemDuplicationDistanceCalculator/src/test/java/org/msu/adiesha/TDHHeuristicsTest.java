package org.msu.adiesha;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import java.util.ArrayList;
import java.util.List;

public class TDHHeuristicsTest {

    private TDHueristics tdHueristics;

    @Before
    public void setUp() throws Exception {
        tdHueristics = new TDHueristics();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void run() {
    }

    @Test
    public void findTheNumberOfDeletedSubstrings() {
        boolean[] test = new boolean[]{true, false, false, true, true, true, false, true, false};
        System.out.println(tdHueristics.findTheNumberOfDeletedSubstrings(test));

        test = new boolean[]{false, false, false, true, true, true, false, true, false};
        System.out.println(tdHueristics.findTheNumberOfDeletedSubstrings(test));

        test = new boolean[]{false, true, false, true, true, true, false, true, false, false};
        System.out.println(tdHueristics.findTheNumberOfDeletedSubstrings(test));

        test = new boolean[]{false, false, false, false, false, false, false, false, false};
        System.out.println(tdHueristics.findTheNumberOfDeletedSubstrings(test));

        test = new boolean[]{true, true, true, true, true, true, true, true, true, true};
        System.out.println(tdHueristics.findTheNumberOfDeletedSubstrings(test));

    }

    @Test
    public void checkTDbility() {
        System.out.println(tdHueristics.checkTDbility("TCGAATTTGGAACGACGTTACGAT", 5, 7));
        System.out.println(tdHueristics.checkTDbility("TCGAATTTGGAACGACGTTACGAT", 5, 6));
        System.out.println(tdHueristics.checkTDbility("ACGGACGGTCGAATTTGGAACGACGTTACGAT", 0, 4));
    }

    @Test
    public void findTheSubstringsThatAreNotCovered() {
        List<Integer> integers = new ArrayList<>();
        integers.add(0);
        integers.add(3);
        integers.add(5);
        integers.add(6);
        integers.add(10);
        integers.add(14);
        integers.add(15);
        integers.add(17);
        integers.add(18);
        integers.add(25);

        String test = "ACGCGAGGCGGCTGCTGCTGCTGAGGGCTG";
        tdHueristics.findTheSubstringsThatAreNotCovered(test, integers);

        System.out.println("&&&&&&&&&&&&&&&");
        integers = new ArrayList<>();
        integers.add(3);
        integers.add(5);
        integers.add(6);
        integers.add(10);
        integers.add(14);
        integers.add(15);
        integers.add(17);
        integers.add(18);
        integers.add(25);
        test = "ACGCGAGGCGGCTGCTGCTGCTGAGGGCTG";
        tdHueristics.findTheSubstringsThatAreNotCovered(test, integers);

        System.out.println("&&&&&&&&&&&&&&&");
        integers = new ArrayList<>();
        integers.add(3);
        integers.add(5);
        integers.add(6);
        integers.add(10);
        integers.add(14);
        integers.add(15);
        integers.add(17);
        integers.add(18);
        integers.add(29);
        test = "ACGCGAGGCGGCTGCTGCTGCTGAGGGCTG";
        tdHueristics.findTheSubstringsThatAreNotCovered(test, integers);

        System.out.println("&&&&&&&&&&&&&&&");
        integers = new ArrayList<>();
        integers.add(0);
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);
        integers.add(6);
        integers.add(7);
        integers.add(8);
        test = "ACGTTTCGA";
        List<String> result = tdHueristics.findTheSubstringsThatAreNotCovered(test, integers);


    }

    @Test
    public void checkWhetherTDisPossible() {
        List<Integer> integers = new ArrayList<>();
        integers.add(0);
        integers.add(3);
        integers.add(5);
        integers.add(6);
        integers.add(10);
        integers.add(14);
        integers.add(15);
        integers.add(17);
        integers.add(18);
        integers.add(25);
        System.out.println(tdHueristics.checkWhetherTDisPossible(integers, 0, 1));
        System.out.println(tdHueristics.checkWhetherTDisPossible(integers, 2, 3));
        System.out.println(tdHueristics.checkWhetherTDisPossible(integers, 1, 3));
        System.out.println(tdHueristics.checkWhetherTDisPossible(integers, 1, 4));
        System.out.println(tdHueristics.checkWhetherTDisPossible(integers, 13, 18));
        System.out.println(tdHueristics.checkWhetherTDisPossible(integers, 7, 11));
        System.out.println(tdHueristics.checkWhetherTDisPossible(integers, 8, 11));
    }

    @Test
    public void deductXFromElementsInAGivenRange() throws Exception {
        List<Integer> integers = new ArrayList<>();
        integers.add(0);
        integers.add(3);
        integers.add(5);
        integers.add(6);
        integers.add(10);
        integers.add(14);
        integers.add(15);
        integers.add(17);
        integers.add(18);
        integers.add(25);
        tdHueristics.deductXFromElementsInAGivenRange(integers, 4, 7, 14);
        System.out.println(integers);
    }

    @Test
    public void searchTargetInaRange() {
        List<Integer> integers = new ArrayList<>();
        integers.add(0);
        integers.add(3);
        integers.add(5);
        integers.add(6);
        integers.add(10);
        integers.add(14);
        integers.add(15);
        integers.add(17);
        integers.add(18);
        integers.add(25);
        System.out.println(tdHueristics.searchTargetInaRange(integers, 7, 9));
        System.out.println(tdHueristics.searchTargetInaRange(integers, 7, 10));
        System.out.println(tdHueristics.searchTargetInaRange(integers, 6, 10));
        System.out.println(tdHueristics.searchTargetInaRange(integers, 25, 30));
        System.out.println(tdHueristics.searchTargetInaRange(integers, 26, 30));
        System.out.println(tdHueristics.searchTargetInaRange(integers, 11, 13));
        System.out.println(tdHueristics.searchTargetInaRange(integers, 11, 16));
        System.out.println(tdHueristics.searchTargetInaRange(integers, 23, 25));
        System.out.println(tdHueristics.searchTargetInaRange(integers, 7, 7));
        System.out.println(tdHueristics.searchTargetInaRange(integers, 6, 6));
    }
}