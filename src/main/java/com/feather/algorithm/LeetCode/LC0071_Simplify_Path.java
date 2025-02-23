package com.feather.algorithm.LeetCode;

import java.util.ArrayDeque;

/**
 * @author Milo
 * @date 2025/2/9 10:46
 */
public class   LC0071_Simplify_Path {
    public String simplifyPath(String path) {
        String[] split = path.split("/");

        ArrayDeque<String> stack = new ArrayDeque<>();
        for (String s : split) {
            if ("".equals(s) || ".".equals(s)) {
                continue;
            }

            if ("..".equals(s)) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                continue;
            }
            stack.push(s);
        }

        if (stack.isEmpty()) {
            return "/";
        }

        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()) {
            ans.append("/").append(stack.getLast());
            stack.removeLast();
        }

        return ans.toString();
    }
}
