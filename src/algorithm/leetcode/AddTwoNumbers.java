package algorithm.leetcode;

/************************************************************************************
 * 功能描述：
 *
 * 给定两个表示两个非负数字的链表。
 * 数字以相反的顺序存储，其节点包含单个数字。
 * 将这两个数字相加并将其作为一个链表返回。
 * 输入: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出: 7 -> 0 -> 8
 * 即 342 + 465 = 807
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2017年12月17日 --  下午12:01 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class AddTwoNumbers {


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode current1 = l1;
        ListNode current2 = l2;
        ListNode head  = new ListNode(0);
        ListNode node = head;
        int sum = 0;

        while (current1 != null || current2 != null){

            if(current1 != null){
                sum += current1.val;
                current1 = current1.next;
            }

            if(current2 != null){
                sum += current2.val;
                current2 = current2.next;
            }

            int value = sum % 10;
            sum = sum / 10;
            node.next = new ListNode(value);
            node = node.next;
        }

        if(sum > 0){
            //此时sum=1
            node.next = new ListNode(1);
        }

        return head.next;

    }


}
