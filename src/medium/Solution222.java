package medium;

/**
 * @author: zhangchen
 * @date: 2021/1/14
 * @description: 求完全二叉树的元素个数
 */

public class Solution222 {
    public int countNodes(TreeNode root) {

        TreeNode l = root, r = root;
        int lHeight = 0, rHeight = 0;

        while (l != null) {
            l = l.left;
            lHeight++;
        }

        while (r != null) {
            r = r.right;
            rHeight++;
        }

        if (lHeight == rHeight) {
            return (int) Math.pow(2, lHeight) - 1;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);

    }
}
