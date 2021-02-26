package top100;

/**
 * @author: zhangchen
 * @date: 2021/2/25
 * @description: 删除链表倒数第N个节点
 */

public class Solution12 {
    /**
     * 快慢指针 先找到倒数第N个，然后再删了
     *
     * @param head 头节点
     * @param n    第几个
     * @return 新头节点
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = new ListNode();
        temp.next = head;
        ListNode slow = temp;
        ListNode fast = head;
        while (n > 0) {
            fast = fast.next;
            n--;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return temp.next;


    }
}
