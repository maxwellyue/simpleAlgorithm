package algorithm.leetcode;

/************************************************************************************
 * 功能描述：\
 *
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * You must do this in-place without altering the nodes' values.
 *
 * For example,
 * Given {1,2,3,4}, reorder it to {1,4,2,3}.
 *
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2018年01月09日 --  上午10:12 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class ReorderList {


    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 三步走：
     * ①将链表从中间分为两部分
     * ②将后半部分逆序
     * ③合并这两个链表
     *
     * @param head
     */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        //找到中间位置
        ListNode runner = head;
        ListNode walker = head;

        while (runner != null && runner.next != null && runner.next.next != null) {
            runner = runner.next.next;
            walker = walker.next;
        }

        //将后半部分逆序
        ListNode prevMiddle = walker;
        ListNode prev = null;
        ListNode cur = walker.next;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        prevMiddle.next = prev;

        //合并两个链表
        ListNode p1 = head;
        ListNode p2 = prevMiddle.next;
        while (p1 != prevMiddle) {
            prevMiddle.next = p2.next;
            p2.next = p1.next;
            p1.next = p2;
            p1 = p2.next;
            p2 = prevMiddle.next;
        }
    }
}
