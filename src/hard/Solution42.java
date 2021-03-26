package hard;

import java.util.Stack;

/**
 * @author: zhangchen
 * @date: 2021/3/26
 * @description: 接雨水
 */

public class Solution42 {
    public int trap(int[] height) {

        int result = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int curr = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }

                int l = stack.peek();
                int r = i;

                result = result + (r - l - 1) * (Math.min(height[l], height[r]) - height[curr]);

            }
            stack.push(i);
        }


        return result;
    }
}
