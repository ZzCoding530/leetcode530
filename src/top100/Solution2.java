package top100;

/**
 * @author: zhangchen
 * @date: 2021/2/21
 * @description: 两数相加
 */

public class Solution2 {

    /**
     * 头节点是最低位，依次升高， 头节点相加，然后有一个值存进位
     * <p>
     * !!!!!!注意一开始要新建两个节点，一个节点用来做指针，依次让每个位相加，一个节点用来留在开头，给函数返回!!!!!!
     *
     * @param l1 链表1
     * @param l2 链表2
     * @return 结果链表
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int overTen = 0;
        ListNode root = new ListNode();
        ListNode ans = root;
        while (l1 != null || l2 != null) {
            int value1 = l1 == null ? 0 : l1.val;
            int value2 = l2 == null ? 0 : l2.val;
            int sum = (value1 + value2 + overTen) % 10;
            overTen = (value1 + value2 + overTen) / 10;

            root.next = new ListNode(sum);
            root = root.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (overTen != 0) {
            root.next = new ListNode(overTen);

        }

        return ans.next;

    }
}
