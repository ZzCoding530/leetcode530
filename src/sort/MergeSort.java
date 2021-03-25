package sort;

import java.util.Arrays;

/**
 * @author: zhangchen
 * @date: 2021/3/24
 * @description: 归并排序的手写
 */

public class MergeSort implements SortIml {

    @Override
    public void sort(int[] inputArr) {
        mergeSort(inputArr, 0, inputArr.length);
    }

    private void mergeSort(int[] arr, int low, int high) {
        if (high - low <= 1) {
            return;
        }

        int mid = (low + high) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid, high);
        mergeTwoArr(arr, low, mid, high);

    }

    private void mergeTwoArr(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];

        int less = low;
        int great = mid;
        int index = 0;

        while (less < mid && great < high) {
            if (arr[great] > arr[less]) {
                temp[index] = arr[less];
                less++;
                index++;
            } else {
                temp[index] = arr[great];
                great++;
                index++;
            }
        }

        while (less < mid) {
            temp[index++] = arr[less++];
        }

        while (great < high) {
            temp[index++] = arr[great++];
        }

        if (high - low >= 0) {
            System.arraycopy(temp, 0, arr, low, high - low);
        }
    }

    @Override
    public void showResult(int[] inputArr) {
        System.out.println("归并排序后的结果为：" + Arrays.toString(inputArr));
    }
}
