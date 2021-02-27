package top100;

import java.util.HashMap;

/**
 * @author: zhangchen
 * @date: 2021/2/27
 * @description: 从前序与中序遍历序列构造二叉树
 */

public class Solution15 {
    private HashMap<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;
        map = new HashMap<>(len);

        for (int i = 0; i < len; i++) {
            map.put(inorder[i], i);
        }

        return buildTree(preorder, inorder, 0, len - 1, 0, len - 1);
    }

    /**
     * 思路不难，coding确实挺难
     *
     * @param preorder                前序遍历得到的数组
     * @param inorder                 中序遍历得到的数组
     * @param left_bound_of_preorder  用来划分前序数组的左边界
     * @param right_bound_of_preorder 用来划分前序数组的右边界
     * @param left_bound_of_inorder   用来划分中序数组的左边界
     * @param right_bound_of_inorder  用来划分中序数组的右边界
     * @return 返回重构出的二叉树
     */
    private TreeNode buildTree(int[] preorder, int[] inorder, int left_bound_of_preorder, int right_bound_of_preorder, int left_bound_of_inorder, int right_bound_of_inorder) {

        if (left_bound_of_preorder > right_bound_of_preorder) {
            return null;
        }

        int root_index_in_pre = left_bound_of_preorder;
        int root_index_in_in = map.get(preorder[root_index_in_pre]);

        TreeNode root = new TreeNode(preorder[root_index_in_pre]);

        int size_of_left_subtree = root_index_in_in - left_bound_of_inorder;

        root.left = buildTree(preorder, inorder, left_bound_of_preorder + 1, left_bound_of_preorder + size_of_left_subtree, left_bound_of_inorder, root_index_in_in);
        root.right = buildTree(preorder, inorder, left_bound_of_preorder + size_of_left_subtree + 1, right_bound_of_preorder, root_index_in_in + 1, right_bound_of_inorder);
        return root;


    }


}
