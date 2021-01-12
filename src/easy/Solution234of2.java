package easy;


/**
 * @author: zhangchen
 * @date: 2021/1/12
 * @description: 234的第二种实现方法
 */

public class Solution234of2 {
    public boolean isPalindrome(ListNode head) {
        ListNode fast, slow;
        fast = slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) {
            slow = slow.next;
        }

        ListNode reverse = reverse(slow);

        while (reverse != null && head != null) {
            if (reverse.val != head.val) {
                return false;
            }
            reverse = reverse.next;
            head = head.next;
        }


        return true;
    }

    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode nxt;

        while (head != null) {
            nxt = head.next;
            head.next = pre;
            pre = head;
            head = nxt;
        }

        return pre;


    }
}
