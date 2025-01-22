package com.feather.algorithm.LeetCode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Milo
 * @date 2025/1/22 21:59
 */
public class LC0080_Remove_Duplicates_from_Sorted_Array_2 {
    @Test
    public void test() {
//        int[] nums = new int[]{1,1,1,2,2,3};
        int[] nums = new int[]{1,2,3,4};
        removeDuplicates2(nums);
        System.out.println(Arrays.toString(nums));
    }

    // 序列有序，
    // 初始保留前两个值，可以重复（写指针的左边界维护），如果第三个值和写指针的上一个值不同，则将该值加入结果集中
    public int removeDuplicates2(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }

        int resIdx = 1;
        for (int i = 2; i < n; i++) {
            if (nums[i] == nums[resIdx-1]) {

            } else {
                nums[++resIdx] = nums[i];
            }
        }
        return resIdx+1;
    }

    public int removeDuplicates1(int[] nums) {
        int n = nums.length;
        if(n<=2){
            return n;
        }
        // 如果nums[i] == nums[j],则nums[i]出现了2次，所以flag初始为1
        int i=0, j=1,flag=1;

        while(j<n){
            if (nums[i] == nums[j]){
                flag++;
            }else {
                flag = 1;
            }

            if(flag<=2){
                i++;
                nums[i] = nums[j];
            }
            j++;
        }
        return i+1;
    }

}
