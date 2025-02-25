package com.feather.algorithm.LeetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Milo
 * @date 2025/2/24 22:23
 */
public class LC0507_Perfect_Number {

    @Test
    public void test(){
        System.out.println(isPerfectNumber(0));
    }

    public static int countPerfectNumbers(int n) {
        int count = 0;
        for (int i = 0; i <= n; i++) {
            if (isPerfectNumber(i)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isPerfectNumber(int n) {
        if (n <= 1) {
            return false;
        }

        int sum = 1;
        double half = Math.sqrt(n);
        for (int i = 2; i < half; i++) {
            if (0 == n % i) {
                sum += i;
                sum += n/i;
            }
        }

        return n == sum;
    }


}
