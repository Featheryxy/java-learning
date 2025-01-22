package com.feather.algorithm.LeetCode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Milo
 * @date 2025/1/20 22:20
 */
public class LC0059_Spiral_Matrix_2 {
    @Test
    public void test(){
        int[][] ints = generateMatrix(4);

        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt));

        }
    }

    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int left = 0, right = n - 1, up = 0, bottom = n - 1;
        int num = 1;
        while (true) {
            for (int col = left; col <= right; col++) {
                ans[up][col] = num++;
            }

            if (++up > bottom) {
                break;
            }

            for (int i = up; i <= bottom; i++) {
                ans[i][right] = num++;
            }
            if (--right < left) {
                break;
            }

            for (int i = right; i >= left; i--) {
                ans[bottom][i] = num++;
            }

            if (--bottom < up) {
                break;
            }

            for (int i = bottom; i>= up; i--) {
                ans[i][left] = num++;
            }
            if (++left > right) {
                break;
            }
        }
        return ans;
    }
}
