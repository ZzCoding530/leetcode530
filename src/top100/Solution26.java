package top100;

/**
 * @author: zhangchen
 * @date: 2021/3/23
 * @description: 翻转二叉树
 */

public class Solution26 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        //调换左右子树
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        //递归
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
