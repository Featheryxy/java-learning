package com.feather.algorithm.LeetCode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Milo
 * @date 2025/1/12 9:15
 */
public class LC0048_Rotate_Image {
    @Test
    public void test(){
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
//        rotate(matrix);
        int len = matrix.length;
//        Arrays.stream(matrix).forEach(e-> System.out.println(Arrays.toString(e)));
        // 行不变，遍历列。先遍历行，再遍历列
        for (int row = 0; row < len; row++) {
            for (int col = 0; col < len; col++) {
                int tem = matrix[row][col];
                System.out.println(tem);
            }
        }

        //  列不变，遍历行。先遍历列，再遍历行
        for (int col = 0; col < len; col++) {
            for (int row = 0; row < len; row++) {
                int tem = matrix[row][col];
                System.out.println(tem);
            }
        }

    }
    public void rotate(int[][] matrix) {
        int len = matrix.length;

        for(int i=0; i<len; i++){
            for(int j=i+1; j<len; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
//        Arrays.stream(matrix).forEach(e-> System.out.println(Arrays.toString(e)));
        for(int col=0; col<= len / 2 - 1; col++){
            for (int row = 0; row<len ; row++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[row][len-col - 1];
                matrix[row][len-col - 1] = temp;
            }
        }
//        Arrays.stream(matrix).forEach(e-> System.out.println(Arrays.toString(e)));
    }

}
