package algorithm.other;

import org.junit.Test;

/************************************************************************************
 * 功能描述：
 *
 * 单链表逆序：改变原链表
 * 即如果链表原来为1->2->3->4->5->null，逆序后为5->4->3->2->1->null.
 *
 *
 * 要求空间复杂度O（1）
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2017年12月17日 --  上午10:31 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class SingleListReverse {

    class Node {

        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    /**
     * 对单链表进行逆序（原链表的结构发生变化）
     *
     *
     * @param head 单链表的头结点
     */
    public Node reverse(Node head) {

        //上次已经循环的结点
        Node prev = null;
        //本次要循环的结点
        Node current = head;
        //下次将循环的结点
        Node next = null;
        while (current != null) {
            next = current.next;//为下次循环做准备：记录下次循环的结点
            current.next = prev;//改变当前循环的结点的next指向
            prev = current;//为下次循环做准备：将prev修改为本次循环的结点
            current = next;//为下次循环做准备：将current修改为本次循环的结点的下一个节点
        }

        return prev;
    }

    @Test
    public void testReverse() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        Node current = node1;
        while(current != null){
            System.out.println(current.data);
            current = current.next;
        }

        Node reverse = reverse(node1);
        while(reverse != null){
            System.out.println(reverse.data);
            reverse = reverse.next;
        }

    }


}
