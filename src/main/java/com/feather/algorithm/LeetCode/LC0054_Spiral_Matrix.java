package com.feather.algorithm.LeetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Milo
 * @date 2025/1/14 0:22
 */
public class LC0054_Spiral_Matrix {
    @Test
    public void test(){
//        int[][] matrix = new int[][]{
//                {1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 9}
//        };
        int[][] matrix = new int[][]{
                {1, 2},
                {3, 4}
        };
        spiralOrder(matrix);

    }
    public List<Integer> spiralOrder(int[][] matrix) {
        int rowLen = matrix.length, colLen = matrix[0].length;
        int left = 0, right = colLen - 1, up = 0, down = rowLen-1;
        List<Integer> ans = new ArrayList<>();

        while (true) {
            // 左到右
            for (int i = left; i <= right ; i++) {
                System.out.println(matrix[up][i]);
                ans.add(matrix[up][i]);
            }
            // 上边界下移
            if (++up > down) {
                break;
            }

            // 上到下
            for (int i = up; i <= down ; i++) {
                System.out.println(matrix[i][right]);
                ans.add(matrix[i][right]);
            }
            // 右边界左移动
            if (--right < left) {
                break;
            }

            // 右到左
            for (int i=right; i>=left; i--){
                System.out.println(matrix[down][i]);
                ans.add(matrix[down][i]);
            }
            // 下边界上移
            if (--down < up) {
                break;
            }

            // 下到上,下面数据大于上面的数据
            for (int j = down; j>=up; j--) {
                System.out.println(matrix[j][left]);
                ans.add(matrix[j][left]);
            }
            // 左边界右移
            if (++left > right) {
                break;
            }

        }

        return ans;
    }
}
