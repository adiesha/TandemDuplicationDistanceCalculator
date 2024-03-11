package org.msu.adiesha.utils;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    private char c;
    private boolean isWord;
    private Map<Character, TrieNode> children = new HashMap<>();

    public TrieNode() {

    }
    public TrieNode(char c) {
        this.c = c;
    }

    public Map<Character, TrieNode> getChildren() {
        return this.children;
    }

    public void setChildren(Map<Character, TrieNode> map) {
        this.children = map;
    }

    public boolean isWord() {
        return this.isWord;
    }

    public void setWord(boolean word) {
        this.isWord = word;
    }


}
