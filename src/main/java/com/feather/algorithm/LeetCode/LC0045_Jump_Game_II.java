package com.feather.algorithm.LeetCode;

import com.feather.algorithm.Tag;
import org.junit.Test;

/**
 *
 * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
 *
 * 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
 *
 * 0 <= j <= nums[i]
 * i + j < n
 * 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 示例 2:
 *
 * 输入: nums = [2,3,0,1,4]
 * 输出: 2
 *
 * @author Milo
 * @date 2023/8/27 10:26
 */
public class LC0045_Jump_Game_II {
    @Test
    public void test(){
        int[] nums = {2,3,1,1,4};
//        int[] nums = {0};
        System.out.println(jump(nums));
    }

    public int jump(int[] nums) {
//        if (nums == null || nums.length <= 1) {
//            return 0;
//        }
        // 最大覆盖范围, 数组下标
        int maxCover = 0;
        // 一个最大覆盖范围的右边界
        int end = 0;

        int jumpNums = 0;
        for(int i=0; i<nums.length-1; i++) {
            // 记录最大覆盖范围
            maxCover = Math.max(maxCover, i+nums[i]);
            // 当指针走到右边界时，右边界更新为下一个覆盖范围的右边
            if (end == i) {
                end = maxCover;
                jumpNums ++;
            }
        }
        return jumpNums;
    }

    Tag[] tags = {Tag.GREEDY};
}
