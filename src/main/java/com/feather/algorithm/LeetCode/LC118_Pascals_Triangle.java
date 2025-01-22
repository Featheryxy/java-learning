package com.feather.algorithm.LeetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Milo
 * @date 2024/12/28 10:11
 */
public class LC118_Pascals_Triangle {
    @Test
    public void test(){
        List<List<Integer>> generate = generate(5);
        System.out.println(generate);
    }

    // i 表示行数
    // j 表示第i行，第j列
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0; i<numRows; i++ ){
            List<Integer> temp = new ArrayList<>();
            for(int j=0; j<=i; j++){
                if(j==0 || j==i){
                    temp.add(1);
                } else {
                    List<Integer> lastRow = res.get(i - 1);
                    temp.add(lastRow.get(j-1)+lastRow.get(j)); // 上一个的前一个和其后继
                }

            }
            res.add(temp);
        }
        return res;
    }
}
