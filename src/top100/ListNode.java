package top100;

/**
 * @author: zhangchen
 * @date: 2021/2/21
 * @description: 工具：链表的节点类
 */

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
