package com.feather.algorithm.LeetCode;

import com.feather.algorithm.Tag;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Milo
 * @date 2025/2/25 23:02
 */
public class LC0022_Generate_Parentheses {
    Tag[] tags = {Tag.DFS, Tag.AGAIN};

    @Test
    public void test(){
        List<String> strings = generateParenthesis(2);
        System.out.println(strings);
    }

    /**
     * 结果收集：
     *      左括号数量 = 右括号数量
     * 遍历方向：
     *      左括号数量 < n,
     *      右括号数量 < n
     *      任意前缀“（ ”的数量 >=  ")"数量
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        int lc = 0, rc = 0;
        String beginStr = "";
        dfs(lc, rc, n, beginStr, res);
        return res;
    }

    private void dfs(int lc, int rc, int n, String str, List<String> res) {
        System.out.println(str);
        if (lc == n && rc == n) {
            res.add(str);
            return;
        }

        if (lc < n) {
            dfs(lc+1, rc, n, str+"(", res);
        }

        if (rc < n && lc > rc) {
            dfs(lc, rc+1, n, str+")", res);
        }
    }


}
