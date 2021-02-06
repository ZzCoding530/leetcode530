package offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zhangchen
 * @date: 2021/2/6
 * @description: 重建二叉树
 */

public class Solution07 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //把前序遍历的值和中序遍历的值放到list中
        List<Integer> preorderList = new ArrayList<>();
        List<Integer> inorderList = new ArrayList<>();
        for (int i = 0; i < preorder.length; i++) {
            preorderList.add(preorder[i]);
            inorderList.add(inorder[i]);
        }
        return builder(preorderList, inorderList);
    }

    private TreeNode builder(List<Integer> preorderList, List<Integer> inorderList) {
        if (inorderList.isEmpty()) {
            return null;
        }
        //前序遍历的第一个值就是根节点
        int rootVal = preorderList.remove(0);

        //创建跟结点
        TreeNode root = new TreeNode(rootVal);

        // 递归构建左右子树
        // 先找到根节点在中序遍历中的位置，进行划分
        int rootindex = inorderList.indexOf(rootVal);

        // 构建左子树，范围 [0:rootindex)
        root.left = builder(preorderList, inorderList.subList(0, rootindex));

        // 构建右子树，范围 (rootindex:最后的位置]
        root.right = builder(preorderList, inorderList.subList(rootindex + 1, inorderList.size()));
        // 返回根节点
        return root;
    }


}
