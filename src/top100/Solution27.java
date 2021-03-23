package top100;

/**
 * @author: zhangchen
 * @date: 2021/3/23
 * @description: 二叉树的直径
 */

public class Solution27 {

    int resMax = Integer.MIN_VALUE;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        dfs(root);
        return resMax;

    }

    private int dfs(TreeNode root) {
        if (root.left == null && root.right == null) {
            return 0;
        }

        int leftLength = root.left == null ? 0 : dfs(root.left) + 1;
        int rightLength = root.right == null ? 0 : dfs(root.right) + 1;
        resMax = Math.max(resMax, leftLength + rightLength);
        return Math.max(leftLength, rightLength);

    }
}
