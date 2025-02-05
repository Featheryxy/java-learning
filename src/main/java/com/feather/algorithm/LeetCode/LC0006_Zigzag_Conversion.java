package com.feather.algorithm.LeetCode;

import java.util.Arrays;

public class LC0006_Zigzag_Conversion {
    /**
     * LC0006 Z字形变换
     * 数据结构：String
     * 解题方法：双指针（读写指针）
     * 定义：
     *      1. ansArr：结果数组
     *      2. 方向，读指针，写指针
     *      3.
     * 解题思路：。
     *      遍历整个字符串，将遍历值写入到结果数组中
     *      先向下遍历，碰到下边界时，修改遍历方向向上，同时写指针++
     *      向上遍历时，碰到上边界时，修改遍历方向向下，写指针--
     *
     * 初始时：
     * 遍历时：
     * ps: 字符数组初始化后默认值为null，需要使用 Arrays.fill(ansArr,"")将其默认值填充为"";
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;

        String[] ansArr = new String[numRows];
        Arrays.fill(ansArr,"");
        // 遍历字符串是更新row变量
        boolean down = true;
        for (int i = 0, row=0; i < s.length(); i++) {
            char charTmp = s.charAt(i);
            ansArr[row] = ansArr[row] + charTmp;

            if (down) {
                row++;
            } else {
                row--;
            }


//            if (row == numRows-1) {
//                down = false;
//            }
//
//            if (row == 0) {
//                down = true;
//            }

            if (row == numRows-1 || row == 0) down = !down;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (String s1 : ansArr) {
            stringBuilder.append(s1);
        }
        return stringBuilder.toString();
    }

}
