package algorithm.leetcode;

/************************************************************************************
 * 功能描述：
 *
 * Reverse a singly linked list.
 *
 *
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2018年01月03日 --  上午9:07 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class ReverseLinkedList {

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

    public ListNode reverseList(ListNode head) {

        ListNode cur = head;
        ListNode previous = null;
        ListNode next = null;

        while (cur != null){
            next = cur.next;
            cur.next = previous;
            previous = cur;
            cur = next;
        }

        return previous;
    }


}
