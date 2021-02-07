package offer;

import java.util.Stack;

/**
 * @author: zhangchen
 * @date: 2021/2/7
 * @description: 从尾到头打印链表
 */

public class Solution06 {
    public int[] reversePrint(ListNode head) {

        if (head == null) {
            return new int[0];
        }


        Stack<Integer> stack = new Stack<>();
        while (head.next != null) {
            stack.push(head.val);
            head = head.next;
        }
        stack.push(head.val);

        int[] intArr = new int[stack.size()];
        int index = 0;
        while (!stack.isEmpty()) {
            intArr[index++] = stack.pop();
        }

        return intArr;


    }

    public static void main(String[] args) {
        ListNode headNode = new ListNode(1);
        headNode.next = new ListNode(3);
        headNode.next.next = new ListNode(2);
        int[] ints = new Solution06().reversePrint(headNode);
        for (int anInt : ints) {
            System.out.print(anInt + ",");
        }
    }
}
