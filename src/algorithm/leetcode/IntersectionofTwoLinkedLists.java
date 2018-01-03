package algorithm.leetcode;

/************************************************************************************
 * 功能描述：
 *  Write a program to find the node at which the intersection of two singly linked lists begins.
 *
 *
 *  For example, the following two linked lists:
 *
 *  A:          a1 → a2
 *                      ↘
 *                      c1 → c2 → c3
 *                      ↗
 *  B:     b1 → b2 → b3
 *  begin to intersect at node c1.
 *
 *
 *  Notes:
 *
 *  If the two linked lists have no intersection at all, return null.
 *  The linked lists must retain their original structure after the function returns.
 *  You may assume there are no cycles anywhere in the entire linked structure.
 *  Your code should preferably run in O(n) time and use only O(1) memory.
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2018年01月03日 --  下午4:14 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class IntersectionofTwoLinkedLists {


    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     *
     * 思路：
     * 让两个链表从节点数相同的地方开始两两比较
     * 即注释中，从a1 == b2 开始
     * 那么需要将较长链表中多出来的结点去除（并不是改变结构地去除，只是不参与比较）
     *
     * 时间复杂度：假设两个链表长度为m, n，
     * O( m + n + n) = O(n)
     * 符合题目要求
     *
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //找出两个链表中长度较小的链表
        int lengthA = 0, lengthB = 0;

        ListNode nodeA = headA;
        ListNode nodeB = headB;

        while (nodeA != null) {
            nodeA = nodeA.next;
            lengthA++;
        }
        while (nodeB != null) {
            nodeB = nodeB.next;
            lengthB++;
        }
        //计算出两个链表的节点数的差距
        int distance = Math.abs(lengthB - lengthA);

        ListNode shortHead = lengthA >= lengthB ? headB : headA;
        ListNode longHead = lengthA >= lengthB ? headA : headB;
        while (longHead != null) {
            if(distance > 0){
                longHead = longHead.next;
                distance--;
            }else {
                if (longHead == shortHead) {
                    return longHead;
                } else {
                    longHead = longHead.next;
                    shortHead = shortHead.next;
                }
            }
        }

        return null;
    }


}
