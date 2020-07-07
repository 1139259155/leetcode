package com.pengbo.mydemo.No_112_路径总和;

/**
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例: 
 * 给定如下二叉树，以及目标和 sum = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \      \
 * 7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    public boolean hasPathSum(TreeNode root, int sum) {

        if (root == null) return false;

        if (root.left == null && root.right == null && root.val == sum)
            return true;

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode a5 = new TreeNode(5);
        TreeNode a4 = new TreeNode(4);
        TreeNode a8 = new TreeNode(8);
        TreeNode a11 = new TreeNode(11);
        TreeNode a13 = new TreeNode(13);
        TreeNode a4_1 = new TreeNode(4);
        TreeNode a7 = new TreeNode(7);
        TreeNode a2 = new TreeNode(2);
        TreeNode a1 = new TreeNode(1);

        a5.left = a4;
        a5.right = a8;

        a4.left = a11;

        a8.left = a13;
        a8.right = a4_1;

        a11.left = a7;
        a11.right = a2;

        a4_1.right = a1;

        System.out.println(solution.hasPathSum(a5, 22));
    }
}

