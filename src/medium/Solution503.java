package medium;

import java.util.Stack;

/**
 * @author: zhangchen
 * @date: 2021/1/16
 * @description: 下一个更大元素2
 */

public class Solution503 {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] ansArr = new int[nums.length];
        int n = nums.length;
        for (int i = nums.length * 2 - 1; i >= 0; i--) {

            while (!stack.isEmpty() && stack.peek() <= nums[i % n]) {
                stack.pop();
            }

            ansArr[i % n] = stack.isEmpty() ? -1 : stack.peek();

            stack.push(nums[i % n]);

        }

        return ansArr;
    }
}
