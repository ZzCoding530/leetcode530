package easy;

/**
 * @author: zhangchen
 * @date: 2021/1/19
 * @description:
 */

public class Solution21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //首先特殊情况
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
