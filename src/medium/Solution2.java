package medium;

/**
 * @author: zhangchen
 * @date: 2021/1/9
 * @description:
 */


public class Solution2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode h = head;

        int sum;
        boolean carry = false;

        while (l1 != null || l2 != null) {

            sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            if (carry) {
                sum++;
            }

            h.next = new ListNode(sum % 10);
            h = h.next;
            carry = sum >= 10;

        }

        if (carry) {
            h.next = new ListNode(1);
        }

        return head.next;
    }
}
