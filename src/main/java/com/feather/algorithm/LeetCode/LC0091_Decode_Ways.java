package com.feather.algorithm.LeetCode;

import com.feather.algorithm.Tag;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author Milo
 * @date 2025/2/27 22:43
 */
public class LC0091_Decode_Ways {
    Tag[] tags = new Tag[]{Tag.AGAIN, Tag.DP};

    @Test
    public void test(){
//        String s = "06";
        String s = "1212";
        System.out.println(numDecodings(s));
    }

    public int numDecodings(String s) {
        int n = s.length();
        // 字符串头部追加空格作为哨兵，追加空格既可以避免讨论前导零，也能使下标从 1 开始，简化 f[i-1] 等负数下标的判断
        s = " " + s;
        char[] cs = s.toCharArray();
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            // a : 代表「当前位置」单独形成 item
            // b : 代表「当前位置」与「前一位置」共同形成 item
            int a = cs[i] - '0', b = (cs[i - 1] - '0') * 10 + (cs[i] - '0');

            // 如果 a 属于有效值，那么 f[i] 可以由 f[i - 1] 转移过来
            if (1 <= a && a <= 9) {
                f[i] = f[i - 1];
            }

            // 如果 b 属于有效值，那么 f[i] 可以由 f[i - 2] 或者 f[i - 1] & f[i - 2] 转移过来
            if (10 <= b && b <= 26) {
                f[i] += f[i - 2];
            }

        }

        System.out.println(Arrays.toString(f));
        return f[n];
    }


}
