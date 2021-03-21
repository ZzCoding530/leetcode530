package hard;

/**
 * @author: zhangchen
 * @date: 2021/3/21
 * @description: 二叉树最大路径和
 */

public class Solution124 {
    int treeTotalMax = Integer.MAX_VALUE;

    public int maxPathSum(TreeNode root) {

        if (root == null) {
            return 0;
        }

        dfs(root);
        return treeTotalMax;


    }

    int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftMax = Math.max(0, dfs(root.left));
        int rightMax = Math.max(0, dfs(root.right));
        treeTotalMax = Math.max(treeTotalMax, root.val + leftMax + rightMax);

        return root.val + Math.max(leftMax, rightMax);
    }
}
