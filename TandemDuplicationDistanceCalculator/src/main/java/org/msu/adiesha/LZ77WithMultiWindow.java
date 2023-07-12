package org.msu.adiesha;

import org.msu.adiesha.interfaces.Compressor;
import org.msu.adiesha.utils.Colors;

import java.util.ArrayList;
import java.util.List;

public class LZ77WithMultiWindow implements Compressor {
    private String T;
    private StringBuilder initialBuffer;
    private StringBuilder currentBuffer;
    private String S;

    private List<Tuple1> output;

    static class Tuple1 {
        int index = 0;
        int size = 0;
        boolean isInitialBuffer = true;

        int positionOfTargetInsertion;

        @Override
        public String toString() {
            return "TupleO{" +
                    "index=" + index +
                    ", size=" + size +
                    ", isInitialBuffer" + isInitialBuffer +
                    ", positionOfTargetInsertion" + positionOfTargetInsertion +
                    '}';
        }
    }

    public LZ77WithMultiWindow() {

    }


    public void compress(String source, String target) {
        this.output = new ArrayList<>();
        this.T = target;
        this.S = source;

        System.out.println("Starting to find the LZ77 greedy phrases using multiple windows algorithm");
        System.out.println("Length of the source string is " + source.length());
        System.out.println("Length of the target string is " + target.length());

        this.initialBuffer = new StringBuilder();
        this.currentBuffer = new StringBuilder();
        this.initialBuffer.append(this.S);

        StringBuilder string = new StringBuilder();
        string.append(this.T.charAt(0));

        int i = 1;
        while (i < this.T.length()) {
            char symbol = this.T.charAt(i);
            int indexFromInitialBuffer = this.initialBuffer.indexOf(string.toString() + symbol);
            int indexFromCurrentBuffer = this.currentBuffer.lastIndexOf(string.toString() + symbol);
            if (indexFromInitialBuffer != -1 || indexFromCurrentBuffer != -1) {
                string.append(symbol);
                i++;
            } else {

                if (!string.isEmpty()) {
                    Tuple1 last = new Tuple1();
                    int ifib = this.initialBuffer.indexOf(string.toString());
                    int ifcb = this.currentBuffer.indexOf(string.toString());
                    last.index = (ifcb != -1) ? ifcb : ifib;
                    last.size = string.length();
                    last.isInitialBuffer = (ifcb != -1) ? false : true;
                    last.positionOfTargetInsertion = i - string.length();
                    this.output.add(last);
                }
                currentBuffer.append(string.toString());
                string.setLength(0);
                string.append(symbol);
                i++;
            }
        }
        if (!string.isEmpty()) {
            Tuple1 last = new Tuple1();
            int ifib = this.initialBuffer.indexOf(string.toString());
            int ifcb = this.currentBuffer.indexOf(string.toString());
            last.index = (ifcb != -1) ? ifcb : ifib;
            last.size = string.length();
            last.isInitialBuffer = (ifcb != -1) ? false : true;
            last.positionOfTargetInsertion = i - string.length();
            this.output.add(last);
        }
    }


    public void printCompressed() {
        System.out.println("------------Printing Compressed String------------");
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder loop = new StringBuilder();
        for (Tuple1 tuple1 : this.output) {
            loop.setLength(0);
            if (tuple1.isInitialBuffer) {
                loop.append(stringBuilder).append(Colors.ANSI_RED).append(this.S, tuple1.index, tuple1.index + tuple1.size).append(Colors.ANSI_RESET);
                stringBuilder.append(this.S, tuple1.index, tuple1.index + tuple1.size);
            } else {
                loop.append(stringBuilder).append(Colors.ANSI_BLUE).append(stringBuilder, tuple1.index, tuple1.index + tuple1.size).append(Colors.ANSI_RESET);
                stringBuilder.append(stringBuilder, tuple1.index, tuple1.index + tuple1.size);
            }
            System.out.println(loop);
        }
        System.out.println(stringBuilder);
        assert this.T.equals(stringBuilder.toString());
    }

    public int getNumberOfPhrases() {
        return this.output.size();
    }
}
