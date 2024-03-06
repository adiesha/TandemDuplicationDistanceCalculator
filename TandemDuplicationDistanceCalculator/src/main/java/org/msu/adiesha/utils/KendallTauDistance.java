package org.msu.adiesha.utils;

import org.apache.commons.lang.ArrayUtils;

import java.util.Arrays;

public class KendallTauDistance {

    public static void main(String[] args) {
        int[] nums = new int[]{7, 5, 3, 2, 1, 6, 4};
        Integer[] arr = ArrayUtils.toObject(nums);
        System.out.println(calculateKendallTauDistance(arr));
    }

    public static int calculateKendallTauDistance(Comparable[] nums) {
        return mergeSort(nums, nums.length);

    }

    private static int mergeSort(Comparable[] nums, int n) {
        if (n < 2)
            return 0;
        int mid = n / 2;
        Comparable[] left = new Comparable[mid]; // 0..mid-1
        System.arraycopy(nums, 0, left, 0, left.length);
        Comparable[] right = new Comparable[n - mid];  // mid ... n-1
        System.arraycopy(nums, mid, right, 0, right.length);
        int c1 = mergeSort(left, mid);
        int c2 = mergeSort(right, n - mid);

        return mergeAndCalc(left, right, nums, mid, n - mid) + c1 + c2;

    }

    private static int mergeAndCalc(Comparable[] left, Comparable[] right, Comparable[] nums, int l, int r) {
        int i = 0;
        int j = 0;
        int k = 0;
        int count = 0;
        while (i < l && j < r) {
            if (left[i].compareTo(right[j]) <= 0) {
                nums[k++] = left[i];
                i++;
            } else {
                nums[k++] = right[j];
                count += (l - i);
                j++;
            }
        }

        while (i < l) {
            nums[k++] = left[i++];
        }

        while (j < r) {
            nums[k++] = right[j++];
        }

        return count;
    }
}
