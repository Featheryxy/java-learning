package com.feather.algorithm.LeetCode;

public class LC0038_Count_and_Say {
    public static void main(String[] args) {
        System.out.println(countAndSay(2));
    }

    public static String countAndSay(int n) {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                sb.append("1");
                continue;
            }
            StringBuilder sb2 = new StringBuilder();
            char[] chars = sb.toString().toCharArray();
            int count = 1;
            char currChar = chars[0];
            for (int j = 1; j < chars.length; j++) {
                if (currChar == chars[j]) {
                    count++;
                } else {
                    sb2.append(count + 1).append(currChar);
                    count = 0;
                    currChar = chars[j];
                }

            }
            sb = sb2;

        }

        return sb.toString();
    }
}
