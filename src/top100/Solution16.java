package top100;

/**
 * @author: zhangchen
 * @date: 2021/2/27
 * @description: 将有序数组转化为二叉搜索树
 */

public class Solution16 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int low, int high) {
        if (low > high) {
            return null;
        }

        int mid = (low + high) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = sortedArrayToBST(nums, low, mid - 1);
        node.right = sortedArrayToBST(nums, mid + 1, high);

        return node;
    }

}
