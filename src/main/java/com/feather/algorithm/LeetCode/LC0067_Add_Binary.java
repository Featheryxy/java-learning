package com.feather.algorithm.LeetCode;

import java.util.Arrays;

public class LC0067_Add_Binary {
    public static void main(String[] args) {
        String a = "1", b = "111";
//        String a = "11", b = "1";
        String s = addBinary(a, b);
        System.out.println(s);

    }

    public static String addBinary(String a, String b) {
        char[] aArr = a.toCharArray();
        char[] bArr = b.toCharArray();
        int m = aArr.length;
        int n = bArr.length;

        StringBuilder ansSb = new StringBuilder();
        int i = m - 1, j = n - 1, carry = 0;
        while (i >= 0 && j >= 0) {
            int aTem = aArr[i] - '0';
            int bTem = bArr[j] - '0';
            int temSum = aTem + bTem + carry;
            carry = temSum / 2;
            temSum = temSum % 2;
            ansSb.append(temSum);

            i--;
            j--;
        }

        for (; i >= 0; i--) {
            int temSum = aArr[i]-'0' + carry;
            carry = temSum / 2;
            temSum = temSum % 2;
            ansSb.append(temSum);
        }

        for (; j >= 0; j--) {
            int temSum = bArr[j]-'0' + carry;
            carry = temSum / 2;
            temSum = temSum % 2;
            ansSb.append(temSum);
        }
        if (carry == 1) {
            ansSb.append(carry);
        }


        return ansSb.reverse().toString();

    }


    public String addBinaryOffice(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int ca = 0;
        for(int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--){
            int sum = ca;
            sum += i >= 0 ? a.charAt(i) - '0' : 0;
            sum += j >= 0 ? b.charAt(j) - '0' : 0;
            sb.append(sum % 2);
            ca = sum / 2;
        }
        sb.append(ca == 1 ? ca : "");
        return sb.reverse().toString();
    }
}
