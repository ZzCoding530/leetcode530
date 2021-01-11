package offer;

/**
 * @author: zhangchen
 * @date: 2021/1/11
 * @description: 反转链表
 */

public class Solution24 {
    public ListNode reverseList(ListNode head) {

        ListNode nowNode = null;
        ListNode nextNode = head;
        while (nextNode != null) {
            ListNode temp = nextNode.next;
            nextNode.next = nowNode;
            nowNode = nextNode;
            nextNode = temp;
        }
        return nowNode;
    }
}
