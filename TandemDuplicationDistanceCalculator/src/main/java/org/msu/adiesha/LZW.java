package org.msu.adiesha;

import org.msu.adiesha.interfaces.Compressor;

import java.util.*;

public class LZW implements Compressor {
    private Map<String, Integer> phrases;
    private String S;
    private String T;
    private int count = 0;


    public LZW() {
        initialize();
    }

    private void initialize() {
        phrases = new HashMap<>();
        this.count = 0;
    }


    public void compress(String source, String target) {
        initialize();

        if (source.isEmpty()) {
            this.T = target;
        } else {
            this.T = S + "|" + target;
        }
        extractAlphabet();
        StringBuilder stringcode = new StringBuilder();
        stringcode.append(this.T.charAt(0));
        int i = 1;
        while (i < this.T.length()) {
            char symbol = this.T.charAt(i);
            if (phrases.containsKey(stringcode.toString() + symbol)) {
                // append the next character by continuing
                stringcode.append(symbol);
            } else {
                System.out.print(this.phrases.get(stringcode.toString()) + ",");
                count++;
                phrases.put(stringcode.toString() + symbol, count);
                stringcode.setLength(0);
                stringcode.append(symbol);
            }
            i++;
        }
        if (!stringcode.isEmpty()) {
            System.out.println(this.phrases.get(stringcode.toString()) + ",");
            stringcode.setLength(0);
        }

    }

    private void extractAlphabet() {
        Set<Character> chars = new HashSet<>();
        for (char c : this.T.toCharArray()) {
            if (!chars.contains(c)) {
                chars.add(c);
            }
        }
        List<Character> sortedList = new ArrayList<>(chars);
        Collections.sort(sortedList);
        System.out.println(sortedList);
        for (Character c : sortedList) {
            this.count++;
            this.phrases.put(String.valueOf(c), this.count);
        }
    }

    public void printcompressed() {
        System.out.println(this.phrases);
    }


}
