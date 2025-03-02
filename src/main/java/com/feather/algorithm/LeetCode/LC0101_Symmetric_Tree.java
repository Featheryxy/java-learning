package com.feather.algorithm.LeetCode;

import com.feather.algorithm.Tag;
import org.junit.Test;

/**
 * @author Milo
 * @date 2025/2/28 21:12
 */
public class LC0101_Symmetric_Tree {
    Tag[] tags = {Tag.DFS, Tag.BINARY_TREE};

    @Test
    public void test(){

    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return dfs(root.left, root.right);
    }

    private boolean dfs(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        // p 与 q 都为null 的反面为有一个不为 null

        if (p == null || q == null) {
            return false;
        }

        if (!p.val.equals(q.val)) {
            return false;
        }
        return  dfs(p.left, q.right) && dfs(p.right, q.left);
    }
}
