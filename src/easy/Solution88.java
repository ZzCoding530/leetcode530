package easy;

/**
 * @author: zhangchen
 * @date: 2021/2/15
 * @description: 合并两个有序数组
 */

public class Solution88 {

    /**
     * 思路：从后面开始比，谁大放谁，然后把剩下的直接复制过去
     *
     * @param nums1 1
     * @param m     1
     * @param nums2 1
     * @param n     1
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n - 1;

        int p1 = m - 1;
        int p2 = n - 1;

        while (p2 >= 0 && p1 >= 0) {
            if (nums1[p1] >= nums2[p2]) {
                nums1[index--] = nums1[p1--];
            } else {
                nums1[index--] = nums2[p2--];
            }
        }

        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);


    }
}
