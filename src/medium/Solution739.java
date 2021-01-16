package medium;

import java.util.Stack;

/**
 * @author: zhangchen
 * @date: 2021/1/16
 * @description:
 */

public class Solution739 {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int[] ansArr = new int[T.length];

        for (int i = T.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && T[stack.peek()] <= T[i]) {
                stack.pop();
            }

            ansArr[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }


        return ansArr;
    }


    public static void main(String[] args) {
        Solution739 solution739 = new Solution739();

        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] ints = solution739.dailyTemperatures(T);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + "\t");
        }

    }
}
