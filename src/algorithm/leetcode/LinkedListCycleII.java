package algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

/************************************************************************************
 * 功能描述：
 *
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 *
 * Note: Do not modify the linked list.
 *
 * Follow up:
 * Can you solve it without using extra space?
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2018年01月15日 --  下午4:22 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class LinkedListCycleII {

    /**
     * 节点定义
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     *
     * 思路：
     *
     * 首先判断有没有环，并得到相遇的结点
     * 相遇之后，
     * 让快指针从链表头部重新开始走，但速度降为每次一步
     * 满指针从相遇点继续按之前的每次一步的速度前进
     * 当两个指针再次相遇的时候，就是环开始的地方
     *
     * 时间复杂度O(n)
     * 空间复杂度O(1)
     *
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        //空链表或只有一个结点的链表返回null
        if(head == null || head.next == null){
            return null;
        }

        //设定快慢指针，直到相遇
        ListNode walker = head;
        ListNode runner = head;
        while (runner != null && runner.next != null && walker != null){
            runner = runner.next.next;
            walker = walker.next;
            if(walker == runner){
                break;
            }
        }

        //说明链表中没有环
        if(runner != walker){
            return null;
        }

        //调整快指针起点和速度，再次让快慢指针相遇
        runner = head;
        while (walker != runner){
            runner = runner.next;
            walker = walker.next;
        }

        return walker;
    }

    /**
     *
     * 借助Set的元素不可重复的属性
     *
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     *
     * 不符合题目要求：不使用额外空间
     * 但是简洁，容易写
     *
     * @param head
     * @return
     */
    public ListNode detectCycle2(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode node = head;
        while (node != null){
            if(set.contains(node)){
                return node;
            }else {
                set.add(node);
                node = node.next;
            }
        }
        return null;
    }

}
