package com.feather.algorithm.LeetCode;

import com.feather.algorithm.Tag;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Milo
 * @date 2023/7/15 12:20
 */
public class LC0047_PermutationsII {
    @Test
    public void test() {
        int[] nums = {1,1,2};
        System.out.println(permuteUnique(nums));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] usedArr = new boolean[nums.length];
        Arrays.sort(nums);
        backtracking(res, path, nums, usedArr);
        return res;
    }

    private void backtracking(List<List<Integer>> res, List<Integer> path, int[] nums, boolean[] usedArr) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 剪枝：nums数组递增有序，当 当前树枝与上一树枝相同，且上一树枝已被记录过，则不再记录当前树枝
            if (i > 0 && nums[i] == nums[i - 1] && usedArr[i-1]) {
                continue;
            }

            if (!usedArr[i]) {
                path.add(nums[i]);
                usedArr[i] = true;
                backtracking(res, path, nums, usedArr);
                path.remove(path.size() - 1);
                usedArr[i] = false;
            }
        }
    }

    Tag[] tags = {Tag.BACKTRACKING};
}
