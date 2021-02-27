package top100;

/**
 * @author: zhangchen
 * @date: 2021/2/27
 * @description: 路径总和
 */

public class Solution18 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        //这个判断子节点是这样理解的，  如果你作为root节点，没有左没有右，就自己，那你自己的值如果等于目标值，不就找到了？
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

}
