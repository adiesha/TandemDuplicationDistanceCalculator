package org.msu.adiesha;

import jdk.jshell.execution.Util;
import org.junit.Assert;
import org.junit.Test;
import org.msu.adiesha.utils.Utils;

import java.util.List;

public class MaximalIncreasingSubstringsTest {

    @Test
    public void findMaximalIncreasingSubsequences() {

        List<MaximalIncreasingSubstrings.Result> results = MaximalIncreasingSubstrings.findMaximalIncreasingSubsequences("jkahsdkfjhsakjdfkljgfjhsagdfgshdafgjhsgdfjsaflsjagdfsjahfgdkjsgjj", "hakjshfggggsdhjfgjhsgajdfkgjasdhfljhasfgd");
        String source = "jkahsdkfjhsakjdfkljgfjhsagdfgshdafgjhsgdfjsaflsjagdfsjahfgdkjsgjj";
        String target = "hakjshfggggsdhjfgjhsgajdfkgjasdhfljhasfgd";
        System.out.println(results);
        for(MaximalIncreasingSubstrings.Result result: results) {
            System.out.print(target.substring(result.index, result.index + result.size));
            System.out.print(" ,");
        }
        System.out.println();
        System.out.println("------");
        results = MaximalIncreasingSubstrings.findMaximalIncreasingSubsequences("zyxwvutsrqponmlkjihgfedcbaZYXjvWVUTSRQ", "zyxwvutsrqponmlkjihgfedcbaZYXjvWTSVURQ");
        target = "zyxwvutsrqponmlkjihgfedcbaZYXjvWTSVURQ";

        for(MaximalIncreasingSubstrings.Result result: results) {
            System.out.print(target.substring(result.index, result.index + result.size));
            System.out.print(" ,");
        }
        System.out.println();
        System.out.println("------");
        results = MaximalIncreasingSubstrings.findMaximalIncreasingSubsequences("zyxwvutsrqponmlkjihgfedcbaZYXjvWVUTSRQ", "zyxwQRvutsrqponmlkjihgfedcbaZYXjvWVUTSQR");
        source = "zyxwvutsrqponmlkjihgfedcbaZYXjvWVUTSRQ";
        target = "zyxwQRvutsrqponmlkjihgfedcbaZYXjvWVUTSQR";
        System.out.println(source);
        System.out.println(target);
        for(MaximalIncreasingSubstrings.Result result: results) {
            System.out.print(target.substring(result.index, result.index + result.size));
            System.out.print(" ,");
        }


        System.out.println();
        System.out.println("------");
        results = MaximalIncreasingSubstrings.findMaximalIncreasingSubsequences("nmlkjihgfedcbaZYXWVUTSRQPONMLXjKJIHGFE", "nmlkjihgfedcbaZYXWVUTSRQPONMLXjKHGJIFE");
        source = "nmlkjihgfedcbaZYXWVUTSRQPONMLXjKJIHGFE";
        target = "nmlkjihgfedcbaZYXWVUTSRQPONMLXjKHGJIFE";
        System.out.println(source);
        System.out.println(target);
        for(MaximalIncreasingSubstrings.Result result: results) {
            System.out.print(target.substring(result.index, result.index + result.size));
            System.out.print(" ,");
        }

        System.out.println();
        System.out.println("------");
        results = MaximalIncreasingSubstrings.findMaximalIncreasingSubsequences("1234512532", "12345345122532");
        source = "1234512532";
        target = "12345345122532";
        System.out.println(source);
        System.out.println(target);
        for(MaximalIncreasingSubstrings.Result result: results) {
            System.out.print(target.substring(result.index, result.index + result.size));
            System.out.print(" ,");
        }

    }


}