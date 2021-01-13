package medium;

/**
 * @author: zhangchen
 * @date: 2021/1/13
 * @description: 寻找第K小第元素
 */

public class Solution230 {
    public int kthSmallest(TreeNode root, int k) {
        printTree(root, k);
        return result;
    }

    int result = 0;
    int rank = 0;

    public void printTree(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        printTree(root.left, k);

        rank++;
        if (k == rank) {
            result = root.val;
            return;
        }

        printTree(root.right, k);
    }
}
