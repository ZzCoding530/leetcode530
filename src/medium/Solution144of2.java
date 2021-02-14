package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author: zhangchen
 * @date: 2021/2/14
 * @description: 二叉树先序遍历 迭代法
 */

public class Solution144of2 {
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>(0);
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        List<Integer> ansList = new LinkedList<>();

        while (!stack.isEmpty()) {

            TreeNode node = stack.pop();
            ansList.add(node.val);

            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }

        }

        return ansList;

    }
}
