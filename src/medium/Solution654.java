package medium;

/**
 * @author: zhangchen
 * @date: 2021/1/12
 * @description: 构建最大二叉树
 */

public class Solution654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }


    /**
     * 这里不需要截取数组，直接按照首尾index取就行了
     */
    public TreeNode build(int[] nums, int low, int high) {
        if (low > high) {
            return null;
        }

        int maxIndex = -1, maxVal = Integer.MIN_VALUE;
        for (int i = low; i <= high; i++) {
            if (nums[i] > maxVal) {
                maxIndex = i;
                maxVal = nums[i];
            }

        }

        TreeNode root = new TreeNode(maxVal);

        root.left = build(nums, low, maxIndex - 1);
        root.right = build(nums, maxIndex + 1, high);

        return root;
    }


}
