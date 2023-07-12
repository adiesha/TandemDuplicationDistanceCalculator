package org.msu.adiesha;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.msu.adiesha.utils.ReadInput;

import static org.junit.Assert.*;

public class LZ77WithMultiWindowTest {
    private LZ77WithMultiWindow lz77WithMultiWindow;

    @Before
    public void setUp() throws Exception {
        lz77WithMultiWindow = new LZ77WithMultiWindow();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void compress() {
        lz77WithMultiWindow.compress("acgt", "actgta");
        lz77WithMultiWindow.printCompressed();

        lz77WithMultiWindow.compress("vwxyz", "zyxwv");
        lz77WithMultiWindow.printCompressed();
        lz77WithMultiWindow.compress("vwxyz", "zyxwvvw");
        lz77WithMultiWindow.printCompressed();
        lz77WithMultiWindow.compress("vwxyz", "zyxwvvw");
        lz77WithMultiWindow.printCompressed();
        lz77WithMultiWindow.compress("vwxyz", "wvxwyxzyyxwxwvzyxzyxwyxwvzyxwv");
        lz77WithMultiWindow.printCompressed();
        lz77WithMultiWindow.compress("zyxwv", "wvxwyxzyyxwxwvzyxzyxwyxwvzyxwv");
        lz77WithMultiWindow.printCompressed();
        lz77WithMultiWindow.compress("ACCCGGGACGATTAACGAGGAT", "ACTGGTTGACTTATCCATGAGATATTAACGAATTTTATTAATTAACAACCAACCAACGA");
        lz77WithMultiWindow.printCompressed();
        lz77WithMultiWindow.compress("ACGTACG", "AAGAGTACG");
        lz77WithMultiWindow.printCompressed();
        lz77WithMultiWindow.compress("AGTCGAAGTAAGTTG", "AGTCGAAGTAAGTAGTG");
        lz77WithMultiWindow.printCompressed();
        lz77WithMultiWindow.compress("AGTCGAAGTAAGTAGTG", "AGTCGAAGTAAGTTG");
        lz77WithMultiWindow.printCompressed();
        lz77WithMultiWindow.compress("ACGT", "TGCA");
        lz77WithMultiWindow.printCompressed();

        lz77WithMultiWindow.compress("ACGTCGGCATGACTACGTATCGATGCTAGCTAGTGCGGGCCTATGCATCGATGCTAGCTGATGCTAGCTGATGCTAGCGATGCAGTCGATGC", "AAAACACGATCGTAGCTAGCTAGTCGATGCATGCTGATCGATGCTAGCTAGATGCATGATGCACTACGTATCGATGCTAGCTAGTGCGGGCCTATGCATCGATGCTAGCTGATGCTAGCTGATGCTATATGCATGCTAGCTAGCATGCTAGCATGCTAGCTAGTCGATGCATGAGCTAGTAGTCGATGATCGATGACT");
        lz77WithMultiWindow.printCompressed();

        lz77WithMultiWindow.compress("ACGTCGGCATGACTACGTATCGATGCTAGCTAGTGCGGGCCTATGCATCGATGCTAGCTGATGCTAGCTGATGCTAGCGATGCAGTCGATGC", "AAAACACGATCGTAGCTAGCTAGTCGATGCATGCTGATCGATGCTAGCTAGATGCATGATGCATGCTGAATATTATATCGATGCTAGCTGATCGTAGCTAGTACGTAGCTAGTAGCATGCTAGCTAGTCGATGTAGCATCGATGCTAGATGATGCTAGCTCAATATATATCGGCGACGCAGATGTATGCATGCTAGCTAGCATGCTAGCATGCTAGCTAGTCGATGCATGAGCTAGTAGTCGATGATCGATGACT");
        lz77WithMultiWindow.printCompressed();

        lz77WithMultiWindow.compress("ACGTCGGCATGACTACGTATCGATGCTAGCTAGTGCGGGCCTATGCATCGATGCTAGCTGATGCTAGCTGATGCTAGCGATGCAGTCGATGC", "ACGTCGGCATGAGGCATGATGACTACGTATCGTATATCGATGCTAGCTAGTGTATGCATGATTGATTGATTGATTGATTGATGCTAGCGATAGCGATAGCTCGATGC");
        lz77WithMultiWindow.printCompressed();

        lz77WithMultiWindow.compress("ACGTCGGCATGACTACGTATCGATGCTAGCTAGTGCGGGCCTATGCATCGATGCTAGCTGATGCTAGCTGATGCTAGCGATGCAGTCGATGC", "ACGTCGGCATGAGCATGACTACGTATCGTATCGATGCTAGCTAGTGCGGGCCTATGCATCGATGCTAGCATGATGCTGATGCATGATGCTAGCGATAGCGATAGCTCGATGC");
        lz77WithMultiWindow.printCompressed();

        lz77WithMultiWindow.compress("ACGTCGGCATGACTACGTATCGATGCTAGCTAGTGCGGGCCTATGCATCGATGCTAGCTGATGCTAGCTGATGCTAGCGATGCAGTCGATGC", "ACGATCGTAGCTAGCTAGTCGATGCATGCTGATCGATGCTAGCTAGATGCATGATGCATGCTGATATCGATGCTAGCTGATCGTAGCTAGTACGTAGCTAGTAGCATGCTAGCTAGTCGATGTAGCATCGATGCTAGATGCTAGCTCATCGCGACGCAGATGTATGCATGCTAGCTAGCATGCTAGCATGCTAGCTAGTCGATGCATGAGCTAGTCGATGACT");
//        lz77WithMultiWindow.printCompressed();

        long startTime = System.currentTimeMillis();
        ReadInput.SourceAndTarget data = ReadInput.readInput("data/data1.txt");
        lz77WithMultiWindow.compress(data.getSource(), data.getTarget());
        System.out.println("Number of phrases: " + lz77WithMultiWindow.getNumberOfPhrases());
        long endTime = System.currentTimeMillis();
        System.out.println("Elapsed time: " + (endTime-startTime)/1000 + " seconds");
        System.out.println("---------------------------");
        lz77WithMultiWindow.printCompressed();

    }
}