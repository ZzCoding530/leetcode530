package medium;

import java.util.PriorityQueue;

/**
 * @author: zhangchen
 * @date: 2021/2/12
 * @description: 数组中的第K个最大元素
 */

public class Solution215 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(nums.length);
        for (int num : nums) {
            queue.add(num);
        }

        for (int i = 0; i < nums.length - k; i++) {
            queue.poll();

        }

        return queue.peek();
    }
}
