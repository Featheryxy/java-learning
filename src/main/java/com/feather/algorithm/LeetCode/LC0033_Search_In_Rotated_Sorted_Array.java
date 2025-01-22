package com.feather.algorithm.LeetCode;

import org.junit.Test;

/**
 * @author Milo
 * @date 2025/1/1 18:50
 */
public class LC0033_Search_In_Rotated_Sorted_Array {
    @Test
    public void test(){
//        int[] nums = new int[]{4,5,6,7,0,1,2};
//        System.out.println(search(nums, 0));
//        int[] nums = new int[]{1,3};
//        System.out.println(search(nums, 3));


        int[] nums = new int[]{3,5,1};
        System.out.println(search(nums, 5));
    }

    public static int search(int[] nums, int target) {
        int len = nums.length;
        int first = nums[0];
        int last = nums[len-1];
        int res = -1;
        // 没有发生旋转
        if (first <= last) {
            return binarySearch(nums, target);
        }

        if(target<first) {
            for(int idxlast=len-1; idxlast>=0; idxlast--){
                if(nums[idxlast] == target) {
                    return idxlast;
                }
                boolean canContinue = idxlast - 1 >= 0 && nums[idxlast] >= nums[idxlast - 1];
                if (!canContinue) {
                    break;
                }

            }
        } else {
            for(int idxFirst=0; idxFirst<len; idxFirst++){
                if(nums[idxFirst] == target) {
                    return idxFirst;
                }
                boolean canContinue = idxFirst + 1 < len && nums[idxFirst] <= nums[idxFirst + 1];
                if (!canContinue) {
                    break;
                }
            }
        }
        return res;
    }

    private static int binarySearch(int[] nums, int target) {

        int len = nums.length;
        int left = 0;
        int right = len-1;

        while (left <= right) {
            int middle = (left + right);
            int middleNum = nums[middle];
            if (middleNum == target) {
                return middle;
            } else if (middleNum > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return -1;

    }
}
