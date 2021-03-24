package sort;

/**
 * @author: zhangchen
 * @date: 2021/3/24
 * @description: 测试各种排序算法
 */

public class TestSort {
    public static void main(String[] args) {
        int[] testArr = {3, 9, 5, 2, 53, 7677, 24, 234, 89, 8};
//        InsertSort insertSort = new InsertSort();
//        insertSort.sort(testArr);
//        insertSort.showResult(testArr);

        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(testArr);
        mergeSort.showResult(testArr);
    }
}
