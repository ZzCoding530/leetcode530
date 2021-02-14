package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author: zhangchen
 * @date: 2021/2/14
 * @description: 二叉树后序遍历
 */

public class Solution145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>(0);
        }

        Stack<TreeNode> stack = new Stack<>();
        List<Integer> ansList = new LinkedList<>();
        Stack<Integer> tempStack = new Stack<>();

        stack.push(root);

        while (!stack.isEmpty()) {

            TreeNode node = stack.pop();
            tempStack.push(node.val);

            if (node.left != null) {
                stack.push(node.left);
            }

            if (node.right != null) {
                stack.push(node.right);
            }

        }
        while (!tempStack.isEmpty()) {
            ansList.add(tempStack.pop());
        }
        return ansList;
    }
}
