package com.feather.algorithm.LeetCode;



import com.feather.algorithm.Tag;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * <p>
 * 你可以按 任何顺序 返回答案。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 4, k = 2
 * 输出：
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * 示例 2：
 * <p>
 * 输入：n = 1, k = 1
 * 输出：[[1]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/combinations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC0077Combinations {
    public Tag[] tags = {Tag.BACKTRACKING};

    public static void main(String[] args) {
        System.out.println(combine(4, 2));
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n < k) {
            return res;
        }
        Deque<Integer> path = new ArrayDeque<>();
        dfs(n, k, 1, path, res);
        return res;
    }

//    static int methodStackNo = 0;
//
//    public static List<List<Integer>> combine(int n, int k) {
//        List<List<Integer>> res = new ArrayList<>();
//        if (k <= 0 || n < k) {
//            return res;
//        }
//        Deque<Integer> path = new ArrayDeque<>();
//        dfs(n, k, 1, path, res, methodStackNo);
//        return res;
//    }
//
//    private static void dfs(int n, int k, int begin, Deque<Integer> path, List<List<Integer>> res, int methodStackNo) {
//        ++methodStackNo;
////        System.out.println(String.format("当前参数：methodStackNo: %s, begin: %s, path: %s, res: %s", methodStackNo, begin, path, res));
//        if (path.size() == k) {
//            res.add(new ArrayList<>(path));
//            System.out.println("结果收集：" + res + ", methodStackNo: " + methodStackNo);
//            return;
//        }
//        // 遍历未搜寻的数组
//        for (int i = begin; i <= n; i++) {
//            path.addLast(i);
////            System.out.println("递归之前 => " + path + ", methodStackNo: " + methodStackNo + ", res: " + res);
//            dfs(n, k, i + 1, path, res, methodStackNo);
//            path.removeLast();
//            System.out.println("递归之后 => " + path + ", methodStackNo: " + methodStackNo);
//        }
//    }

    /**
     * @param n     1,2,3...n
     * @param k     组合数
     * @param begin 记录每层循环的起始数, 在区间 [begin, n] 里选出若干个数的组合
     * @param path  记录搜索路径
     * @param res   记录结果
     */
    private static void dfs(int n, int k, int begin, Deque<Integer> path, List<List<Integer>> res) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 减枝：因为有搜索上界
        // 比如说 [1,2,3,4], 选3个数组合，path为空 则搜索上界为2
        for (int i = begin; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            dfs(n, k, i + 1, path, res);
            path.removeLast();
        }

//        for (int i = begin; i <= n ; i++) {
//            path.add(i);
//            dfs(n, k, i + 1, path, res);
//            path.removeLast();
//        }
    }
}
