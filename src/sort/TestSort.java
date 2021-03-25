package sort;

/**
 * @author: zhangchen
 * @date: 2021/3/24
 * @description: 测试各种排序算法
 */

public class TestSort {
    public static void main(String[] args) {
        int[] testArr = {34, 665, 435, 65, 7562, 423, 789, 213, 68, 807, 334, 7, 697, 3, 576, 88089, 34, 24, 2};
//        InsertSort insertSort = new InsertSort();
//        insertSort.sort(testArr);
//        insertSort.showResult(testArr);

//        MergeSort mergeSort = new MergeSort();
//        mergeSort.sort(testArr);
//        mergeSort.showResult(testArr);
//
//        QuickSort quickSort = new QuickSort();
//        quickSort.sort(testArr);
//        quickSort.showResult(testArr);

        HeapSort heapSort = new HeapSort();
        heapSort.sort(testArr);
        heapSort.showResult(testArr);
    }
}
