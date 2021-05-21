package medium;

/**
 * @author: zhangchen
 * @date: 2021/5/21
 * @description: 重排链表
 */

public class Solution143 {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        //先找中间
        ListNode middleNode = findMiddleNode(head);
        ListNode l1 = head;
        ListNode l2 = middleNode.next;

        //让中间节点指向null，才能反转，不然最后俩链表相交了
        middleNode.next = null;
        l2 = reverse(l2);

        mergerTwo(l1, l2);

    }


    /**
     * 找链表中点的函数
     *
     * @param head 头节点
     * @return 新头节点
     */
    public ListNode findMiddleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }


    /**
     * 翻转链表函数
     *
     * @param head 头节点
     * @return 新头节点
     */
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode now = head;

        while (now != null) {
            ListNode temp = now.next;
            now.next = prev;
            prev = now;
            now = temp;
        }

        return prev;
    }


    /**
     * 合并的操作
     *
     * @param l1 第一个链表头节点
     * @param l2 第二个链表头节点
     */
    public void mergerTwo(ListNode l1, ListNode l2) {
        ListNode l1Temp;
        ListNode l2Temp;

        while (l1 != null && l2 != null) {
            l1Temp = l1.next;
            l2Temp = l2.next;

            l1.next = l2;
            l1 = l1Temp;

            //此时l1已经变了，变成一开始的后一个了
            l2.next = l1;
            l2 = l2Temp;
        }
    }
}
