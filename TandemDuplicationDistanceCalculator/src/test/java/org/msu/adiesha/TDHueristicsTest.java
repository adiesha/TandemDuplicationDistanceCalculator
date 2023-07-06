package org.msu.adiesha;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TDHueristicsTest {

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
    public void checkTDbility() {
        System.out.println(tdHueristics.checkTDbility("TCGAATTTGGAACGACGTTACGAT", 5, 7));
        System.out.println(tdHueristics.checkTDbility("TCGAATTTGGAACGACGTTACGAT", 5, 6));
        System.out.println(tdHueristics.checkTDbility("ACGGACGGTCGAATTTGGAACGACGTTACGAT", 0, 4));
    }
}