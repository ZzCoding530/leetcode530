package easy;

/**
 * @author: zhangchen
 * @date: 2021/1/18
 * @description:
 */

public class Solution876 {
    public ListNode middleNode(ListNode head) {
        ListNode fast, slow;
        fast = slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;

    }
}
