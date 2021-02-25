package top100;

import java.util.Arrays;

/**
 * @author: zhangchen
 * @date: 2021/2/25
 * @description: 下一个排列
 */

public class Solution11 {
    public void nextPermutation(int[] nums) {
        if (nums.length == 1) {
            return;
        }

        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                Arrays.sort(nums, i, nums.length);
                for (int j = i; j < nums.length; j++) {
                    if (nums[j] > nums[i - 1]) {
                        swap(nums, j, i - 1);
                        return;
                    }
                }
            }
        }

        Arrays.sort(nums);
    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[b];
        nums[b] = nums[a];
        nums[a] = temp;
    }

}
