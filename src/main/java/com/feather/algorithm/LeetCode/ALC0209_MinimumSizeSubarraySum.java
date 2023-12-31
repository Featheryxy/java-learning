package com.feather.algorithm.LeetCode;

import java.util.Optional;

/**
 * 给定一个含有n个正整数的数组和一个正整数 target 。
 * <p>
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组[numsl, numsl+1, ..., numsr-1, numsr] ，
 * 并返回其长度。如果不存在符合条件的子数组，返回 0 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组[4,3]是该条件下的长度最小的子数组。
 * 示例 2：
 * <p>
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 * <p>
 * 提示：
 * <p>
 * 1 <= target <= 109
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 105
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/minimum-size-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ALC0209_MinimumSizeSubarraySum {
    public static void main(String[] args) {
        System.out.println(Optional.ofNullable(null).orElse("0"));
        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen(target, nums));
    }

    public static int minSubArrayLenViolence(int target, int[] nums) {
        int length = nums.length;
        if (length == 1 && nums[0] >= target) {
            return 1;
        }
        if (length == 1) {
            return 0;
        }

        int minLen = Integer.MAX_VALUE;
        int tmpSum = 0;

        for (int l = 0; l < length; l++) {
            for (int r = l + 1; r < length; r++) {
                tmpSum = 0;
            }
        }
        return 0;
    }


    // 维护一个动态窗口，[l, r], minLen记录满足条件的最小长度
    // 初始 l=0, r=0;
    // if(sum([l,r]) >= target ) return min(minLen, r-l+1)
    // if(sum([l,r]) < target )
    public static int minSubArrayLen(int target, int[] nums) {
        int length = nums.length;
//        if (length == 1 && nums[0] >= target) {
//            return 1;
//        }
//        if (length == 1) {
//            return 0;
//        }

        int minLen = Integer.MAX_VALUE;
        int tmpSum = 0;

        int l = 0;
        for (int r = 0; r < length; r++) {
            tmpSum += nums[r];
            // 找到满足条件的最小连续子数组
            while (tmpSum >= target) {
                minLen = Math.min(r - l + 1, minLen);
                tmpSum = tmpSum - nums[l];
                l++;
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
