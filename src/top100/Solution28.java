package top100;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author: zhangchen
 * @date: 2021/4/8
 * @description: 23合并K个升序链表
 */

public class Solution28 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        //把所有的链表放进小根堆
        for (ListNode list : lists) {
            if (list == null) {
                continue;
            }
            queue.add(list);
        }

        //从小根堆顶部取出一个连接到新建的结果链表后面，如果这条链表后面还有东西那就放回小根堆
        while (!queue.isEmpty()) {
            ListNode nextNode = queue.poll();
            curr.next = nextNode;
            curr = curr.next;
            if (nextNode.next != null) {
                queue.add(nextNode.next);
            }
        }

        return dummyHead.next;
    }

}
