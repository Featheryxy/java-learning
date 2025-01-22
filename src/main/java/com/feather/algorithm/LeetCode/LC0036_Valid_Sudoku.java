package com.feather.algorithm.LeetCode;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Milo
 * @date 2025/1/5 10:05
 */
public class LC0036_Valid_Sudoku {
    @Test
    public void test(){
        char[][] board = new char[][]{
                {'.','.','.','.','5','.','.','1','.'},
                {'.','4','.','3','.','.','.','.','.'},
                {'.','.','.','.','.','3','.','.','1'},
                {'8','.','.','.','.','.','.','2','.'},
                {'.','.','2','.','7','.','.','.','.'},
                {'.','1','5','.','.','.','.','.','.'},
                {'.','.','.','.','.','2','.','.','.'},
                {'.','2','.','9','.','.','.','.','.'},
                {'.','.','4','.','.','.','.','.','.'}};

        System.out.println(isValidSudoku(board));
    }

    public boolean isValidSudoku(char[][] board) {
        int rowLen = board.length;
        int colLen = board[0].length;

        for(int row=0; row<rowLen; row++){
            Set<Character> set = new HashSet<>();
            for(int col=0; col<colLen; col++){
                char currChar = board[row][col];
                if ('.'== currChar){
                    continue;
                }
                if(set.contains(currChar)){
                    return false;
                }
                set.add(currChar);
            }

        }

        for(int col=0; col<colLen; col++){
            Set<Character> set = new HashSet<>();
            for(int row=0; row<rowLen; row++){
                char currChar = board[row][col];
                if ('.'== currChar){
                    continue;
                }
                if(set.contains(currChar)){
                    return false;
                }

                set.add(currChar);
            }
        }

        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                Set<Character> set = new HashSet<>();
                for (int x = 0; x < 3; x++) {
                    for (int y = 0; y < 3; y++) {
                        int row = i+x;
                        int col = j+y;
                        System.out.println(String.format("%s, %s", row, col));
                        char currChar = board[row][col];
                        if ('.'== currChar){
                            continue;
                        }
                        if(set.contains(currChar)){
                            return false;
                        }
                        set.add(currChar);
                    }
                }
            }
        }


        return true;

    }
}
