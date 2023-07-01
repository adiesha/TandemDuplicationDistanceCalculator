package org.msu.adiesha;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LZ77UpdatedTest {

    private LZ77Updated lz77Updated;

    @Before
    public void setUp() throws Exception {
        lz77Updated = new LZ77Updated();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void compress() {
        lz77Updated.compress("vwxyz", "zyxwv");
        lz77Updated.compress("vwxyz", "zyxwvvw");
        lz77Updated.compress("vwxyz", "zyxwvvw");
    }
}