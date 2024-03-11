package org.msu.adiesha.utils;

import java.util.Map;

public class Trie {

    private TrieNode root = null;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        Map<Character, TrieNode> children = root.getChildren();
        if (word.isEmpty())
            root.setWord(true);
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TrieNode node;
            if (children.containsKey(c)) {
                node = children.get(c);
            } else {
                node = new TrieNode(c);
                children.put(c, node);
            }
            children = node.getChildren();

            if (i == word.length() - 1)
                node.setWord(true);
        }
    }


    // should we let them enter empty word?

    /**
     * Given a string, this method will access the Trie and returns true if the word exists as a word in the trie. Note
     * that this will not return true if the word exists as a prefix. If you need to search the prefix use searchPrefix()
     * method. If the empty string was inserted, then this method will return true, for the empty string.
     *
     * @param word
     * @return
     */
    public boolean search(String word) {
        Map<Character, TrieNode> children = root.getChildren();

        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (children.containsKey(c)) {
                node = children.get(c);
                children = node.getChildren();
            } else {
                // did not find the character, return false
                return false;
            }
        }
        return node != null && node.isWord();

    }

    public boolean searchPrefix(String prefix) {
        Map<Character, TrieNode> children = root.getChildren();
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);

            if (children.containsKey(c)) {
                node = children.get(c);
                children = node.getChildren();
            } else {
                return false;
            }
        }
        return node != null;
    }


    /**
     * This method will access the substring source[i:] and try to match the longest prefix of the source[i:] and will
     * return the length of the max prefix of the chosen substrings
     *
     * @param target target string that we need to match the prefix of
     * @param index      the starting index of the matching substring
     * @return returns the size of the max prefix we can match
     */
    public int findMaxPrefix(String target, int index) {
        Map<Character, TrieNode> children = root.getChildren();
        TrieNode node = root;
        int count = 0;
        // starting from the ith index
        for (int j = index; j < target.length(); j++) {
            char c = target.charAt(j);
            if (children.containsKey(c)) {
                count++;
                node = children.get(c);
                children = node.getChildren();
            } else {
                return count;
            }
        }
        return count;
    }


}
