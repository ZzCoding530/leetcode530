package easy;

/**
 * @author: zhangchen
 * @date: 2021/1/7
 * @description: 删除排序数组中的重复项
 */

public class Solution26 {
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
        }


        return slow + 1;
    }
}
