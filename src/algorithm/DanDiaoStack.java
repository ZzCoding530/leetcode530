package algorithm;

import java.util.Stack;

/**
 * @author: zhangchen
 * @date: 2021/1/16
 * @description: 单调栈
 */

public class DanDiaoStack {
    public int[] nextGreaterElement(int[] nums) {

        int[] answerArr = new int[nums.length];
        Stack<Integer> stack = new Stack<>();

        //从后向前遍历
        for (int i = nums.length - 1; i >= 0; i--) {


            //栈不是空的
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }

            //如果栈不空但 栈顶元素比当前元素大
            answerArr[i] = stack.isEmpty() ? -1 : stack.peek();

            //就把这个数放进去
            stack.push(nums[i]);
        }

        return answerArr;
    }

}
