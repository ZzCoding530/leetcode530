package easy;

/**
 * @author: zhangchen
 * @date: 2021/2/15
 * @description: 二叉树直径
 */

public class Solution543 {
    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return max;
    }

    /**
     * 思路是遍历每个节点 计算左右深度 留最大的
     *
     * @param root 中心节点
     * @return root为中心的深度
     */
    private int dfs(TreeNode root) {
        if (root.left == null && root.right == null) {
            return 0;
        }
        int leftSize = root.left == null ? 0 : dfs(root.left) + 1;
        int rightSize = root.right == null ? 0 : dfs(root.right) + 1;
        max = Math.max(max, leftSize + rightSize);
        return Math.max(leftSize, rightSize);
    }
}
