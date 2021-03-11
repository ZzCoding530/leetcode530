package top100;

/**
 * @author: zhangchen
 * @date: 2021/3/11
 * @description: 合并两个有序链表
 */

public class Solution21 {
    /**
     * 迭代法
     */
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0);
        ListNode head = ans;

        while (l1 != null && l2 != null) {
            if (l1.val >= l2.val) {
                head.next = l2;
                head = head.next;
                l2 = l2.next;
            } else {
                head.next = l1;
                head = head.next;
                l1 = l1.next;
            }
        }

        if (l1 != null) {
            head.next = l1;
        } else {
            head.next = l2;
        }


        return ans;
    }

    /**
     * 递归
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }

}
