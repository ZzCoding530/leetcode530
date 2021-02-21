package top100;

/**
 * @author: zhangchen
 * @date: 2021/2/21
 * @description: 合并两个有序链表
 */

public class Solution5 {
    /**
     * !!!!!!求求一定要先处理特殊情况!!!!!!
     *
     * 递归啊啊啊啊啊啊啊啊啊
     * 递归啊啊啊啊啊啊
     * 递归啊啊啊
     * 递归啊
     *
     * @param l1 链表1
     * @param l2 链表2
     * @return 结果链表
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
