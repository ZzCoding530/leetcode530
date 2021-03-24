package sort;

import java.util.Arrays;

/**
 * @author: zhangchen
 * @date: 2021/3/24
 * @description: 插入排序
 */

public class InsertSort implements SortIml {

    @Override
    public void sort(int[] inputArr) {
        for (int i = 1; i < inputArr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (inputArr[j - 1] > inputArr[j]) {
                    swap(inputArr, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    private void swap(int[] inputArr, int i, int j) {
        int temp = inputArr[j];
        inputArr[j] = inputArr[i];
        inputArr[i] = temp;
    }

    @Override
    public void showResult(int[] inputArr) {
        System.out.println("插入排序后的结果为：" + Arrays.toString(inputArr));
    }
}
