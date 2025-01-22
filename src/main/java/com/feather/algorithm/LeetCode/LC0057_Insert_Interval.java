package com.feather.algorithm.LeetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Milo
 * @date 2025/1/19 9:35
 */
public class LC0057_Insert_Interval {
    @Test
    public void test(){
        int[][] intervals = new int[][]{{1, 3}, {6, 9}};
        int[] newInterval = new int[]{2, 5};
        int[][] insert = this.insert(intervals, newInterval);
        for (int[] ints : insert) {
            System.out.println(Arrays.toString(ints));
        }

    }

    public int[][] insert(int[][] a, int[] b) {
        int length = a.length;
        List<int[]> ret = new ArrayList<>();

        int i = 0;
//        for (; i < length; i++) {
//            if (a[i][1] < b[0]) {
//                ret.add(a[i]);
//            } else {
//                break;
//            }
//        }

        while (i < length && a[i][1] < b[0]) {
            ret.add(a[i]);
        }

        if (i < length) {
            b[0] = Math.min(a[i][0], b[0]);
            while (i < length && a[i][0] <= b[1]) {
                b[1] = Math.max(a[i][1], b[1]);
                i++;
            }
        }
        ret.add(b);

        while (i < length) {
            ret.add(a[i]);
            i++;
        }

        return ret.toArray(new int[ret.size()][]);
    }

}
