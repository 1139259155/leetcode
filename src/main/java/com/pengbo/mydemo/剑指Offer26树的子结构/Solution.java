package com.pengbo.mydemo.剑指Offer26树的子结构;

/**
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 *
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 *
 * 例如:
 * 给定的树 A:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 B：
 *
 *    4 
 *   /
 *  1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 *
 * 示例 1：
 *
 * 输入：A = [1,2,3], B = [3,1]
 * 输出：false
 * 示例 2：
 *
 * 输入：A = [3,4,5,1,2], B = [4,1]
 * 输出：true
 * 限制：
 *
 * 0 <= 节点个数 <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public TreeNode b;

    public boolean isSubStructure(TreeNode a, TreeNode b) {
        if (b == null) return false;

        this.b = b;

        return preOrderAFindB(a);
    }

    private boolean preOrderAFindB(TreeNode a) {
        if (a==null) return false;

        if (a.val == this.b.val) {
            if (isTheSame(a, this.b) > 0)
                return true;
        }
        if (preOrderAFindB(a.left))
            return true;
        if (preOrderAFindB(a.right))
            return true;

        return false;
    }

    private int isTheSame(TreeNode a, TreeNode b) {

        if (b == null) return 1;

        if (a == null || a.val != b.val)
            return 0;

        if (isTheSame(a.left, b.left) == 0)
            return 0;
        if (isTheSame(a.right, b.right) == 0)
            return 0;
        return 1;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        /**
         *      3
         *     / \
         *    4   5
         *   / \
         *  1   2
         * 给定的树 B：
         *
         *    4
         *   /
         *  1
         */

        TreeNode a1=new TreeNode(1);
        TreeNode a2=new TreeNode(2);
        TreeNode a3=new TreeNode(3);
        TreeNode a4=new TreeNode(4);
        TreeNode a5=new TreeNode(5);

        a3.left=a4;
        a3.right=a5;

        a4.left=a1;
        a4.right=a2;

        TreeNode b1=new TreeNode(1);
        TreeNode b4=new TreeNode(4);

        b4.left=b1;

        System.out.println(solution.isSubStructure(a3, b4));

    }
}

