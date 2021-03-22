package top100;

/**
 * @author: zhangchen
 * @date: 2021/3/22
 * @description: 二叉树最大路径和
 */

public class Solution25 {
    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        //分别是 我这个节点的左侧最大值和右侧最大值（不包括自己）
        int leftMax = Math.max(0, dfs(root.left));
        int rightMax = Math.max(0, dfs(root.right));

        //算一下经过我这点的最大值，看看需不需要更新
        res = Math.max(res, root.val + leftMax + rightMax);

        //要返回一个值，这个值是我的父节点，如果要经过我，那么我能给父节点提供的最大值是多少
        return root.val + Math.max(leftMax, rightMax);

    }
}
