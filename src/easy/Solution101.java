package easy;

/**
 * @author: zhangchen
 * @date: 2021/4/15
 * @description: 对称二叉树
 */

public class Solution101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        //调用递归函数，比较左节点，右节点
        return dfs(root.left, root.right);
    }


    boolean dfs(TreeNode left, TreeNode right) {

        //如果左右节点都为空，那结构上就是对称的
        if (left == null && right == null) {
            return true;
        }

        //如果上面条件不满足，就说明不是左右都空
        //继续判断 是否左右之间只有一个为空
        //这样从结构上就不对称的 false
        if (left == null || right == null) {
            return false;
        }

        //两个都不是空的话，结构上没问题，数值上如果不想等，就也是false
        if (left.val != right.val) {
            return false;
        }
        //再递归的比较 左节点的左孩子 和 右节点的右孩子
        //以及比较  左节点的右孩子 和 右节点的左孩子
        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }

}
