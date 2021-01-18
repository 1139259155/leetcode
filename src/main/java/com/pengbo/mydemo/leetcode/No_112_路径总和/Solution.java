package com.pengbo.mydemo.leetcode.No_112_路径总和;

import com.pengbo.mydemo.leetcode.No_112_路径总和.TreeNode;

/**
 * https://leetcode-cn.com/problems/path-sum
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

