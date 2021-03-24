package sort;

/**
 * @author: zhangchen
 * @date: 2021/3/24
 * @description:
 */

public interface SortIml {

    /**
     * 就是排序算法的实现
     *
     * @param inputArr 输入数组
     */
    void sort(int[] inputArr);

    /**
     * 展示一下排序后的结果
     *
     * @param inputArr 排序后的数组
     */
    void showResult(int[] inputArr);
}
