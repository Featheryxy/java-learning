package com.feather.algorithm.LeetCode;



import com.feather.algorithm.Tag;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 * <p>
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [-10,-3,0,5,9]
 * 输出：[0,-3,9,-10,null,5]
 * 解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ALC0108_Convert_Sorted_Array_to_Binary_Search_Tree {
    Tag[] tags = {Tag.BINARY_TREE};

    public static void main(String[] args) {
        int[] nums = {-11, -10, -3, 0, 5, 9, 10};
        TreeNode root = sortedArrayToBST(nums);
        TreeNode.toStringInOrder(root);
        // ans: [0,-3,9,-10,null,5]

    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = dfs(nums, 0, nums.length - 1);
        return root;
    }

    // 区间划分，每个区间最中间的值最大
    private static TreeNode dfs(int[] nums, int low, int high) {
        // 不能有等于，否则会少节点
        if (low > high) {
            return null;
        }

        int mid = low + (high - low) / 2;
        TreeNode treeNode = new TreeNode(nums[mid]);
        // 下面这种写法错误，因为会对mid进行赋值
//        treeNode.left = dfs(nums, low, --mid);
//        treeNode.right = dfs(nums, ++mid, high);
        treeNode.left = dfs(nums, low, mid - 1);
        treeNode.right = dfs(nums, mid + 1, high);
        return treeNode;
    }

    // 1, 2, 3, 4
    // 找到数组的中间位置,  向两边扩散
    //         // ans: [0,-3,9,-10,null,5]
    //        //                0
    //        //          -3          9
    //        //      -10    null  5
    //        // myans:         0
    //        //            -3     5
    //        //        -10    9
    public static TreeNode sortedArrayToBSTError(int[] nums) {
        int len = nums.length;
        int mid = len / 2;
        int left = mid - 1, right = mid + 1;

        TreeNode root = new TreeNode(nums[mid]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        // 循环停止条件：left<0 && right>len-1
        // 上式取反：！(left<0 && right>len-1)  得 left>=0 || right<=len-1
        while (!(left < 0 && right > len - 1)) {
            TreeNode leftNode = null;
            TreeNode rightNode = null;
            if (left >= 0) {
                leftNode = new TreeNode(nums[left]);
                queue.add(leftNode);
            }

            if (right <= len - 1) {
                rightNode = new TreeNode(nums[right]);
                queue.add(rightNode);
            }

            TreeNode queueHead = queue.element();
            if (queueHead.left != null && queueHead.right != null) {
                queue.remove();
                if (leftNode != null) {
                    queue.element().left = leftNode;
                }
                if (rightNode != null) {
                    queue.element().right = rightNode;
                }
            } else {
                if (leftNode != null) {
                    queueHead.left = leftNode;
                }
                if (rightNode != null) {
                    queueHead.right = rightNode;
                }
            }
            left--;
            right++;
        }
        return root;

    }
}
