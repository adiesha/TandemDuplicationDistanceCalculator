package org.msu.adiesha.utils;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.util.Random;

public class GenerateRandomGenomicData {

    public static class TwoStringsDTO {
        public String source;
        public String target;
    }

    public static String generateString(int length) {
        String[] array = new String[]{"A", "C", "G", "T"};

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int rnd = new Random().nextInt(array.length);
            stringBuilder.append(array[rnd]);
        }

        return stringBuilder.toString();
    }

    public static TwoStringsDTO generateSourceAndTargetStrings(int sourceLength, int targetLength) {
        TwoStringsDTO twoStringsDTO = new TwoStringsDTO();
        twoStringsDTO.source = generateString(sourceLength);
        twoStringsDTO.target = generateString(targetLength);
        return twoStringsDTO;
    }

    public static void createSyntheticDataAndWriteToAFile(int sourceLength, int targetLength, String fileName, boolean override) throws IOException {
        File writeFile = new File(fileName);
        if (!override) {
            System.out.println("Checking whether data file already exists");
            if (writeFile.exists() && !writeFile.isDirectory()) {
                System.out.println("File exists.. aborting");
            }
        }
        TwoStringsDTO twoStringsDTO = generateSourceAndTargetStrings(sourceLength, targetLength);
        PrintWriter writer = new PrintWriter(fileName);
        writer.println(twoStringsDTO.source);
        writer.println(twoStringsDTO.target);
        writer.close();


    }
}
