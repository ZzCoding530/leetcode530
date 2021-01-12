package medium;

/**
 * @author: zhangchen
 * @date: 2021/1/12
 * @description:
 */

public class Solution116 {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        connectTwoNode(root.left, root.right);
        return root;


    }


    public void connectTwoNode(Node node1, Node node2) {
        if (node1 == null || node2 == null) {
            return;
        }

        node1.next = node2;

        connectTwoNode(node1.left, node1.right);
        connectTwoNode(node2.left, node2.right);

        connectTwoNode(node1.right, node2.left);
    }
}
