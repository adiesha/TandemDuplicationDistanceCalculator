package org.msu.adiesha;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LZ77UnW {
    private String T;
    private StringBuilder initialBuffer;
    private String S;

    private List<TupleO> output;

    static class TupleO {
        int offset = 0;
        int size = 0;
        char c;

        @Override
        public String toString() {
            return "TupleO{" +
                    "offset=" + offset +
                    ", size=" + size +
                    ", c=" + c +
                    '}';
        }
    }

    public LZ77UnW(String S, String T) {


    }

    public void compress(String source, String target) {

        this.output = new ArrayList<>();
        this.T = target;
        this.S = source;
        if (!source.isEmpty()) {
            this.T = new StringBuilder(source).append("|").append(target).toString();
        }
        this.initialBuffer = new StringBuilder();
//        this.initialBuffer.append(S);
        StringBuilder lookaheadbuffer = new StringBuilder();
        TupleO last = new TupleO();
        output.add(last);
        for (char c : this.T.toCharArray()) {
            lookaheadbuffer.append(c);

            int index = initialBuffer.indexOf(lookaheadbuffer.toString());
            if (index == -1) {
                // does not contain the look ahead buffer in the initial buffer
                // add char to the initial buffer and remove char from lookahead buffer
                initialBuffer.append(lookaheadbuffer);
                lookaheadbuffer.setLength(0);
                last.c = c;
                last = new TupleO();
                this.output.add(last);

            } else {
                // which means we found a match
                last.offset = index;
                last.size = lookaheadbuffer.length();

            }
        }
    }


    public List<TupleO> getOutput() {
        return this.output;
    }

    public void printCompressedOutput() {
        for (TupleO t : this.output) {
            System.out.print(t + "\t");
        }
        System.out.println();
        for (TupleO t: this.output) {

        }
    }
}
