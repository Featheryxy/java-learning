package com.feather.algorithm.LeetCode;

import com.feather.algorithm.Tag;
import org.junit.Test;

/**
 * @author Milo
 * @date 2025/2/27 23:06
 */
public class LC0070_Climbing_Stairs {
    Tag[] tags = new Tag[]{Tag.DP};

    @Test
    public void test(){
        System.out.println(climbStairsOptimize(4));
    }

    public int climbStairs(int n) {
        int[] nums = new int[n+1];

        for (int i = 0; i <= n; i++) {
            if (i <= 2) {
                nums[i] = i;
            } else {
                nums[i] = nums[i - 1] + nums[i - 2];
            }
        }

        return nums[n];

    }

    public int climbStairsOptimize(int n) {
        if (n <= 2) {
            return n;
        }

        int[] nums = new int[n+1];
        int p = 1;
        int q = 2;
        int c = 0;
        for (int i = 3; i <= n; i++) {
            c = p + q;
            p = q;
            q = c;
        }
        return c;

    }
}
