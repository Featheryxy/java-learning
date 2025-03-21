package com.feather.algorithm.LeetCode;

/**
 * 罗马数字包含以下七种字符：I，V，X，L，C，D和M。
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做II，即为两个并列的 1。12 写做XII，即为X+II。 27 写做XXVII, 即为XX+V+II。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做IIII，而是IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I可以放在V(5) 和X(10) 的左边，来表示 4 和 9。
 * X可以放在L(50) 和C(100) 的左边，来表示 40 和90。
 * C可以放在D(500) 和M(1000) 的左边，来表示400 和900。
 * 给你一个整数，将其转为罗马数字。
 * <p>
 * <p>
 * 示例1:
 * <p>
 * 输入:num = 3
 * 输出: "III"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/integer-to-roman
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC0012_Integer_to_Roman {
    public static void main(String[] args) {
        int num = 3749;
        System.out.println(intToRoman(num));
    }

    /**
     * LC0012 整数转罗马数字
     * 数据结构：String
     * 解题方法：
     * 定义：值以4，9开头时，减法模式  4 用IV  表示
     * 解题思路：
     *    num = baseNum * count+余数
     *    余数 = num - baseNum * count
     *
     * 初始时：
     *
     *
     * 遍历时：
     * ps:
     * tips:
     * @param s
     * @return
     */
    public static String intToRoman(int num) {
        int[] baseNums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < baseNums.length; i++) {
            if (num / baseNums[i] > 0) {
                int count = num / baseNums[i];
                for (int j = 0; j < count; j++) {
                    builder.append(roman[i]);
                }
                num = num - count * baseNums[i];
            }
        }
        return builder.toString();
    }


    //
    public static String intToRoman2(int num) {
        //        I             1
        //        V             5
        //        X             10
        //        L             50
        //        C             100
        //        D             500
        //        M             1000
        // * I可以放在V(5) 和X(10) 的左边，来表示 4 和 9。
        // * X可以放在L(50) 和C(100) 的左边，来表示 40 和90。
        // * C可以放在D(500) 和M(1000) 的左边，来表示400 和900。
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            int baseNum = nums[i];
            // 如果num /baseNum > 0 则说明 num = n* baseNum
            if (num / baseNum > 0) {
                int count = num / baseNum; // 记录总共有几个baseNum, 如 5000， 则有5个1000，即MMMMM
                for (int j = 0; j < count; j++) {
                    stringBuilder.append(roman[i]);
                }
                num = num - baseNum * count;
            }
        }

        return stringBuilder.toString();
    }
}
