package offer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author: zhangchen
 * @date: 2021/2/6
 * @description:
 */

public class Solution40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] vec = new int[k];
        // 排除 0 的情况
        if (k == 0) {
            return vec;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer num1, Integer num2) {
                return num2 - num1;
            }
        });
        for (int i = 0; i < k; ++i) {
            queue.offer(arr[i]);
        }
        for (int i = k; i < arr.length; ++i) {
            if (queue.peek() > arr[i]) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        for (int i = 0; i < k; ++i) {
            vec[i] = queue.poll();
        }
        return vec;
    }

}
