package medium;

/**
 * @author: zhangchen
 * @date: 2021/1/12
 * @description: 二叉树展开为链表
 */

public class Solution114 {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        flatten(root.left);
        flatten(root.right);


        //此时左右子树已经被分别拉成一条线了
        TreeNode oldLeft = root.left;
        TreeNode oldRight = root.right;
        root.left = null;
        root.right = oldLeft;

        TreeNode lastNode = root;
        while (lastNode.right != null) {
            lastNode = lastNode.right;
        }

        lastNode.right = oldRight;
    }
}
