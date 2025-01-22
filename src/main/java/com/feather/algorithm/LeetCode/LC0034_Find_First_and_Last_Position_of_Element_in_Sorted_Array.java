package com.feather.algorithm.LeetCode;

import org.junit.Test;

/**
 * @Date 2023/4/27 18:20
 * @Created by Milo
 */
public class LC0034_Find_First_and_Last_Position_of_Element_in_Sorted_Array {
    @Test
    public void test(){

    }

    public static int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len-1;

        while (left <= right) {
            // 防止溢出
            int middle = left + (right - left) / 2;
            int middleNum = nums[middle];
            if (middleNum == target) {
                return aroundSearch(nums, middle);
            } else if (middleNum > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return new int[]{-1,-1};
    }

    public static int[] aroundSearch(int[] nums, int idx){
        int[] res = new int[2];
        // idx的前驱
        int pre = idx;
        // idx的后驱
        int next = idx;
        while (pre >= 0 && nums[pre] == nums[idx]) {
            res[0] = pre;
            pre--;
        }
        while (next < nums.length && nums[next] == nums[idx]) {
            res[1] = next;
            next++;
        }
        return res;
    }

}
