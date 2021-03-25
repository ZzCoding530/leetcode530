package sort;

import java.util.Arrays;

/**
 * @author: zhangchen
 * @date: 2021/3/25
 * @description:
 */

public class HeapSort implements SortIml {
    @Override
    public void sort(int[] inputArr) {
        int len = inputArr.length;

        heapify(inputArr);

        for (int i = len - 1; i >= 1; ) {
            swap(inputArr, 0, i);
            i--;
            sink(inputArr, 0, i);
        }

    }

    private void heapify(int[] nums) {
        int len = nums.length;
        for (int i = (len - 1) / 2; i >= 0; i--) {
            sink(nums, i, len - 1);
        }
    }

    /**
     * 下沉过程
     *
     * @param nums 输入数组
     * @param curr 需要下沉的元素坐标
     * @param end  数组最后的边界 0-end有效
     */
    private void sink(int[] nums, int curr, int end) {
        while (2 * curr + 1 <= end) {

            int j = 2 * curr + 1;
            if (2 * curr + 2 <= end) {
                j = nums[j] > nums[j + 1] ? j : j + 1;
            }

            if (nums[j] > nums[curr]) {
                swap(nums, j, curr);
                curr = j;
            } else {
                break;
            }

        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    @Override
    public void showResult(int[] inputArr) {
        System.out.println("堆排序后的结果为：" + Arrays.toString(inputArr));
    }
}
