package org.msu.adiesha.utils;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SuffixTreeTest {

    SuffixTree suffixTree;
    @Before
    public void setUp() throws Exception {
        suffixTree = new SuffixTree();
    }

    @Test
    public void findMaxPrefix() {
        suffixTree.populate("abcdgdf");
        Assert.assertEquals(0, suffixTree.findMaxPrefix("", 0));
        Assert.assertEquals(1, suffixTree.findMaxPrefix("f", 0));
        Assert.assertEquals(2, suffixTree.findMaxPrefix("df", 0));
        Assert.assertEquals(3, suffixTree.findMaxPrefix("gdf", 0));
        Assert.assertEquals(4,suffixTree.findMaxPrefix("dgdf", 0));
        Assert.assertEquals(5,suffixTree.findMaxPrefix("cdgdf", 0));
        Assert.assertEquals(6, suffixTree.findMaxPrefix("bcdgdf", 0));
        Assert.assertEquals(7, suffixTree.findMaxPrefix("abcdgdf", 0));
        Assert.assertEquals(5, suffixTree.findMaxPrefix("abcdgdf", 2));
        Assert.assertEquals(0, suffixTree.findMaxPrefix("sadff", 0));
        Assert.assertEquals(0,suffixTree.findMaxPrefix("sdfsd", 0));
        Assert.assertEquals(1, suffixTree.findMaxPrefix("asdfsdfa", 0));
        Assert.assertEquals(2, suffixTree.findMaxPrefix("abdfsdfa", 0));
        Assert.assertEquals(3, suffixTree.findMaxPrefix("cdga", 0));
        Assert.assertEquals(2, suffixTree.findMaxPrefix("acdga", 2));

    }


}