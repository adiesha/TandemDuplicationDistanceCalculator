package org.msu.adiesha;

import org.msu.adiesha.interfaces.Compressor;

import java.util.ArrayList;
import java.util.List;

public class LZ77UnW implements Compressor {
    private String T;
    private String Target;
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

    public LZ77UnW() {


    }

    public void compress(String source, String target) {

        this.output = new ArrayList<>();
        this.Target = target;
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
        // removing unnecessary empty char at the end
        if (this.output.get(this.output.size() - 1).c == 0 && this.output.get(this.output.size() - 1).size == 0) {
            this.output.remove(this.output.size() - 1);
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
        System.out.println("Number of phrases " + this.output.size());
    }

    public void printTDDuplications() {
        System.out.println(this.S);
        System.out.println(this.Target);
        System.out.println(this.T);

        StringBuilder output = new StringBuilder();
        for (TupleO t : this.output) {

            output.append(this.T, t.offset, t.offset + t.size).append(t.c);
            System.out.println(output);
        }
    }
}
