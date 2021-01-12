package medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: zhangchen
 * @date: 2021/1/12
 * @description: 找二叉树中重复的子树
 */

public class Solution652 {

    /**
     * 这个hashmap存的是所有子树出现过的次数
     */
    HashMap<String, Integer> hashMap = new HashMap<>();

    /**
     * 这个存的是最终返回的答案， 一个列表，里面放的都是重复的子树
     */
    LinkedList<TreeNode> result = new LinkedList<>();


    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        treeToString(root);
        return result;

    }


    /**
     * 如何比较两个二叉树是否一样呢？
     * 都变成一个字符串比较字符串就行，这里采用后序或者前序遍历都行，中序不行
     */
    public String treeToString(TreeNode root) {
        if (root == null) {
            return "#";
        }

        String rightString = treeToString(root.right);
        String leftString = treeToString(root.left);

        String subTreeString = leftString + "," + rightString + "," + root.val;

        //从存频率的map里取出这个子树的出现次数
        int freq = hashMap.getOrDefault(subTreeString, 0);
        //要是次数为1，即出现过，那就加入答案的列表里，而且是等于1不是大于1，仅在第一次重复时候加入，避免重复加入列表
        if (freq == 1) {
            result.add(root);
        }
        //更新这个子树的出现频率
        hashMap.put(subTreeString, freq + 1);
        return subTreeString;


    }
}
