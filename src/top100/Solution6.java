package top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: zhangchen
 * @date: 2021/2/21
 * @description: 三数之和 找三个数之和等于0
 */

public class Solution6 {
    public List<List<Integer>> threeSum(int[] nums) {
        //先排序
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            //要是大于0那不用看后面的了直接结束 返回之前收集的答案
            if (nums[i] > 0) {
                return ans;
            }

            //如果出现了重复的数字，那就不用判断了 跳过，i等于0时候不要判断哈，
            // 只能是第二个数开始和第一个数重复对吧 所以 i>0 别忘了加
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int currNum = nums[i];
            int left = i + 1;
            int right = nums.length - 1;

            //这里是固定住一个数，然后从这个数的后面开始，到数组末尾，里面找三个数能否和为0
            while (left < right) {
                int tempRes = currNum + nums[left] + nums[right];

                //如果和为0，就先把结果存起来
                if (tempRes == 0) {
                    ArrayList<Integer> insideList = new ArrayList<>(3);
                    insideList.add(currNum);
                    insideList.add(nums[left]);
                    insideList.add(nums[right]);
                    ans.add(insideList);


                    //下面两个while是用来去重的，左右指针遇到重复的就跳过
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                }
                //要是小于0，说明小了，左指针往后走，让和更大
                else if (tempRes < 0) {
                    left++;
                }
                //要是大于0，说明大了，右指针往前走，让和更小
                else {
                    right--;
                }

            }
        }

        return ans;

    }

}
