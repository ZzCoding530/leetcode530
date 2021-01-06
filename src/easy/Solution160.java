package easy;

/**
 * @author: zhangchen
 * @date: 2021/1/6
 * @description: 相交链表
 */

public class Solution160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //处理特殊情况
        if (headA == null || headB == null) {
            return null;
        }


        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            //pA到达末尾了没？到达了就放到ListNode B的头继续
            pA = pA == null ? headB : pA.next;
            //pB到达末尾了没？到达了就放到ListNode A的头继续
            pB = pB == null ? headA : pB.next;
        }

        //返回最后相遇的那个点
        return pA;
    }


}
