package com.feather.algorithm.LeetCode;

public class LC0028_Find_the_Index_of_the_First_Occurrence_in_a_String {
    public static void main(String[] args) {
        String haystack = "sadbutsad", needle = "sad";
        System.out.println(strStr(haystack, needle));
    }

    /**
     * 数据结构：String
     * 解题方法：暴力法
     * 定义：
     * 解题思路：
     *     遍历两个字符串，当内循环的指针到达字符串的最后一位，则外指针为答案
     * 初始时：
     * 遍历时：
     *
     */
    public static int strStr(String haystack, String needle) {
        char[] haystackArr = haystack.toCharArray();
        char[] needleArr = needle.toCharArray();

        for (int i = 0; i < haystackArr.length; i++) {
            for (int j = 0; j < needleArr.length; j++) {

//                if (haystackArr[i + j] == needleArr[j]) {
//                    continue;
//                } else {
//                    break;
//                }


                if (haystackArr[i + j] != needleArr[j]) {
                    break;
                }

                if (j == needleArr.length - 1) {
                    return i;
                }
            }
        }

        return -1;
    }
}
