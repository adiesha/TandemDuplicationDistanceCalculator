package org.msu.adiesha.utils;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class StabilizedPermutationsTest {

    @Test
    public void getStabilizedPermutations() {
        System.out.println(StabilizedPermutations.getStabilizedPermutations("aaaaddsssfg", "gggssdsaafaaa"));
        System.out.println(StabilizedPermutations.getStabilizedPermutations("TasddaTTtt", "TssssdaaTTtdtt"));
        System.out.println(StabilizedPermutations.getStabilizedPermutations("aaaaddsssfg", "gggssdsaafaaa"));
        StabilizedPermutations.StabilizedPermsDTO stabilizedPermsDTO =
                StabilizedPermutations.getStabilizedPermutations("122321124325", "5452321243215415");
        Assert.assertEquals("12232112444325555", stabilizedPermsDTO.source_stab);
        Assert.assertEquals("54523212432215415", stabilizedPermsDTO.target_stab);
        Assert.assertEquals(5, stabilizedPermsDTO.source_additions);
        Assert.assertEquals(1, stabilizedPermsDTO.target_reduction);







    }
}