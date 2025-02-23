package com.feather.algorithm;

import org.junit.Test;

import java.util.*;

/**
 * @author Milo
 * @date 2025/2/9 11:45
 */
public class LC_SortMatrix {
    @Test
    public void test(){
        int[][] grid = {{1, 7, 3}, {9, 8, 2}, {4, 5, 6}}; // [[8,2,3],[9,6,7],[4,5,1]]
        int[][] ints = sortMatrix(grid);

        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt));
        }
    }

    public int[][] sortMatrix(int[][] grid) {
        int rowNum = grid.length;
        int colNum = grid[0].length;
        int[][] ans = new int[rowNum][colNum];

        for (int i = 0; i < rowNum; i++) {
            List<Integer> tem = new ArrayList<>();
            int x=i, y=0;

            while (x < rowNum && y < colNum) {
                int e = grid[x][y];
                tem.add(e);
                x++;
                y++;
            }
            tem.sort((a, b) -> b - a);
            int ansX = i, ansY = 0;
            for (Integer integer : tem) {
                ans[ansX][ansY] = integer;
                ansX++;
                ansY++;
            }
        }

        for (int j = 1; j < colNum; j++) {
            List<Integer> tem = new ArrayList<>();
            int x=0, y=j;

            while (x < rowNum && y < colNum) {
                int e = grid[x][y];
                tem.add(e);
                x++;
                y++;
            }
            Collections.sort(tem);
            int ansX = 0, ansY = j;
            for (Integer integer : tem) {
                ans[ansX][ansY] = integer;
                ansX++;
                ansY++;
            }
        }

        return ans;
    }
}
