package org.msu.adiesha.utils;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TrieTest {

    Trie trie = new Trie();

    @Before
    public void setUp() throws Exception {
        trie.insert("asdfkjhTERfsdfjasgdfg");
    }

    @After
    public void tearDown() throws Exception {
        trie = null;

    }

    @Test
    public void insert() {
        trie.insert("asdfkjhTERfsdfjasgdfg");
        Assert.assertTrue(trie.search("asdfkjhTERfsdfjasgdfg"));
        Assert.assertFalse(trie.search(""));
        trie.insert("");
        Assert.assertTrue(trie.search(""));
        System.out.println("------------");
    }

    @Test
    public void search() {
        Assert.assertFalse(trie.search("asdf"));
        System.out.println("Looking for empty string before the empty string insertion");
        Assert.assertFalse(trie.search(""));
        trie.insert("");
        System.out.println("Searching for empty string after empty string was inserted");
        Assert.assertTrue(trie.search(""));

    }

    @Test
    public void searchPrefix() {
        System.out.println(trie.searchPrefix("aaasaaa"));
        Assert.assertFalse(trie.searchPrefix("aaaaaa"));
        System.out.println(trie.searchPrefix("asdf"));
        Assert.assertTrue(trie.searchPrefix("asdf"));
        System.out.println(trie.searchPrefix(""));
        Assert.assertTrue(trie.searchPrefix(""));
        System.out.println("$$$$$$$$$$$$$$$");
    }

    @Test
    public void findMaxPrefix() {
        trie = new Trie();
        trie.insert("ADFBSCGSGS");
        System.out.println(trie.findMaxPrefix("DFGDADD", 1));
        System.out.println(trie.findMaxPrefix("DFGDADD", 4));
        trie.insert("");
        System.out.println(trie.findMaxPrefix("DFGDADD", 6));
        System.out.println(trie.findMaxPrefix("DFGDADD", 7));
    }
}