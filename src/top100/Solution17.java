package top100;

/**
 * @author: zhangchen
 * @date: 2021/2/27
 * @description: 平衡二叉树
 */

public class Solution17 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        //不是二叉树的情况：
        // 1  深度相差超过1
        // 2  左或者右子树有一个不是平衡的
        return Math.abs(depth(root.left) - depth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }

}
