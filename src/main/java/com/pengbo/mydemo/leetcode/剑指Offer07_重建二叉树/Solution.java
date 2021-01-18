package com.pengbo.mydemo.leetcode.剑指Offer07_重建二叉树;
/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 5000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof
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

import java.util.Arrays;

class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0)
            return null;

        //find Root in inorder
        int value = preorder[0];
        int rootIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == value) {
                rootIndex = i;
                break;
            }
        }

        TreeNode treeNode = new TreeNode(value);
        // have left tree: rootIndex 不是数组第一位 index
        if (rootIndex > 0)
            treeNode.left = buildTree(Arrays.copyOfRange(preorder, 1, rootIndex + 1),
                    Arrays.copyOfRange(inorder, 0, rootIndex));
        // have right tree: rootIndex 不是数组最后一位 index
        if (rootIndex + 1 < preorder.length)
            treeNode.right = buildTree(Arrays.copyOfRange(preorder, rootIndex + 1, preorder.length),
                    Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length));

        return treeNode;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();

        /**
         *     3
         *    / \
         *   9  20
         *     /  \
         *    15   7
         */
        System.out.println("-------case1------");
        TreeNode treeNode = solution.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        preOrder(treeNode);
        System.out.println();
        inOrder(treeNode);

        /**
         *     1
         *      \
         *       2
         *        \
         *         3
         *          \
         *           4
         *            \
         *             5
         */
        System.out.println("-------case2------");
        treeNode = solution.buildTree(new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 3, 4, 5});
        preOrder(treeNode);
        System.out.println();
        inOrder(treeNode);

        /**
         *           1
         *          /
         *         2
         *        /
         *       3
         *      /
         *     4
         *    /
         *   5
         */
        System.out.println("-------case3------");
        treeNode = solution.buildTree(new int[]{1, 2, 3, 4, 5}, new int[]{5, 4, 3, 2, 1});
        preOrder(treeNode);
        System.out.println();
        inOrder(treeNode);

        /**
         *     1
         *      \
         *       2
         *        \
         *         3
         *        /
         *       4
         *      /
         *     5
         */
        System.out.println("-------case4------");
        treeNode = solution.buildTree(new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 3, 5, 4});
        preOrder(treeNode);
        System.out.println();
        inOrder(treeNode);

        /**
         *           1
         *          /
         *         2
         *        /
         *       3
         *        \
         *         4
         *          \
         *           5
         */
        System.out.println("-------case5------");
        treeNode = solution.buildTree(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 2, 1});
        preOrder(treeNode);
        System.out.println();
        inOrder(treeNode);
        System.out.println();

    }

    public static void preOrder(TreeNode root) {
        if (root == null) {
            //System.out.println("null");
            return;
        }
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(TreeNode root) {
        if (root == null) {
            //System.out.println("null");
            return;
        }
        inOrder(root.left);
        System.out.println(root.val);
        inOrder(root.right);
    }

}


