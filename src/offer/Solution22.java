package offer;

/**
 * @author: zhangchen
 * @date: 2021/2/6
 * @description:
 */

public class Solution22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;
        while (k > 1) {
            fast = fast.next;
            k--;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;

        }

        return slow;

    }
}
