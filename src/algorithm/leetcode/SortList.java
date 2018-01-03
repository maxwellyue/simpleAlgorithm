package algorithm.leetcode;

/************************************************************************************
 * 功能描述：
 *
 * Sort a linked list in O(n log n) time using constant space complexity.
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2018年01月03日 --  上午9:37 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class SortList {

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
     * 归并排序的递归写法
     *
     * 但并不满足使用常量空间的要求，因为是递归压栈，占用空间是O（n）
     *
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        //递归出口：head.next = null
        if(head == null || head.next == null){
            return head;
        }

        //找到链表中间节点
        ListNode fast = head;
        ListNode slow = head;
        ListNode showPrevious = null;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            showPrevious = slow;
        }

        //分割成两段
        showPrevious.next = null;
        ListNode head1 = head;
        ListNode head2 = slow;

        //分别排序
        head1 = sortList(head1);
        head2 = sortList(head2);

        //合并
        return merge(head1, head2);
    }


    /**
     * 归并算法的非递归实现
     *
     * @param head
     * @return
     */
    public ListNode sortList2(ListNode head) {
        //TODO


        return null;
    }






    /**
     *
     * 合并两个有序链表
     *
     * @param head1
     * @param head2
     * @return 新链表的头结点
     */
    public ListNode merge(ListNode head1, ListNode head2){

        ListNode head = new ListNode(0);

        ListNode node = head;

        while (head1 != null && head2 != null){
            if(head1.val < head2.val){
                node.next = head1;
                head1 = head1.next;
            }else {
                node.next = head2;
                head2 = head2.next;
            }
            node = node.next;
        }

        while (head1 != null){
            node.next = head1;
            head1 = head1.next;
            node = node.next;
        }

        while (head2 != null){
            node.next = head2;
            head2 = head2.next;
            node = node.next;
        }

        return head.next;
    }
}
