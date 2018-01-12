package algorithm.leetcode;

/************************************************************************************
 * 功能描述：
 *
 * Given a linked list, remove the nth node from the end of list and return its head.
 *
 * For example,
 *
 * Given linked list: 1->2->3->4->5, and n = 2.
 *
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 *
 *
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2018年01月12日 --  上午9:23 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class RemoveNthNodeFromEndofList {


    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     *
     * two pass
     *
     * 不满足题目要求 Try to do this in one pass.
     *
     * 但可以通过LeetCode
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode node = head;
        while (node != null){
            node = node.next;
            length++;
        }

        int remove = length - n;
        int i = 0;
        ListNode removeNode = head;
        ListNode prev = null;
        while (i < remove){
            prev = removeNode;
            removeNode = removeNode.next;
            i++;
        }

        if(removeNode != null){
            if(prev == null || removeNode == head){
                return removeNode.next;
            }else {
                prev.next = removeNode.next;
            }
        }

        return head;
    }

    /**
     *
     *
     * 来自：http://bangbingsyb.blogspot.jp/2014/11/leetcode-remove-nth-node-from-end-of.html
     *
     * 这是一道简单题，两个关键点：
     * 1. 找到倒数第n+1个节点。
     * 2. 通过找到的节点来删除倒数第i个节点。
     *
     * 如何找到倒数第k个节点?
     * 双指针before, after。
     * 让before先从head开始走k步，然后双指针同时走，当before为NULL时，after所指的就是倒数第k个节点。
     *
     *
     * @return
     */
    public ListNode removeNthFromEnd2(ListNode head, int n){

        ListNode start = new ListNode(0);
        ListNode slow = start, fast = start;
        slow.next = head;

        //Move fast in front so that the gap between slow and fast becomes n
        for(int i=1; i<=n+1; i++)   {
            fast = fast.next;
        }
        //Move fast to the end, maintaining the gap
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        //Skip the desired node
        slow.next = slow.next.next;
        return start.next;
    }





}
