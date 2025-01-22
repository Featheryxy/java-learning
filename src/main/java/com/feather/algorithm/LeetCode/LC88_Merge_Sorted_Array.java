package com.feather.algorithm.LeetCode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Milo
 * @date 2024/12/28 9:37
 */
public class LC88_Merge_Sorted_Array {
    @Test
    public void test(){
        int[] nums1 = new int[]{2,0};
        int m = 1;
        int[] nums2 = new int[]{1};
        int n = 1;
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

    public static void  merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m+n-1;
        int index1 = m -1;
        int index2 = n - 1;
        // 因为 index1 一定大等于 index2， 所以index2 最后有可能没有遍历完，所以需要将 0到index2之间的元素copy到nums1中
        while(index1>=0 && index2>=0){
            if(nums1[index1] > nums2[index2]){
                nums1[k] = nums1[index1];
                index1--;
            } else {
                nums1[k] = nums2[index2];
                index2--;
            }
            k--;
        }

        System.arraycopy(nums2, 0, nums1, 0, index2 + 1);
    }
}
