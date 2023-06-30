package org.msu.adiesha;

import junit.framework.TestCase;

public class LZ77UnWTest extends TestCase {

    LZ77UnW lz77UnW;

    public void setUp() throws Exception {
        super.setUp();
        lz77UnW = new LZ77UnW();
    }

    public void tearDown() throws Exception {
    }

    public void testCompress() {
        lz77UnW.compress("ACGT", "ACGTAA");
        lz77UnW.printCompressedOutput();

        lz77UnW.compress("", "ACGT|ACGTAA");
        lz77UnW.printCompressedOutput();

        lz77UnW.compress("", "ACGTAA|ACGTAA");
        lz77UnW.printCompressedOutput();

        lz77UnW.compress("", "ACGTAA|ACGTAA");
        lz77UnW.printCompressedOutput();

        lz77UnW.compress("", "vwxyz|wvxwyxzyyxwxwvzyxzyxwyxwvzyxwv");
        lz77UnW.printCompressedOutput();
        lz77UnW.printTDDuplications();

        lz77UnW.compress("", "zyxwv|wvxwyxzyyxwxwvzyxzyxwyxwvzyxwv");
        lz77UnW.printCompressedOutput();
        lz77UnW.printTDDuplications();

        lz77UnW.compress("", "vwxyz|zyxwv");
        lz77UnW.printCompressedOutput();
        lz77UnW.printTDDuplications();





    }
}