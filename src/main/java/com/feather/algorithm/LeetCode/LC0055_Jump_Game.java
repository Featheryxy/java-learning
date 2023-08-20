package com.feather.algorithm.LeetCode;

import org.junit.Test;

/**
 * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * 示例 2：
 *
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 105
 *
 * @author Milo
 * @date 2023/8/20 10:43
 */
public class LC0055_Jump_Game {

    @Test
    public void test(){
        int[] nums = {3,2,1,0,4};
        System.out.println(canJump(nums));
    }

    // 如果一个元素的覆盖范围 >=　数组长度，则可达
    // 遍历数组，更新覆盖范围
    public boolean canJump(int[] nums) {
        int cover = 0;
        for (int i = 0; i <= cover; i++) {
            // 覆盖范围= max(当前位置+当前位置可达长度， 之前的覆盖范围)
            cover = Math.max(cover, i + nums[i]);
            if (cover >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }

    public boolean canJump1(int[] nums) {

        return false;
    }
}
