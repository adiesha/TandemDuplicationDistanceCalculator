package org.msu.adiesha.utils;

import java.util.Map;

/**
 * This class will take a string, and put all suffixes in a trie for easy access
 */
public class SuffixTree {

    private Trie trie;

    public SuffixTree() {
        trie = new Trie();
    }

    public SuffixTree(String source) {
        trie = new Trie();

        populate(source);
    }

    public void populate(String source) {
        for (int i = 0; i <= source.length(); i++) {
            trie.insert(source.substring(i));
        }
    }

    /**
     * This method will access the substring source[i:] and try to match the longest prefix of the source[i:] and will
     * return the length of the max prefix of the chosen substrings
     *
     * @param target target string that we need to match the prefix of
     * @param i      the starting index of the matching substring
     * @return returns the size of the max prefix we can match
     */
    public int findMaxPrefix(String target, int i) {
        return trie.findMaxPrefix(target, i);
    }

    public boolean searchSuffix(String target) {
        return trie.search(target);
    }


}
