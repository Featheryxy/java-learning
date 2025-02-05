package com.feather.algorithm.LeetCode;

public class LC0058_Length_of_Last_Word {

    public static void main(String[] args) {
        String s = "hello world ";

        System.out.println(lengthOfLastWord(s));

    }

    /**
     * 数据结构：String
     * 解题方法：双指针
     * 定义：
     * 解题思路：
     *     从后向前遍历，尾巴指针指向第一个不是空格字符的字母
     *     头指针指向第一个空格字符
     *     长度为 两指针索引差
     * 初始时：
     * 遍历时：
     * ps:
     *
     * @param s
     * @return
     */
    public static int lengthOfLastWord(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;

        for ( int i = len - 1;i >= 0; i--) {
            if (chars[i] == ' ') {
                continue;
            }
            int j = i-1;
            while (j >= 0 && chars[j] != ' ') {
                j--;
            }

            return i-j;
        }
        return 0;
    }


    public static int lengthOfLastWord2(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;

        int i = len - 1, last = i;
        while (chars[i] == ' ') {
            i--;
            last = i;
        }

        for ( ;i >= 0; i--) {
            if (chars[i] == ' ') {
                return last - i;
            }
        }
        return last - i;
    }
}
