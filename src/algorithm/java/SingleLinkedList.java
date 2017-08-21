package algorithm.java;

import java.util.Iterator;

/************************************************************************************
 * 功能描述：
 *
 * 单链表的Java实现：增删改查
 *
 * 单链表：
 * ①每个节点有一个指向后一个节点的指针（除头结点外）+ 自身储存的数据
 * ②
 *
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2017年08月21日 --  下午7:27 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class SingleLinkedList<T> implements Iterable<T> {

    private int size = 0;//链表大小

    private Node<T> head;//头节点

    private Node<T> tail;//尾节点

    public Node<T> getHead() {
        return head;
    }

    public Node<T> getTail() {
        return tail;
    }

    //内部类：节点
    public static class Node<T> {

        private T data;//存储的数据

        private Node next;//下一个节点

        //构造器
        public Node(T data) {
            this.data = data;
        }

        public T getValue() {
            return this.data;
        }

        public Node getNext() {
            return this.next;
        }
    }

    /**
     * 添加到链表的尾部
     *
     * @param data
     * @return
     */
    public void add(T data) {
        add(size, data);
    }

    /**
     * 添加到index位置
     *
     * @param index
     * @param data
     */
    public void add(int index, T data) {

        Node<T> node = new Node<>(data);

        if (isEmpty()) {//链表为空
            head = node;
            tail = node;
        } else {
            if (index > size - 1) {//index超出当前size范围，则添加到链尾
                Node<T> originTail = tail;
                tail = node;
                originTail.next = tail;
            } else {
                Node<T> prev = getNode(index - 1);
                node.next = getNode(index);
                prev.next = node;
            }
        }

        size++;
    }

    /**
     * 设置index位置的元素值
     *
     * @param index
     * @param data
     */
    public void set(int index, T data) {
        if (index > size - 1) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        } else {
            Node<T> current = getNode(index);
            current.data = data;
        }
    }


    public Node<T> getNode(int index) {
        if (isEmpty() && (index > size - 1)) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        Node<T> result = head;

        int n = 0;
        while (n < index) {
            result = result.next;
            n++;
        }
        return result;
    }


    /**
     * 删除index位置的元素
     *
     * @param index
     */
    public void delete(int index) {
        if (isEmpty() && (index > size - 1)) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        if (index == 0) {//删除头
            head = head.next;
        } else {
            Node<T> prev = getNode(index - 1);

            if (index >= size - 1) {//删除尾
                prev.next = null;
                tail = prev;
            } else {
                Node<T> next = prev.next.next;
                prev.next = next;
            }
        }

        size--;
    }

    /**
     * 获取index位置的元素值
     *
     * @param index
     * @return
     */
    public T getValue(int index) {
        return getNode(index).data;
    }


    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }


    /**
     * 支持迭代器进行遍历
     *
     * @return
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public T next() {
                return getValue(index++);
            }
        };
    }

        /*
        *
        * 直接利用自身的关系进行遍历更方便
        *
        *   Node<Integer> node = singleLinkedList.getHead();
        *   while (node != null){
        *       System.out.print(node.getValue() + "--");
        *       node = node.getNext();
        v   }
        *
        * */

}
