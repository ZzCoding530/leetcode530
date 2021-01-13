package medium;

/**
 * @author: zhangchen
 * @date: 2021/1/13
 * @description:
 */

public class Solution450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (root.val == key) {
            //deleting...

            //第一种情况
            if (root.left == null && root.right == null) {
                return null;
            }

            //第二种情况
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }

            //第三种情况
            // 找到右子树的最小节点
            TreeNode minNode = getMin(root.right);
            // 把 root 改成 minNode
            root.val = minNode.val;
            // 转而去删除 minNode
            root.right = deleteNode(root.right, minNode.val);

        }

        //这里为什么要返回root.left root.right？
        //因为如果没找到，那就往左或者右子树去处理，然后，要返回，即更新左或者右子树
        //返回一个新的子树，所以需要return
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        }
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }
        return root;

    }

    TreeNode getMin(TreeNode node) {
        // BST 最左边的就是最小的
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
