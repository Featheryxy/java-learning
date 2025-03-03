package com.feather.algorithm.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1 。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。
 * <p>
 * <p>
 * 示例1:
 * <p>
 * 输入:s = "III"
 * 输出: 3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/roman-to-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC0013_Roman_to_Integer {
    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV")); // 3
//        System.out.println(romanToInt("III")); // 3
//        System.out.println(romanToInt("XLIX")); // 49
    }


    /**
     * LC0013 罗马数字转整数
     * 数据结构：String
     * 解题方法：
     * 定义：
     *      结果数
     *      罗马数字和阿拉伯数字的映射关系
     * 解题思路：。
     *      遍历字符串，如果该字符代表的数字小于其后一个字符的数字，
     *      则在结果数中减去该数字，否则加上该数字
     * 初始时：
     * 遍历时：
     * ps:
     *
     *
     *
    */
    public static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int ret = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {

            if (i + 1 < length ) {
                char currChar = s.charAt(i);
                char nextChar = s.charAt(i+1);
                if (map.get(currChar) < map.get(nextChar)) {
                    ret -= map.get(currChar);
                } else {
                    ret += map.get(currChar);
                }

            } else {
                ret += map.get(s.charAt(i));

            }
        }
        return ret;
    }


    public static int romanToInt2(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);

        int ret = 0;
        for (int i = 0; i < s.length(); ) {
            String tmpStr;
            // 如果 tmpStr在map中，将其变为数字并累计
            // i+1 代表的是s.substring(i, i + 2)，【i， i+1】
            // 因为 s 中的字符一定出现在map中
            if (i + 1 < s.length() && map.get(tmpStr = s.substring(i, i + 2)) != null) {
                ret += map.get(tmpStr);
                i += 2;
            } else {
                ret += map.get(s.substring(i, i + 1));
                i++;
            }
        }
        return ret;
    }
}
