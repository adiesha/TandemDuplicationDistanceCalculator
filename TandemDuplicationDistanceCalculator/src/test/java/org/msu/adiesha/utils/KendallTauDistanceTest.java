package org.msu.adiesha.utils;

import org.apache.commons.lang.ArrayUtils;
import org.junit.Test;

import static org.junit.Assert.*;

public class KendallTauDistanceTest {

    @Test
    public void calculateKendallTauDistance() {
        int[] arr = new int[]{1,2,3,4,5,6,7, 9,10,11,18,20};
        Integer[] nums = ArrayUtils.toObject(arr);
        System.out.println(KendallTauDistance.calculateKendallTauDistance(nums));


        arr = new int[]{7, 5, 3, 2, 1, 6, 4};
        nums = ArrayUtils.toObject(arr);
        System.out.println(KendallTauDistance.calculateKendallTauDistance(nums));



        arr = new int[]{1, 3, 2, 5, 4, 6, 7};
        nums = ArrayUtils.toObject(arr);
        System.out.println(KendallTauDistance.calculateKendallTauDistance(nums));


        char[] chars = new char[]{'a','e','u','b','o','c','l','d'};
        Character[] charObj = ArrayUtils.toObject(chars);
        System.out.println(KendallTauDistance.calculateKendallTauDistance(charObj));


        arr = new int[]{10, 2, 3, 4, 5, 6, 1};
        nums = ArrayUtils.toObject(arr);
        System.out.println(KendallTauDistance.calculateKendallTauDistance(nums));
    }
}