package com.feather.algorithm.LeetCode;

import org.junit.Test;

/**
 * @author Milo
 * @date 2025/1/21 22:13
 */
public class LC0073_Set_Matrix_Zeroes {
    @Test
    public void test(){

    }

    // LC0073 矩阵置零
    // 原数组第一行记录0出现的行，第一列记录列出现的列
    // 行标志，列标志记录第一行第一列是否出现0
    // 1. 遍历数组，找到0出现的位置
    // 2. 根据第一行第一列，从第二行第二列遍历原数组，根据标志设为0
    // 3. 根据 行列标志，将第一行，第一列置为0
    public void setZeroes(int[][] matrix) {
        int m = matrix.length - 1, n = matrix[0].length - 1;
        boolean isRowZero = false, isColZero = false;

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                int currNum = matrix[i][j];
                if (i == 0 && currNum == 0) {
                    isRowZero = true;
                }

                if (j == 0 && currNum == 0) {
                    isColZero = true;
                }

                if (currNum == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }

            }
        }
        // 要从 第二行，第二列开始
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (isRowZero ) {
            for (int j = 0; j <= n; j++) {
                matrix[0][j] = 0;
            }

        }
        if (isColZero) {
            for (int i = 0; i <= m; i++) {
                matrix[i][0] = 0;
            }
        }

    }
}
