package easy;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author: zhangchen
 * @date: 2021/1/16
 * @description:
 */

public class Solution496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> ansMap = new HashMap<>(nums1.length);
        Stack<Integer> stack = new Stack<>();
        int[] ansArr = new int[nums1.length];
        int result = -1;

        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums2[i] >= stack.peek()) {
                stack.pop();
            }

            result = stack.isEmpty() ? -1 : stack.peek();
            ansMap.put(nums2[i], result);

            stack.push(nums2[i]);
        }

        for (int i = 0; i < nums1.length; i++) {
            ansArr[i] = ansMap.get(nums1[i]);
        }


        return ansArr;
    }
}
