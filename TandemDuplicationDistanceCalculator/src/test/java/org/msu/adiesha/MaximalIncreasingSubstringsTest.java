package org.msu.adiesha;

import org.junit.Assert;
import org.junit.Test;

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

    @Test
    public void checkAlphabet() {

        String source = "ab";
        String target = "abc";
        System.out.println(MaximalIncreasingSubstrings.checkAlphabet(source, target));
        Assert.assertFalse(MaximalIncreasingSubstrings.checkAlphabet(source, target));

        source = "asdfasdfjhhjjgsahdfhagshdfgajhhajhsgdfhgsahfgsahjdfrtt";
        target = "safakjshfksjhdfjhaashhsadfhjsahdkjfhkjdshfjgttttsajhdgfjhsgd";
        System.out.println(MaximalIncreasingSubstrings.checkAlphabet(source, target));


        source = "abc";
        target = "ab";
        System.out.println(MaximalIncreasingSubstrings.checkAlphabet(source, target));
        Assert.assertFalse(MaximalIncreasingSubstrings.checkAlphabet(source, target));

        source = "ab";
        target = "ba";
        System.out.println(MaximalIncreasingSubstrings.checkAlphabet(source, target));
        Assert.assertTrue(MaximalIncreasingSubstrings.checkAlphabet(source, target));

        source = "afdssdfsdfsdfssreree";
        target = "asdfsadfsdfsafdsadfrr";
        System.out.println(MaximalIncreasingSubstrings.checkAlphabet(source, target));
        Assert.assertFalse(MaximalIncreasingSubstrings.checkAlphabet(source, target));

        // same alphabet
        source = "asdfsdafasdfsadfsadfwerwqrwqwrqewerwerwq";
        target = "asdfrewq";
        System.out.println(MaximalIncreasingSubstrings.checkAlphabet(source, target));
        Assert.assertTrue(MaximalIncreasingSubstrings.checkAlphabet(source, target));
    }
}