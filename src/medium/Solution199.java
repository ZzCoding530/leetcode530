package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: zhangchen
 * @date: 2021/2/14
 * @description: 二叉树的右视图
 */

public class Solution199 {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>(0);
        }

        List<Integer> AnsList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int count = queue.size();

            for (int i = 0; i < count; i++) {
                TreeNode node = queue.poll();

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                //将当前层的最后一个节点放入结果列表
                if (i == count - 1) {
                    AnsList.add(node.val);
                }
            }
        }
        return AnsList;
    }


}
