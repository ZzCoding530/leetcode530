package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author: zhangchen
 * @date: 2021/2/14
 * @description: 二叉树中序遍历
 */

public class Solution94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>(0);
        }

        List<Integer> ansList = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || root != null) {

            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                ansList.add(root.val);
                root = root.right;
            }
        }

        return ansList;

    }
}
