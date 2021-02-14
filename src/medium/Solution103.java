package medium;

import java.util.*;

/**
 * @author: zhangchen
 * @date: 2021/2/14
 * @description: 锯齿形层序遍历二叉树
 */

public class Solution103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>(0);
        }

        List<List<Integer>> ansList = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        boolean leftToRight = true;
        queue.add(root);

        while (!queue.isEmpty()) {
            int count = queue.size();
            Deque<Integer> levelList = new LinkedList<>();
            while (count > 0) {
                TreeNode node = queue.poll();
                if (leftToRight) {
                    levelList.addLast(node.val);
                } else {
                    levelList.addFirst(node.val);
                }

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }

                count--;

            }

            ansList.add(new LinkedList<>(levelList));
            leftToRight = !leftToRight;

        }

        return ansList;

    }
}
