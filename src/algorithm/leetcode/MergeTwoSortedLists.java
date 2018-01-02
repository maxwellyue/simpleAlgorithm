package algorithm.leetcode;

/************************************************************************************
 * 功能描述：
 *
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 *
 * Example:
 *
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 *
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2017年12月29日 --  下午4:43 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class MergeTwoSortedLists {

    /**
     * 节点的定义
     */
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(0);

        ListNode node = head;

        while (l1 != null && l2 != null){
            if(l1.val >= l2.val){
                node.next = new ListNode(l2.val);
                l2 = l2.next;
            }else {
                node.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            node = node.next;
        }

        while (l1 != null){
            node.next = l1;
            node = node.next;
            l1 = l1.next;
        }

        while (l2 != null){
            node.next = l2;
            node = node.next;
            l1 = l1.next;
        }

        return head.next;
    }






}
