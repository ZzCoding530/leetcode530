package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: zhangchen
 * @date: 2021/2/12
 * @description: 三数之和
 */

public class Solution15 {


    /**
     * 若 nums[i]>0nums[i]>0：因为已经排序好，所以后面不可能有三个数加和等于 00，直接返回结果。
     * 对于重复元素：跳过，避免出现重复解
     * 令左指针 L=i+1L=i+1，右指针 R=n-1R=n−1，当 L<RL<R 时，执行循环：
     * 当 nums[i]+nums[L]+nums[R]==0nums[i]+nums[L]+nums[R]==0，执行循环，判断左界和右界是否和下一位置重复，去除重复解。并同时将 L,RL,R 移到下一位置，寻找新的解
     * 若和大于 00，说明 nums[R]nums[R] 太大，RR 左移
     * 若和小于 00，说明 nums[L]nums[L] 太小，LL 右移
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] > 0) {
                return ans;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int currNum = nums[i];
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int tempRes = currNum + nums[left] + nums[right];
                if (tempRes == 0) {
                    ArrayList<Integer> insideList = new ArrayList<>(3);
                    insideList.add(currNum);
                    insideList.add(nums[left]);
                    insideList.add(nums[right]);
                    ans.add(insideList);


                    //这里用left++ 结果一样
                    while (left < right && nums[left] == nums[left + 1]) {
                        ++left;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        --right;
                    }

                    ++left;
                    --right;
                } else if (tempRes < 0) {
                    ++left;
                } else {
                    --right;
                }


            }
        }

        return ans;

    }
}
