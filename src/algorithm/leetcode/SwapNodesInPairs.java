package algorithm.leetcode;

/************************************************************************************
 * 功能描述：
 *
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 *
 * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 *
 *
 *
 * 创建人：岳增存  yueyuemax@gmail.com
 * 创建时间： 2018年02月24日 --  上午9:08 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class SwapNodesInPairs {

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
     * 递归实现
     *
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode first = head;
        ListNode second = head.next;
        ListNode next = second.next;

        second.next = first;
        first.next = swapPairs(next);

        return second;
    }


    /**
     *
     * 非递归实现
     *
     * 原始写法：顺着思路写，但是最终代码形式看着不够简洁
     *
     *
     * @param head
     * @return
     */
    public ListNode swapPairs2(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode first = head;
        ListNode second = head.next;
        ListNode next = second.next;
        second.next = first;
        first.next = next;

        ListNode res = second;
        ListNode lastTail = first;

        while (next != null){
            first = next;
            second = next.next;
            if(second == null){
                break;
            }else {
                next = second.next;
                second.next = first;
                first.next = next;
                lastTail.next = second;
                lastTail = first;
            }
        }

        return res;
    }

    /**
     *
     * 非递归实现
     *
     * 原始写法的改进
     *
     * todo 对代码进行简洁处理
     *
     *
     * @param head
     * @return
     */
    public ListNode swapPairs3(ListNode head) {

        return null;
    }


}
