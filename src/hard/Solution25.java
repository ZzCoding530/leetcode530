package hard;

/**
 * @author: zhangchen
 * @date: 2021/1/12
 * @description: K个一组反转链表
 */

public class Solution25 {

    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null || head.next == null) {
            return null;
        }

        ListNode tail = head;
        for (int i = 0; i < k; i++) {
            if (tail == null) {
                return head;
            }
            tail = tail.next;
        }

        ListNode newHead = kReverse(head, tail);
        head.next = reverseKGroup(tail, k);

        return newHead;
    }


    public ListNode kReverse(ListNode a, ListNode b) {

        ListNode pre, nxt;
        pre = null;
        while (a != b) {
            nxt = a.next;
            a.next = pre;
            pre = a;
            a = nxt;
        }

        return pre;
    }

}
