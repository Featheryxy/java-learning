package com.feather.algorithm.LeetCode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Milo
 * @date 2025/1/22 22:30
 */
public class LC0026_Remove_Duplicates_from_Sorted_Array {
    @Test
    public void test() {
        int[] nums = new int[]{1,1,1,2,2,3};
//        int[] nums = new int[]{1,2,3,4};
        removeDuplicates(nums);
        System.out.println(Arrays.toString(nums));
    }

    public int removeDuplicates(int[] nums) {
        int writePtr = 0;
        for (int readPtr = 1; readPtr < nums.length; readPtr++) {
            if (nums[readPtr] != nums[writePtr]) {
                writePtr++;
                nums[writePtr] = nums[readPtr];
            }
        }
        return writePtr+1;
    }
}
