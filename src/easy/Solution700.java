package easy;

/**
 * @author: zhangchen
 * @date: 2021/1/13
 * @description: 找到BST中某个元素
 */

public class Solution700 {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }
        return val < root.val ? searchBST(root.left, val) : searchBST(root.right, val);
    }
}
