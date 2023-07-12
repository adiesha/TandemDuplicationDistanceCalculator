package org.msu.adiesha.utils;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class GenerateRandomGenomicDataTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void generateString() {
        System.out.println(GenerateRandomGenomicData.generateString(20));
        Assert.assertEquals(20, GenerateRandomGenomicData.generateString(20).length());
    }

    @Test
    public void generateSourceAndTargetStrings() {
        GenerateRandomGenomicData.TwoStringsDTO twoStringsDTO = GenerateRandomGenomicData.generateSourceAndTargetStrings(25, 50);
        System.out.println(twoStringsDTO.source);
        System.out.println(twoStringsDTO.target);
        Assert.assertEquals(25, twoStringsDTO.source.length());
        Assert.assertEquals(50, twoStringsDTO.target.length());
    }
    @Test
    public void createSyntheticDataAndWriteToAFile() throws IOException {

        GenerateRandomGenomicData.createSyntheticDataAndWriteToAFile(10, 20, "data/data1.txt", false);
        GenerateRandomGenomicData.createSyntheticDataAndWriteToAFile(10, 20, "data/data1.txt", true);
        GenerateRandomGenomicData.createSyntheticDataAndWriteToAFile(30000, 60000, "data/data1.txt", true);
    }
}