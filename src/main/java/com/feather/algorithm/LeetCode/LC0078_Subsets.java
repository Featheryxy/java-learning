package com.feather.algorithm.LeetCode;

import com.feather.algorithm.Tag;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Milo
 * @date 2023/7/1 11:11
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
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
 * nums 中的所有元素 互不相同
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC0078_Subsets {
    @Test
    public void test() {
        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        int beginIndex = 0;
        dfs(res, path, nums, beginIndex);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> path, int[] nums, int beginIndex) {
        res.add(new ArrayList<>(path));
        System.out.println("res: "+res);
        for (int i = beginIndex; i < nums.length; i++) {
            System.out.println("before add, path:"+ path);
            path.add(nums[i]);
            System.out.println("affter add, path:"+ path);
            // 这里一定要i+1，
            dfs(res, path, nums, i + 1);
            System.out.println("before remove, path:"+ path);
            path.remove(path.size()-1);
            System.out.println("affter remove, path:"+ path);
        }
    }

    Tag[] tags = {Tag.BACKTRACKING};
}
