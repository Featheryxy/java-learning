package com.feather.algorithm.LeetCode;

import com.feather.algorithm.Tag;
import org.junit.Test;

/**
 * 斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * <p>
 * F(0) = 0，F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * 给定 n ，请计算 F(n) 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：1
 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/fibonacci-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC0509_Fibonacci_Number {
    Tag[] tags = {Tag.DP};
    static int count = 0;


    public static void main(String[] args) {
        fib(40, new int[41]);
    }


    @Test
    public void test(){
        // 0, 1, 1, 2, 3, 5
        System.out.println(fibonacciOptimize(5));
    }

    public int fib(int n) {
        int[] ansArr = new int[100];
        int i = doFib(n, ansArr);
        return i;
    }

    // 时间复杂度为 O(nlogn), 空间复杂度为 O(1)
    private int doFib(int n, int[] book) {
        if (n == 0 || n == 1) {
            return n;
        }

        if (book[n] != 0) {
            return book[n];
        }
        int result = doFib(n - 1, book) + doFib(n - 2, book);
        book[n] = result;
        return result;
    }

    // 动态规划，时间复杂度为O(n), 空间复杂度为 O(n)
    public static int fibonacci(int n) {
        // 边界条件处理
        if (n == 0 || n == 1) {
            return n;
        }

        // 动态规划数组，用于存储中间结果
        int[] dp = new int[n + 1];
        dp[0] = 0; // F(0)
        dp[1] = 1; // F(1)

        // 自底向上计算斐波那契数列的值
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2]; // 当前项由前两项之和得出
        }

        return dp[n]; // 返回第n个斐波那契数
    }

    // 滚动数组，时间复杂度为O(n),将空间复杂度优化成 O(1)
    public static int fibonacciOptimize(int n) {
        // 边界条件处理
        if (n == 0 || n == 1) {
            return n;
        }

        int p = 0, q = 1;
        int r = 0;

        // 自底向上计算斐波那契数列的值
        for (int i = 2; i <= n; i++) {
            r = p + q;
            p = q;
            q = r;
        }

        return r; // 返回第n个斐波那契数
    }

    public static int fib(int n, int[] sum) {
        count++;
//        System.out.print(n + " ");
        if (sum[n] != 0) {
            return sum[n];
        }
        if (n == 1 || n == 0) {
            return sum[n] = 1;
        }

        return sum[n] = (fib(n - 1, sum) + fib(n - 2, sum));
    }


    public static int sum(int n, int[] sum) {
//        count++;
        // dead code
        if (sum[n] != 0) {
            return sum[n];
        }
//        System.out.print(n);
        if (n == 1) {
            return (sum[1] = 1);
        }
        return sum[n] = (n + sum(n - 1, sum));
    }

    public static int sum(int n) {
        if (n == 1) {
            return 1;
        }
        return sum(n - 1);
    }
}
