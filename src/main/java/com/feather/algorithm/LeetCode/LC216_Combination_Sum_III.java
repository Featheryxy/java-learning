package com.feather.algorithm.LeetCode;



import com.feather.algorithm.Tag;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 216. 组合总和 III
 * 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
 * <p>
 * 只使用数字1到9
 * 每个数字 最多使用一次
 * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 解释:
 * 1 + 2 + 4 = 7
 * 没有其他符合的组合了。
 * 示例 2:
 * <p>
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 * 解释:
 * 1 + 2 + 6 = 9
 * 1 + 3 + 5 = 9
 * 2 + 3 + 4 = 9
 * 没有其他符合的组合了。
 * 示例 3:
 * <p>
 * 输入: k = 4, n = 1
 * 输出: []
 * 解释: 不存在有效的组合。
 * 在[1,9]范围内使用4个不同的数字，我们可以得到的最小和是1+2+3+4 = 10，因为10 > 1，没有有效的组合。
 */
public class LC216_Combination_Sum_III {
    public Tag[] tags = {Tag.BACKTRACKING};
    private List<List<Integer>> res = new ArrayList<>();
    private Deque<Integer> path = new ArrayDeque<>();

    public static void main(String[] args) {
        List<List<Integer>> lists = new LC216_Combination_Sum_III().combinationSum3(3, 9);
        System.out.println(lists);
    }

    // 找出1-9中，所有组合数为k的组合，如果该组合数相加为n，收集到结果中
    public List<List<Integer>> combinationSum3(int k, int n) {
        int num = 9;
        backtracking(num, k, n, 1);
        return res;
    }

    private void backtracking(int num, int k, int n, int begin) {
        if (path.size() == k) {
            int sum = path.stream().mapToInt(Integer::intValue).sum();
            if (sum == n) {
                res.add(new ArrayList<>(path));
            }
            return;
        }

        for (int i = begin; i <= num; i++) {
            path.addLast(i);
            backtracking(num, k, n, i + 1);
            path.removeLast();
        }

    }
}
