package top100;

/**
 * @author: zhangchen
 * @date: 2021/2/26
 * @description: 二叉树最大深度
 */

public class Solution14 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
