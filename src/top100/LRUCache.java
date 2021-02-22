package top100;

import java.util.HashMap;

/**
 * @author: zhangchen
 * @date: 2021/2/22
 * @description: LRU 缓存机制
 */

public class LRUCache {


    /**
     * 使用Hashmap来存，而value存的是双向链表的节点，hashmap用来根据key快速定位，双向链表用来维持顺序
     */
    private int capacity;
    private HashMap<Integer, ListNode> hashmap;
    private ListNode head;
    private ListNode tail;

    /**
     * 需要用双向链表实现
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


    /**
     * LRU的构造函数，就是把hashMap，head和tail初始化一下，然后连在一起，
     * 中间的节点才是真正的储存在hashMap里的节点，head和tail只是为了好定位首尾节点
     *
     * @param capacity 最大容量，不可变的
     */
    public LRUCache(int capacity) {
        this.capacity = capacity;
        hashmap = new HashMap<>();
        head = new ListNode();
        tail = new ListNode();
        head.next = tail;
        tail.prev = head;
    }

    /**
     * 删除节点就是把节点架空
     *
     * @param node 被删除的节点
     */
    private void removeNode(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    /**
     * 添加节点到末尾
     *
     * @param node 新节点
     */
    private void addNodeToLast(ListNode node) {
        node.prev = tail.prev;
        node.prev.next = node;
        node.next = tail;
        tail.prev = node;
    }

    /**
     * 移动节点到末尾
     * 1  删除末尾节点
     * 2  添加新的到末尾
     *
     * @param node 节点
     */
    private void moveNodeToLast(ListNode node) {
        removeNode(node);
        addNodeToLast(node);
    }


    //================== 下面两个方法才是本文要实现的API  ======================================

    /**
     * 如果key不存在，返回-1
     * 如果key存在，取出来节点，然后把节点里的值返回出来，别忘了把最近操作过的节点放到最后
     *
     * @param key k
     * @return v
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
     * 节点存在，就把节点里的值改了，然后放到最后
     * 节点不存在，就新加一个到最后
     * 要是容量最大了，把最后的从hashmap里删了
     *
     * @param key   k
     * @param value v
     */
    public void put(int key, int value) {
        //key重复了的逻辑,记得及时return
        if (hashmap.containsKey(key)) {
            ListNode node = hashmap.get(key);
            node.val = value;
            moveNodeToLast(node);
            return;
        }
        //满了的逻辑，把排在最前面的删掉，那是最不常用的,要把那个节点从hashMap和链表里都删除
        if (hashmap.size() == capacity) {
            hashmap.remove(head.next.key);
            removeNode(head.next);
        }

        //这是key不存在且还有地方的逻辑
        ListNode node = new ListNode(key, value);
        hashmap.put(key, node);
        addNodeToLast(node);
    }


}
