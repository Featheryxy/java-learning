package com.feather.algorithm.LeetCode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Milo
 * @date 2024/12/29 19:11
 */
public class LC0031_Next_Permutation {
    @Test
    public void test(){
        int[] nums = new int[]{1, 3, 2};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void nextPermutation(int[] nums) {
        int len = nums.length;
        for (int i = len - 1; i >= 0; i--) {
            if (i == 0) {
                Arrays.sort(nums);
                return;
            } else {
                if (nums[i] > nums[i - 1]) {
                    Arrays.sort(nums, i, len);
                    for (int j = i; j <len; j++) {
                        if (nums[j] > nums[i - 1]) {
                            int temp = nums[j];
                            nums[j] = nums[i - 1];
                            nums[i - 1] = temp;
                            return;
                        }
                    }
                }
            }
        }
    }
}
