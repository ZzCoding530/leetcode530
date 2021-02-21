package top100;

/**
 * @author: zhangchen
 * @date: 2021/2/21
 * @description: 反转链表
 */

public class Solution4 {

    /**
     * null --》 1   --》   2   --》   3   --》   4   --》    5  --》 null
     * pre      cur        nxt
     * <p>
     * 比如有链表12345，
     * 1）先新建一个null节点放在最前面，作为反转后的最后一个，
     * 2）然后取出当前节点cur，让cur的next指针指向他前面的null，这样第一个节点反转完毕
     * 3）cur往后走，怎么往后走啊next都变了，所以在之前我们需要用一个临时节点nxt把cur原来的后一个节点保存起来，
     * 改完next指针以后直接赋值即可，记得把cur的相对前一个指针pre也往后走
     * 4）什么时候结束呢？我们把所有节点反转完毕，我们从哪看反转到结尾了呢？我们本来的链表最尾部其实是5后面的null
     * 所以当cur走到null时候我们结束
     * 5）那返回的链表从哪开始？ cur走到null了，我们没处理null，于是我们返回cur前面的pre
     *
     * @param head 头节点
     * @return 反转后的链表
     */
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;

        }

        return pre;

    }
}
