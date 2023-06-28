package org.msu.adiesha;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LZWTest {

    private LZW lzw;

    @Before
    public void setUp() throws Exception {
        lzw = new LZW();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void compress() {
        lzw.compress("", "ACGTTTTTTT");
        System.out.println();
        lzw.printcompressed();

    }
}