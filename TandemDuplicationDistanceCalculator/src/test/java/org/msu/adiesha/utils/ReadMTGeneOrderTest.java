package org.msu.adiesha.utils;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.msu.adiesha.LZ77Updated;

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
        List<String> geneOrder_sam_latus = ReadMTGeneOrder.readGeneOrderFromCustomFiles("data/mitochondrialdna/Samariscis_Latus/Samariscus_latusMTfastaFile_final.txt");
        List<String> geneOrder_sym_ori = ReadMTGeneOrder.readGeneOrderFromCustomFiles("data/mitochondrialdna/Symphurus_orientalis/Symphurus_orientalis.txt");
        List<String> geneOrder_sym_pl = ReadMTGeneOrder.readGeneOrderFromCustomFiles("data/mitochondrialdna/Symphurus_plagiusa/Symphurus_plagiusa.txt");


        System.out.println(geneOrder_sam_latus);
        Map<String, Character> out = ReadMTGeneOrder.assignCharsToStringList(geneOrder_sam_latus);
        System.out.println(out);
        System.out.println("----------------");
        System.out.println(ReadMTGeneOrder.checkWhetherStringsContainSameCharacters("acbacbacbbacbdd", "abcacbbbcabcabcdbba"));
        System.out.println(ReadMTGeneOrder.checkWhetherStringsContainSameCharacters("acbacrtrtbacbbacbdd", "abcwacbbbcabcabcbba"));

        System.out.println("++++++++++++++++");
        System.out.println(ReadMTGeneOrder.getTheChangedOutput(geneOrder_sam_latus, out));
        System.out.println(ReadMTGeneOrder.getTheChangedOutput(geneOrder_sym_ori, out));

        System.out.println("===========================================");
        out = ReadMTGeneOrder.assignCharsToStringList(geneOrder_sym_ori);
        System.out.println(out);
        System.out.println(ReadMTGeneOrder.getTheChangedOutput(geneOrder_sym_pl, out));
        System.out.println(ReadMTGeneOrder.getTheChangedOutput(geneOrder_sym_ori, out));


        System.out.println(ReadMTGeneOrder.isSubsequence("aggtc", "ttsttajjjgtttgsstchh"));
        System.out.println(ReadMTGeneOrder.isSubsequence("aggtc", "ttsttajjjgtttgssthh"));


        LZ77Updated lz77Updated = new LZ77Updated();
        lz77Updated.compress("rstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZabc", "rsvtwxyzuABCDEFGHIJKLMNOPQRSTUVWXYZabc");
        lz77Updated.printCompressed();
        System.out.println(ReadMTGeneOrder.getSubsequenceTuples(lz77Updated.getOutput(), "rstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZabc"));
        System.out.println(ReadMTGeneOrder.getSubsequenceTuples(lz77Updated.getOutput(), "rstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZabcrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZabc"));

        lz77Updated.compress("abcdefghpqrs", "abcprsfghcdeq");
        lz77Updated.printCompressed();

        List<List<LZ77Updated.Tuple1>> r = ReadMTGeneOrder.getSubsequenceTuples(lz77Updated.getOutput(), "abcdefghpqrsabcdefghpqrs");
        System.out.println(r);

        System.out.println("+_+_+_+_+_+_+_+_+_+_+_");
        out = ReadMTGeneOrder.assignCharsToStringList(geneOrder_sym_ori);
//        System.out.println(ReadMTGeneOrder.getTheChangedOutput(geneOrder_sym_ori, out));
        String str1 = ReadMTGeneOrder.getTheChangedOutput(geneOrder_sym_ori, out);
        String str2 = ReadMTGeneOrder.getTheChangedOutput(geneOrder_sym_pl, out);
        System.out.println(str1);
        System.out.println(str2);
        lz77Updated.compress(str1, str2);
        lz77Updated.printCompressed();
        System.out.println(ReadMTGeneOrder.getSubsequenceTuples(lz77Updated.getOutput(), str1 + str1));
        List<List<LZ77Updated.Tuple1>> tuples = ReadMTGeneOrder.getSubsequenceTuples(lz77Updated.getOutput(), str1 + str1);
        System.out.println("# of TDs = " + tuples.size());
        int dels = 0;
        for (List<LZ77Updated.Tuple1> t : tuples) {
            dels = dels + t.size() + 1;
        }

        System.out.println("# of Deletions = " + dels);
    }
}

//YXWVUTSRQPONMLKJIHGFEDCBAzyxwvutsrqponPOm