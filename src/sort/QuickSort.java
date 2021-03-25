package sort;

import java.util.Arrays;

/**
 * @author: zhangchen
 * @date: 2021/3/24
 * @description: 祝自己生日快乐🎂
 */

public class QuickSort implements SortIml {
    /**
     * 快排也是递归
     *
     * @param inputArr 输入数组
     */
    @Override
    public void sort(int[] inputArr) {
        sort(inputArr, 0, inputArr.length - 1);
    }

    public void sort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }

        int partitionIndex = partition(arr, low, high);
        sort(arr, low, partitionIndex - 1);
        sort(arr, partitionIndex + 1, high);
    }

    private int partition(int[] arr, int low, int high) {
        int bound = arr[low];
        int i = low;
        int j = high;

        while (i < j) {
            while (arr[j] >= bound && i < j) {
                j--;
            }

            while (arr[i] <= bound && i < j) {
                i++;
            }

            swap(arr, i, j);

        }

        swap(arr, i, low);
        return i;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    @Override
    public void showResult(int[] inputArr) {
        System.out.println("快速排序后的结果为：" + Arrays.toString(inputArr));
    }
}
