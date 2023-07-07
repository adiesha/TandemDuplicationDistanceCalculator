package org.msu.adiesha.utils;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LCSTest {
    private LCS lcs;

    @Before
    public void setUp() throws Exception {
        lcs = new LCS();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void lcs() {
        LCS.lcs("ACGTACG", "AAGAGTACG", 7, 9);
        LCS.lcs("AGTCGAAGTAAGTTG", "AGTCGAAGTAAAAGTAAGTTG", "AGTCGAAGTAAGTTG".length(), "AGTCGAAGTAAAAGTAAGTTG".length());


    }
}