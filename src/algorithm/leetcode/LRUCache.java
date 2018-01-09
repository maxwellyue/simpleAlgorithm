package algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/************************************************************************************
 * 功能描述：
 *
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 *
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 *
 * Example:
 *
 *      LRUCache cache = new LRUCache( 2 );
 *      cache.put(1,1);
 *      cache.put(2,2);
 *      cache.get(1);       // returns 1
 *      cache.put(3,3);    // evicts key 2
 *      cache.get(2);       // returns -1 (not found)
 *      cache.put(4,4);    // evicts key 1
 *      cache.get(1);       // returns -1 (not found)
 *      cache.get(3);       // returns 3
 *      cache.get(4);       // returns 4
 *
 *创建人：岳增存 yuezc@seentao.com
 *创建时间： 2018年01月08日--下午7:57
 *其他说明：
 *修改时间：
 *修改人：
 *************************************************************************************/
public class LRUCache {

    /**
     * 双链表的头尾节点
     * <p>
     * 这两个节点并不是实际的数据，是为了便于操作而冗余的两个节点
     */
    private Node head;
    private Node tail;

    /**
     * 缓存的容量
     */
    private int capacity;

    /**
     * 存放缓存的map
     */
    private Map<Integer, Node> map;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    private void deleteNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToHead(Node node) {
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    /**
     * 如果存在该缓存，则将该节点先从双链表中删除，再将其添加到链表头部
     *
     * @param key
     * @return
     */
    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            int res = node.value;
            deleteNode(node);
            addToHead(node);
            return res;
        }
        return -1;
    }

    /**
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        if (map.containsKey(key)) {//如果已经存在，则更新节点的值，并将其移动到链表头部
            Node node = map.get(key);
            node.value = value;
            deleteNode(node);
            addToHead(node);
        } else {
            Node node = new Node(key, value);
            map.put(key, node);
            if (map.size() <= capacity) {//注意这里是<=，而不能是<：只有在超出之后才删除，等于容量的时候，不删除
                addToHead(node);
            } else {//大于容量，则还要将表尾元素删除
                map.remove(tail.prev.key);
                deleteNode(tail.prev);
                addToHead(node);
            }
        }
    }


    /**
     * 双向链表
     */
    class Node {

        Node prev;
        Node next;
        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }




    public static void main(String[] a) {


        LRUCache obj = new LRUCache(2);
        obj.put(1, 1);
        obj.put(2, 2);
        obj.get(1);
        obj.put(3, 3);


    }


}
