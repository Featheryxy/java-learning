package com.feather.algorithm.LeetCode;

public class LC0043_Multiply_Strings {
    public static void main(String[] args) {
        String num1 = "0", num2 = "0";
//        String num1 = "123", num2 = "456";
        System.out.println(multiply(num1, num2));
    }

    /**
     *
     * 数据结构：String
     * 解题方法：
     * 定义：
     * 解题思路：
     *     两数相乘等于其各个位权上的值*位权之和
     *     用数组的下标代替位权
     *     数组下标 为 0,...,n-1,n。 其权重分别为 10^0, 10^1
     *
     *
     *
     * 初始时：
     * 遍历时：
     * ps: 数字数组下标索引和位权成反比,通常计算时低位记录个位，最后从后遍历数组得到最终值
     *      123 = 1*10^2+2*10^1+3*10^0
     *
     * @param num1
     * @param num2
     * @return
     */
    public static String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        char[] num1Arr = num1.toCharArray();
        char[] num2Arr = num2.toCharArray();

        int[] ans = new int[m + n];

        // 得到结果数组
        for (int i = 0; i < num1Arr.length; i++) {
            for (int j = 0; j < num2Arr.length; j++) {
                int a = num1Arr[m-i-1] - '0';
                int b = num2Arr[n-j-1] - '0';
                ans[i + j] += a * b;
                
            }
        }

        // 处理进位
        for (int i = 0, carry=0; i < ans.length; i++) {
            ans[i] += carry;
            carry = ans[i] / 10;
            ans[i] = ans[i] % 10;
        }

        // 从后向前遍历，并且处理前置0
        StringBuilder sb = new StringBuilder();
        for (int i = ans.length-1; i >= 0; i--) {
            if (sb.length() == 0 && ans[i] == 0) {
                continue;
            }
            sb.append(ans[i]+'0');
        }
        if (sb.length() == 0) {
            return "0";
        }

        return sb.toString();

    }
}
