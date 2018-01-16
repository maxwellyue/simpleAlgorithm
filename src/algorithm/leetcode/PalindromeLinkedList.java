package algorithm.leetcode;

/************************************************************************************
 * 功能描述：
 *
 * Given a singly linked list, determine if it is a palindrome.
 *
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2018年01月16日 --  下午4:25 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class PalindromeLinkedList {

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
     * 思路：
     *
     * 首先找到链表的中间节点（注意奇偶两种情况的区分）
     *
     * 将中间节点及之后的链表进行逆序
     *
     * 比较链表的前一部分和逆序后的后一部分
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        //找到中间的结点
        ListNode walker = head;
        ListNode runner = head;
        ListNode beforeMid = null;
        while (walker != null && runner != null && runner.next != null){
            beforeMid = walker;
            walker = walker.next;
            runner = runner.next.next;
        }

        //链表节点个数是否是奇数
        boolean odd = runner != null;
        if(odd){
            walker = walker.next;
        }
        beforeMid.next = null;

        //中间之后的逆序
        ListNode prev = null;
        ListNode next = null;
        ListNode cur = walker;
        while (cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        //逆序后的新的头结点
        walker = prev;


        //依次比较
        runner = head;
        while (walker != null){
            if(runner.val != walker.val){
                return false;
            }
            walker = walker.next;
            runner = runner.next;
        }

        return true;
    }


}
