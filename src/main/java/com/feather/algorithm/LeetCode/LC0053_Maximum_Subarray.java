package com.feather.algorithm.LeetCode;

import org.junit.Test;

/**
 * @author Milo
 * @date 2023/8/5 6:02
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组 是数组中的一个连续部分。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * 示例 2：
 *
 * 输入：nums = [1]
 * 输出：1
 * 示例 3：
 *
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC0053_Maximum_Subarray {
    @Test
    public void test(){
        int[] nums = {-1, -2};
        System.out.println(maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {
        // 求最大值，初始给最小值
        int res = Integer.MIN_VALUE;
        // 循环一定要考虑初始值
        for (int i = 0; i < nums.length; i++) {
            int tmpSum = 0;
            for (int j = i; j < nums.length; j++) {
                tmpSum = tmpSum + nums[j];
                if (tmpSum > res) {
                    res = tmpSum;
                }
            }
        }
        return res;
    }

    public int maxSubArrayErr(int[] nums) {
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int tmpSum = nums[i];
            // 如果 nums 中只有一个数组，下面该逻辑就不会执行，有问题
            for (int j = i+1; j < nums.length; j++) {
                tmpSum = tmpSum + nums[j];
                if (tmpSum > res) {
                    res = tmpSum;
                }
            }
        }
        return res;
    }
}
