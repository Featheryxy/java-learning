package com.feather.algorithm.LeetCode;

import org.junit.Test;

public class LC0008_String_to_Integer {

    @Test
    public void test(){
        System.out.println(myAtoi(""));
    }


    /**
     * 数据结构：String
     * 解题方法：单指针
     * 定义：sign = 1表示正数，-1为负数
     * 解题思路：。
     *      一个指针多阶段遍历字符串
     *      1. 跳过空格
     *      2. 处理符号位
     *      3. 是否越界，正数时 当前数 > 最大数整除10，或 数相同时，考虑加上去的最后一位 > 最大数的最后一位
     *
     * 初始时：
     * 遍历时：
     * ps: 负数的余数还是负数，-11%10 = -1
     *     字符转数字可以通过减号 '1'-'0' = 1
     *     移动指针时考虑是否越界
     *
     * @param s
     * @param numRows
     * @return
     */
    public int myAtoi(String s) {
        char[] chars = s.toCharArray();
        int start = 0, sign = 1, res = 0;

        // 越过空格
        while (start<chars.length&&chars[start] == ' ') start++;


        if (start == chars.length) {
            return 0;
        }

        // 处理符号位
        if (chars[start] == '-'){
            sign = -1;
            start++;
        } else if (chars[start] == '+') {
            start++;
        }

        for (;start < chars.length; start++) {
            // 字符转数字
            int num = chars[start] - '0';
            if (num > 9 || num < 0) {
                break;
            }

            if (res > Integer.MAX_VALUE / 10 || (res== Integer.MAX_VALUE/10 && num>Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }
            if (res < Integer.MIN_VALUE/ 10 || (res== Integer.MIN_VALUE/10 && sign *num < Integer.MIN_VALUE % 10)) {
                return Integer.MIN_VALUE;
            }


            res = res * 10 + sign * num;
        }

        return res;
    }
}
