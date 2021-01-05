package easy;

/**
 * @author: zhangchen
 * @date: 2021/1/5
 * @description: 给定一个链表，判断链表中是否有环。
 * <p>
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * <p>
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 * <p>
 * <p>
 * 自己写的居然错了 我吐了 这题直接记住就行了
 */

public class Solution141 {
    //    public boolean hasCycle(ListNode head) {
//
//        ListNode fast = head;
//        ListNode slow = head;
//        int count = 0;
//        int maxTimes = 10000;
//        while (count<maxTimes&&fast.next.next!=null){
//            fast = fast.next.next;
//            slow = slow.next;
//            count++;
//            if (slow==fast){
//                return true;
//            }
//
//        }
//
//        return false;
//
//
//    }
    public class Solution {
        public boolean hasCycle(ListNode head) {
            if (head == null || head.next == null) {
                return false;
            }
            ListNode slow = head;
            ListNode fast = head.next;
            while (slow != fast) {
                if (fast == null || fast.next == null) {
                    return false;
                }
                slow = slow.next;
                fast = fast.next.next;
            }
            return true;
        }
    }
}
