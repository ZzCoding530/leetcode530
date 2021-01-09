package medium;

/**
 * @author: zhangchen
 * @date: 2021/1/9
 * @description: 这道题我们需要一个头节点，用来做返回的答案，一个节点用来做指针
 */


public class Solution2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //这个节点是用来做返回值的头节点的，准确的说是他的下一个节点开始，是答案
        ListNode head = new ListNode(-1);
        //这个节点是指针
        ListNode h = head;

        //这是每一位的和以及需不需要进位
        int sum;
        boolean carry = false;


        //俩链表有一个不为null就行
        while (l1 != null || l2 != null) {

            sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            if (carry) {
                sum++;
            }


            //把计算的结果存到一个新建的，然后指针往后走
            h.next = new ListNode(sum % 10);
            h = h.next;
            carry = sum >= 10;

        }

        //计算一下到最后是否需要进位，需要就补个1
        if (carry) {
            h.next = new ListNode(1);
        }

        return head.next;
    }
}
