package algorithm.leetcode;

/************************************************************************************
 * 功能描述：
 *
 * Given a linked list, determine if it has a cycle in it.
 *
 * Follow up:
 * Can you solve it without using extra space?
 *
 * 判断链表是否存在环
 * 有三种情况：
 *
 * ① node →  node →  node →  node → null
 *
 * ②  node →  node →  node
 *      ↑              ↓
 *     node           node
 *      ↑              ↓
 *     node ←  node ← node
 *
 * ③ node →  node →  node →  node
 *               ↑              ↓
 *              node           node
 *               ↑              ↓
 *              node ←  node ← node
 *
 * ①没有环，②、③有环
 *
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2018年01月03日 --  下午12:48 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class LinkedListCycle {

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
     * 设置两个指针，一个快，一个慢，向前走
     * 假如有环，则这两个指针一定会相遇
     * 假如没有环，则向前走的时候发现next为null
     *
     * 时间复杂度分析：
     *
     * 假如链表长度为n，环节点个数为m( 0=< m <= n)，
     * 则循环 t=n-m 次时，walker 进入环中，
     * 此时，假设runner与walker相距 x 个节点( 0 < x < m)，
     * 那么，经过t'次循环，二者相遇时，有：
     * 2t' = t'+（m-x） ->   t'=m-x    ->   t'<=m.
     * 总循环次数：t+t' = n-m + m-x = n-x
     * 所以，时间复杂度为O(n)
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        ListNode runner = head;
        ListNode walker = head;

        //如果没有环，则到链表最后节点后，会结束循环
        //如果有环，会一直进行，直到runner和walker相遇
        while (runner != null && runner.next != null) {
            runner = runner.next.next;
            walker = walker.next;

            if (runner == walker) {
                return true;
            }
        }

        return false;
    }






}
