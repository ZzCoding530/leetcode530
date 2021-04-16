package easy;


/**
 * @author: zhangchen
 * @date: 2021/1/12
 * @description: 反转二叉树
 */

public class Solution226 {
    public TreeNode invertTree(TreeNode root) {

        //节点是空的就不用翻转了
        if (root == null) {
            return null;
        }

        //左右节点交换，类似链表反转
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;


        //然后递归地处理这个节点的左节点和右节点
        invertTree(root.left);
        invertTree(root.right);


        return root;

    }
}
