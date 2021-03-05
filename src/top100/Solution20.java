package top100;

/**
 * @author: zhangchen
 * @date: 2021/3/5
 * @description: 手写快排 可以看我的CSDN讲解，非常清晰  https://blog.csdn.net/qq_41132565/article/details/107734923
 */

public class Solution20 {
    public void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int index = partition(arr, low, high);
            quickSort(arr, low, index - 1);
            quickSort(arr, index + 1, high);
        }

    }

    public int partition(int[] arr, int low, int high) {
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

    public void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }


    public static void main(String[] args) {
        Solution20 solution20 = new Solution20();
        int[] test = {22, 45, 58, 7, 83, 23, 4, 5, 7567, 10};
        System.out.println("排序前");
        for (int i : test) {
            System.out.print(i + "  ");
        }
        System.out.println("======================");
        solution20.quickSort(test);
        System.out.println("排序后");
        for (int i : test) {
            System.out.print(i + "  ");
        }
    }
}
