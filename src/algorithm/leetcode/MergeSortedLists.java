package algorithm.leetcode;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/************************************************************************************
 * 功能描述：
 *
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 *
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2018年01月12日 --  上午11:18 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class MergeSortedLists {

    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 借助优先队列，实现排序功能
     * <p>
     * 来自：https://leetcode.com/problems/merge-k-sorted-lists/discuss/10528
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val > o2.val) {
                    return 1;
                } else if (o1.val < o2.val) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        ListNode dummy = new ListNode(0);
        ListNode head = dummy;

        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }
        while (!queue.isEmpty()) {
            head.next = queue.poll();
            head = head.next;

            if (head.next != null) {
                queue.add(head.next);
            }
        }
        return dummy.next;
    }

    /**
     *
     * 两两合并，一直到合并为只有一个链表
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        Queue<ListNode> queue = new LinkedList<>();
        for (ListNode node : lists) {
            if (node != null) {
                queue.offer(node);
            }
        }

        while (queue.size() > 1) {
            queue.offer(merge(queue.poll(), queue.poll()));
        }

        return queue.isEmpty() ? null : queue.poll();
    }

    /**
     * 合并两个有序链表
     *
     * @param head1
     * @param head2
     * @return
     */
    private ListNode merge(ListNode head1, ListNode head2) {

        if (head1 == null || head2 == null) {
            return head1 == null ? head2 : head1;
        }

        ListNode head = new ListNode(0);
        ListNode node = head;
        ListNode node1 = head1;
        ListNode node2 = head2;
        while (node1 != null || node2 != null) {
            if (node1 != null && node2 != null) {
                if (node1.val > node2.val) {
                    node.next = new ListNode(node2.val);
                    node2 = node2.next;
                } else {
                    node.next = new ListNode(node1.val);
                    node1 = node1.next;
                }
            } else if (node1 == null) {
                node.next = new ListNode(node2.val);
                node2 = node2.next;
            } else {
                node.next = new ListNode(node1.val);
                node1 = node1.next;
            }
            node = node.next;
        }

        return head.next;
    }

}
