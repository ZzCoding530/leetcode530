package hard;

import java.util.LinkedList;

/**
 * @author: zhangchen
 * @date: 2021/1/13
 * @description: 序列化二叉树
 */

public class Solution297 {
    String SEP = ",";
    String NULL = "#";

    /**
     * Encodes a tree to a single string.
     * 这是序列化过程
     */
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        mySerialize(root, sb);
        return sb.toString();
    }


    void mySerialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL).append(SEP);
            return;
        }

        sb.append(root.val).append(SEP);
        mySerialize(root.left, sb);
        mySerialize(root.right, sb);
    }

    /**
     * Decodes your encoded data to tree.
     * 这是反序列化过程
     */
    public TreeNode deserialize(String data) {
        LinkedList<String> nodes = new LinkedList<>();
        for (String s : data.split(SEP)) {
            nodes.addLast(s);
        }

        return myDeserialize(nodes);
    }

    public TreeNode myDeserialize(LinkedList<String> nodes) {
        if (nodes.isEmpty()) {
            return null;
        }

        String first = nodes.removeFirst();
        if (first.equals(NULL)) {
            return null;
        }
        TreeNode root = new TreeNode((Integer.parseInt(first)));

        root.left = myDeserialize(nodes);
        root.right = myDeserialize(nodes);


        return root;
    }
}
