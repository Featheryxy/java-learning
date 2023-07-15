package com.feather.algorithm.LeetCode;

import com.feather.algorithm.Tag;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Milo
 * @date 2023/7/8 20:16
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/subsets-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC0090_SubsetsII {

    @Test
    public void test(){
        int[] nums = {1, 2, 2};
        System.out.println(subsetsWithDup(nums));
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        int begin = 0;
        dfs(res, path, nums, begin);
        return res;
    }

    /**
     *
     * @param res
     * @param path
     * @param nums
     * @param begin 记录每次递归的起始点，
     */
    private void dfs(List<List<Integer>> res, List<Integer> path, int[] nums, int begin) {
        res.add(new ArrayList<>(path));

        for (int i = begin; i < nums.length; i++) {
            // i > begin 回溯的时候剪去枝叶
            if (i > begin && nums[i] == nums[i- 1]) {
                continue;
            }
            // 在 向下递归的时候剪枝
//            if (i < nums && nums[i+1] == nums[i]) {
//                continue;
//            }
            path.add(nums[i]);
            dfs(res, path, nums, i + 1);
            path.remove(path.size() - 1);
        }
    }

    Tag[] tags = {Tag.BACKTRACKING};
}
