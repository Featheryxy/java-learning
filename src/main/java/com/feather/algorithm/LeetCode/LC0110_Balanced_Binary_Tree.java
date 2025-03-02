package com.feather.algorithm.LeetCode;




import com.feather.algorithm.Tag;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * <p>
 * 本题中，一棵高度平衡二叉树定义为：
 * <p>
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/balanced-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LC0110_Balanced_Binary_Tree {
    Tag[] tags = {Tag.BINARY_TREE};

    public static void main(String[] args) {
        // [1,2,2,3,3,null,null,4,4]
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(null);
        list.add(null);
        list.add(4);
        list.add(4);

        TreeNode root = TreeNode.buildByList(list);
        LC0110_Balanced_Binary_Tree solution = new LC0110_Balanced_Binary_Tree();
        System.out.println(solution.isBalanced(root));

    }

    /**
     * 个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        return  -1 != dfs(root);
    }

    // 自低向上查找，后跟遍历
    private int dfs(TreeNode node) {
        // 空节点高度为0， 叶子节点高度为1
        if (node == null) {
            return 0;
        }

        int left =  dfs(node.left);
        if (left == -1) {
            return left;
        }

        int right = dfs(node.right);
        if (right == -1) {
            return right;
        }
        // 如果左右子树高度差相差大于，返回-1， 语义为 非平衡二叉树
        if (Math.abs(left - right) > 1) {
            return -1;
        }

        // 当前节点的高度为 其最大左右子数高度+1
        return Math.max(left, right) + 1;
    }
}
