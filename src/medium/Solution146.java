package medium;

import java.util.HashMap;

/**
 * @author: zhangchen
 * @date: 2021/1/15
 * @description: LRU
 */

public class Solution146 {


    private int capacity;
    private HashMap<Integer, ListNode> hashmap;
    private ListNode head;
    private ListNode tail;

    /**
     * 内建节点类，双向链表节点
     */
    private class ListNode {
        int key;
        int val;
        ListNode prev;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public Solution146(int capacity) {
        this.capacity = capacity;
        hashmap = new HashMap<>();
        head = new ListNode();
        tail = new ListNode();
        head.next = tail;
        tail.prev = head;
    }

    /**
     * 删除某节点    把节点自身架空
     *
     * @param node 需要被删除的节点
     */
    private void removeNode(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    /**
     * 在最后添加节点
     *
     * @param node 要添加的节点
     */
    private void addNodeToLast(ListNode node) {
        node.prev = tail.prev;
        node.prev.next = node;
        node.next = tail;
        tail.prev = node;
    }

    /**
     * 移动节点到末尾  1.删除节点  2.节点添加到末尾
     *
     * @param node
     */
    private void moveNodeToLast(ListNode node) {
        removeNode(node);
        addNodeToLast(node);
    }

    /**
     * 通过key取得节点，最新用的放到末尾
     *
     * @param key index
     * @return 节点的值
     */
    public int get(int key) {
        if (hashmap.containsKey(key)) {
            ListNode node = hashmap.get(key);
            moveNodeToLast(node);
            return node.val;
        } else {
            return -1;
        }
    }

    /**
     * 要把操作过的节点都放在末尾
     * 容量满了要删除最没被用过的 放在首位的
     *
     * @param key   key
     * @param value value
     */
    public void put(int key, int value) {
        if (hashmap.containsKey(key)) {
            ListNode node = hashmap.get(key);
            node.val = value;
            moveNodeToLast(node);
            return;
        }
        if (hashmap.size() == capacity) {
            hashmap.remove(head.next.key);
            removeNode(head.next);
        }

        ListNode node = new ListNode(key, value);
        hashmap.put(key, node);
        addNodeToLast(node);
    }


}
