package org.msu.adiesha.utils;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class UtilsTest {

    @Test
    public void checkAlphabet() {

        String source = "ab";
        String target = "abc";
        System.out.println(Utils.checkAlphabet(source, target));
        Assert.assertFalse(Utils.checkAlphabet(source, target));

        source = "asdfasdfjhhjjgsahdfhagshdfgajhhajhsgdfhgsahfgsahjdfrtt";
        target = "safakjshfksjhdfjhaashhsadfhjsahdkjfhkjdshfjgttttsajhdgfjhsgd";
        System.out.println(Utils.checkAlphabet(source, target));


        source = "abc";
        target = "ab";
        System.out.println(Utils.checkAlphabet(source, target));
        Assert.assertFalse(Utils.checkAlphabet(source, target));

        source = "ab";
        target = "ba";
        System.out.println(Utils.checkAlphabet(source, target));
        Assert.assertTrue(Utils.checkAlphabet(source, target));

        source = "afdssdfsdfsdfssreree";
        target = "asdfsadfsdfsafdsadfrr";
        System.out.println(Utils.checkAlphabet(source, target));
        Assert.assertFalse(Utils.checkAlphabet(source, target));

        // same alphabet
        source = "asdfsdafasdfsadfsadfwerwqrwqwrqewerwerwq";
        target = "asdfrewq";
        System.out.println(Utils.checkAlphabet(source, target));
        Assert.assertTrue(Utils.checkAlphabet(source, target));
    }
}