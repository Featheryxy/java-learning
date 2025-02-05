package com.feather.algorithm.LeetCode;



import com.feather.algorithm.Tag;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例 3：
 * <p>
 * 输入：s = "(]"
 * 输出：false
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC0020_Valid_Parentheses {
    Tag[] tags = {Tag.HASH_TABLE, Tag.STACK};

    public static void main(String[] args) {
        String s = "([])";
        System.out.println(isValid(s));
    }


    /**
     * 数据结构：Stack
     * 解题方法：
     * 定义：哈希表记录对应括号的关系，注意 key 为], value 为 [
     * 解题思路：
     *     1.依次遍历每个字符，如果栈中有匹配的的字符，将栈中元素弹出，否者入栈
     *     2. 如果最后栈为空，则证明括号匹配成功
     * 初始时：
     * 遍历时：
     * ps: 1. 使用双端队列ArrayDeque
     *     2. peek 查看栈顶元素，不弹出
     *     3. pop 弹出栈顶元素
     *     4. push 入栈
     *
     */
    public static boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        char[] chars = s.toCharArray();
        ArrayDeque<Character> deque = new ArrayDeque<>();
        for (char aChar : chars) {
            if (!deque.isEmpty() && (deque.peek() == map.get(aChar))) {
                deque.pop();
            } else {
                deque.push(aChar);
            }

        }
        return deque.isEmpty();

    }

 


}
