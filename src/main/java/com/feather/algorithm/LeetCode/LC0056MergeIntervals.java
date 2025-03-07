package com.feather.algorithm.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，
 * 并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC0056MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {8, 10}};
        // answer: [[1,6],[8,10],[15,18]]
        for (int[] num : merge(intervals)) {
            System.out.println(Arrays.toString(num));
        }

//        ArrayList<int[]> ans = new ArrayList<>();
//        int length = intervals.length;
//        int l = intervals[0][0], r = intervals[0][1];
//        for (int i = 1; i < length; i++) {
//            int tmpLeft = intervals[i][0];
//            int tmpRight = intervals[i][1];
//            if (tmpLeft > r) {
//                ans.add(new int[]{l, r});
//                l = tmpLeft;
//                r = tmpRight;
//
//            } else {
//                r = Math.max(r, tmpRight);
//            }
//
//
//        }

    }


    // [1, 3],
    //    [2, 6], [8, 10], [15, 18]
    // 双指针，维护一个窗口l，r，用以记录不重叠的区间,即答案
    // 例子中[1，3]，b = [2，6] 发生了重叠，定义重叠为 2 在区间1，3中。
    // 初始时
    public static int[][] merge1(int[][] intervals) {
        List<int[]> ret = new ArrayList<>();
        int length = intervals.length;
        if (length <= 1) {
            return intervals;
        }
        //
        Arrays.sort(intervals, (num1, num2) -> {
            return num1[0] - num2[0];
        });
        // 二维数组中的第一个数组
        int l = intervals[0][0], r = intervals[0][1];
        //
        for (int i = 1; i < length; i++) {
            int tmpLeft = intervals[i][0];
            int tmpRight = intervals[i][1];
            // 不重叠，收集结果并迭代更新l，r
            if (tmpLeft > r) {
                ret.add(new int[]{l, r});
                l = tmpLeft;
                r = intervals[i][1];
            } else {
                // [[1,4],[2,3]]
                r = Math.max(tmpRight, r);
            }

            // 收集最后一个
            if (i == length - 1) {
                ret.add(new int[]{l, r});
            }
        }

        return ret.toArray(new int[0][0]);

    }

    public static int[][] merge(int[][] intervals) {
        List<int[]> ret = new ArrayList<>();
        // 按照左端点从小到大排序
        Arrays.sort(intervals, (p, q) -> p[0] - q[0]);

        // 遍历下一个数组，将上一个结果插入结果集中，所有遍历结束后，最后一个结果没有插入到结果集中

        int ansS = intervals[0][0];
        int ansE = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int nextS = intervals[i][0];
            int nextE = intervals[i][1];

            if (ansE < nextS) {
                ret.add(new int[]{ansS, ansE});
                ansS = nextS;
                ansE = nextE;
            } else if (nextE <= ansE) {
                ansE = ansE;
            } else {
                ansE = nextE;
            }
        }
        ret.add(new int[]{ansS, ansE});

        return ret.toArray(new int[0][0]);
    }
}
