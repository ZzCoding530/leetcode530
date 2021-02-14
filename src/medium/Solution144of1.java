package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zhangchen
 * @date: 2021/1/26
 * @description: 二叉树前序遍历 递归法
 */

public class Solution144of1 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        preorder(root, res);
        return res;
    }

    public void preorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
            res.add(root.val);
            preorder(root.left, res);
            preorder(root.right, res);
        }

}
