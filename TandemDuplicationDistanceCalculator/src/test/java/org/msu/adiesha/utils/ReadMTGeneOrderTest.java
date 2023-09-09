package org.msu.adiesha.utils;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class ReadMTGeneOrderTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void readGeneOrderFromCustomFiles() {
        List<String> geneOrder = ReadMTGeneOrder.readGeneOrderFromCustomFiles("data/mitochondrialdna/Samariscis_Latus/Samariscus_latusMTfastaFile_final.txt");
        System.out.println(geneOrder);
        Map<String, Character> out = ReadMTGeneOrder.assignCharsToStringList(geneOrder);
        System.out.println(out);
        System.out.println("++++++++++++++++");
        System.out.println(ReadMTGeneOrder.getTheChangedOutput(geneOrder, out));

    }
}

//YXWVUTSRQPONMLKJIHGFEDCBAzyxwvutsrqponPOm