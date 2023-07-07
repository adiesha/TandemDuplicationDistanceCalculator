package org.msu.adiesha;

import org.msu.adiesha.interfaces.Compressor;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LZ77Updated implements Compressor {

    private String T;
    private String Target;
    private StringBuilder initialBuffer;
    private String S;

    private List<Tuple1> output;

    static class Tuple1 {
        int index = 0;
        int size = 0;


        @Override
        public String toString() {
            return "TupleO{" +
                    "index=" + index +
                    ", size=" + size +
                    '}';
        }
    }

    public LZ77Updated() {

    }

    public void compress(String source, String target) {
        this.output = new ArrayList<>();
        this.Target = target;
        this.T = target;
        this.S = source;
        if (!source.isEmpty()) {
            this.S = new StringBuilder(source).append("|").toString();
        }
//        extractAlphabetAndFillInitialOutput();
        this.initialBuffer = new StringBuilder();
        this.initialBuffer.append(this.S);
        StringBuilder string = new StringBuilder();
//        string.append(this.T.charAt(0));
        string.append(this.T.charAt(0));
        int i = 1;
        while (i < this.T.length()) {
            char symbol = this.T.charAt(i);
            int index = this.initialBuffer.lastIndexOf(string.toString() + symbol);
            if (index != -1) {
                string.append(symbol);
                i++;
            } else {

                if (!string.isEmpty()) {
                    Tuple1 last = new Tuple1();
                    last.index = this.initialBuffer.lastIndexOf(string.toString());
                    last.size = string.length();
                    this.output.add(last);
                }
                initialBuffer.append(string.toString());
                string.setLength(0);
                string.append(symbol);
                i++;
            }
        }
        if (!string.isEmpty()) {
            Tuple1 last = new Tuple1();
            last.index = this.initialBuffer.lastIndexOf(string.toString());
            last.size = string.length();
            this.output.add(last);
        }


    }


    public void printCompressed() {
        String sss = this.S + this.Target;
        System.out.println("Number of phrases: " + this.output.size());
        for (Tuple1 tuple1 : this.output) {
            System.out.print(sss.substring(tuple1.index, tuple1.index + tuple1.size) + ",");
        }
        System.out.println();
    }

    public int getNumberOfPhrases() {
        return this.output.size();
    }

}
