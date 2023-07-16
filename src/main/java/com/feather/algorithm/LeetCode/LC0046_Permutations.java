package com.feather.algorithm.LeetCode;

import com.feather.algorithm.Tag;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Milo
 * @date 2023/7/15 11:38
 *
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 *
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出：[[1]]
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * nums 中的所有整数 互不相同
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Slf4j
public class LC0046_Permutations {

    @Test
    public void test() {
        int[] nums = {1,2,3};
        System.out.println(permute(nums));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        int beginIndex = 0;
        boolean[] usedArr = new boolean[nums.length];
        backtracking(res, path, nums, beginIndex, usedArr);
        return res;
    }

    private void backtracking(List<List<Integer>> res, List<Integer> path, int[] nums, int begin, boolean[] usedArr) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i < nums.length; i++) {
            if (!usedArr[i]) {
                path.add(nums[i]);
                usedArr[i] = true;
                backtracking(res, path, nums, 0, usedArr);
                path.remove(path.size() - 1);
                usedArr[i] = false;
            }
        }
    }

    Tag[] tags = {Tag.BACKTRACKING};
}
