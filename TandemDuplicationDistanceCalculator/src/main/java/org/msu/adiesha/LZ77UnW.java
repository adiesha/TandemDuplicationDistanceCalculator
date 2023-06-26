package org.msu.adiesha;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LZ77UnW {
    private String T;
    private Map<String, Integer> stringMap;
    private StringBuilder initialBuffer;


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
        this.T = T;
        this.initialBuffer = new StringBuilder();
        this.initialBuffer.append(S);
        stringMap = new HashMap<>();
        this.output = new ArrayList<>();
    }

    public void compress(String S, String T) {
        StringBuilder lookaheadbuffer = new StringBuilder();
        TupleO last = new TupleO();
        output.add(last);
        for (char c : T.toCharArray()) {
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
        for (TupleO t: this.output) {
            System.out.print(t + "\t");
        }
        return this.output;
    }
}
