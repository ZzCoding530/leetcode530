package easy;

/**
 * @author: zhangchen
 * @date: 2021/4/11
 * @description: 平衡二叉树
 */

public class Solution110 {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return false;
        }

        int leftHeight = lengthOfTree(root.left);
        int rightHeight = lengthOfTree(root.right);

        return Math.abs(leftHeight - rightHeight) < 2 && isBalanced(root.left) && isBalanced(root.right);

    }

    public int lengthOfTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftLength = lengthOfTree(root.left);
        int rightLength = lengthOfTree(root.right);
        return leftLength > rightLength ? leftLength + 1 : rightLength + 1;
    }
}
