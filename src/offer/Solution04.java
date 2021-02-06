package offer;

import java.util.ArrayList;

/**
 * @author: zhangchen
 * @date: 2021/1/27
 * @description: 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 */

public class Solution04 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        //反转链表
        ListNode pre = null;
        ListNode cur = listNode;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        while (pre != null && pre.next != null) {
            arrayList.add(listNode.val);
        }

        return arrayList;

    }
}



