package com.feather.algorithm.LeetCode;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 * <p>
 * 输入：s = "cbbd"
 * 输出："bb"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC0005LongestPalindromicSubstring {
    public static void main(String[] args) {
        String s = "bb";
//        System.out.println(new StringBuilder("abc").reverse());
        System.out.println(longestPalindrome2(s));
    }

    /**
     * LC0005 最长回文子串
     * 数据结构：String
     * 解题方法：三指针
     * 定义：回文子串, abba
     * 解题思路：遍历字符串，当前字符的左右两边字符相等则为回文子串。
     *         偶数时，左右两指针分边为i，i+1
     *         奇数时，左右两指针分边为i-1，i+1
     * 初始时：
     *         字符串的长度小等于1时，其必然回文
     *         定义初始最长回文子串为第一个字符
     * 遍历时：指针最后停在回文子串的前一个和后一个位置上，所以 子串长度为 r-l+1-2, 左边界为 l+1， 右边界为r
     * ps: substring(begIdx, endIdx), [begIdx, endIdx)
     * tips: char[] chars = s.toCharArray();
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s.length() == 0) {
            return s;
        }
        char[] chars = s.toCharArray();
        int length = chars.length;
        String longestStr = s.charAt(0)+"";
        for (int i = 0; i < length; i++) {
            // 奇数情况
            int leftIdx = i - 1, rightIdx = i + 1;
            while (leftIdx >= 0 && rightIdx < length && chars[leftIdx] == chars[rightIdx]) {
                leftIdx--;
                rightIdx++;
            }

            if (rightIdx - leftIdx-1 > longestStr.length()) {
                longestStr = s.substring(leftIdx+1, rightIdx );
            }

            // 偶数情况
            leftIdx = i - 1;
            rightIdx = i;
            while (leftIdx >= 0 && rightIdx < length && chars[leftIdx] == chars[rightIdx]) {
                leftIdx--;
                rightIdx++;
            }
            if (rightIdx - leftIdx-1 > longestStr.length()) {
                longestStr = s.substring(leftIdx+1, rightIdx );
            }
        }
        return longestStr;
    }

    // 中心扩散法，遍历整个字符串，如果一个字符的左右相等，则改字符串回文
    //s = babad， 假设index= 1， l=0，r=1，s(l) == r(l)
    public static String longestPalindrome2(String s) {
        int length = s.length();
        if (length == 1) {
            return s;
        }

        String longestPalindromStr = "";
        for (int center = 0; center < length; center++) {
            // 奇数情况
            int l = center, r = center;
            while (l >= 0 && r <= length - 1 && (s.charAt(l) == s.charAt(r))) {
                l--;
                r++;
            }

            // 注意：l和r 区间定义的不是回文子串， 【l+1，r-1】才是，长度=r-1-(l+1)+1 = r-l-1
            if (l + 1 >= 0 && r - l - 1 > longestPalindromStr.length()) {
                longestPalindromStr = s.substring(l + 1, r);
            }

            // 偶数情况
            l = center;
            r = center + 1;
            while (l >= 0 && r <= length - 1 && (s.charAt(l) == s.charAt(r))) {
                l--;
                r++;
            }
            if (l + 1 >= 0 && r - l - 1 > longestPalindromStr.length()) {
                longestPalindromStr = s.substring(l + 1, r);
            }

        }

        return longestPalindromStr;
    }


    public static boolean isPalindromicStr1(String s) {
        final StringBuilder stringBuilder = new StringBuilder(s);
        StringBuilder reverse = stringBuilder.reverse();
        return s.equals(reverse.toString());
    }

    public static boolean isPalindromicStr(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

    // 暴力解法，遍历所有的子串
    public static String longestPalindrome3(String s) {

        int len = s.length();
        if (len == 1) {
            return s;
        }

        String ret = "";
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len + 1; j++) {
//                System.out.println(i+" "+j);
                String currStr = s.substring(i, j);
//                System.out.println(currStr);
                if (isPalindromicStr(currStr) && currStr.length() >= ret.length()) {
                    ret = currStr;
                }
            }
        }
        return ret;
    }
}
