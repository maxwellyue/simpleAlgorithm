package algorithm.java;

/************************************************************************************
 * 功能描述：
 *
 * 双向链表的Java实现
 *
 * 特点：
 * 双向链表也叫双链表，是链表的一种，它的每个数据结点中都有两个指针，分别指向直接后继和直接前驱。
 * 所以，从双向链表中的任意一个结点开始，都可以很方便地访问它的前驱结点和后继结点。
 *
 * 双链表的重要性质就是可以根据任意节点快速获取其前后节点，
 * 所以提供了getPrevNode()和getNextNode()方法；
 *
 * 还有就是，双链表遍历节点时，无需实现任何接口，直接利用节点间的关系即可完成遍历。
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2017年08月22日 --  下午3:39 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class DoubleLinkedList<T> {

    private int size;//链表大小
    //由于是双向，头尾任意选择一端即可
    private Node<T> head;//链表的头节点
    private Node<T> tail;//链表的尾节点

    /**
     * 内部类：节点
     * @param <T>
     */
    public static class Node<T>{
        private Node prev;
        private Node next;
        private T data;

        public Node(T data){
            this.data = data;
        }

        private Node(){}
    }

    /**
     * 添加到链尾
     * @param data
     */
    public void add(T data){
        add(size, data);
    }

    /**
     * 添加到任意index处
     * @param index
     * @param data
     */
    public void add(int index, T data){
        Node<T> node = new Node<>(data);
        if(isEmpty()){//链表为空
            head = node;
            tail = node;
        }else {
            if(index > size - 1){//索引超出当前链表大小，则添加到链尾
                Node<T> temp = tail;
                tail = node;
                temp.next = tail;
                tail.prev = temp;
            }else {//原index位置处有值，索引位置大于index的元素向链尾移动(实际并不是移动，只是看上去)
                Node<T> origin = getNode(index);
                Node<T> prev = origin.prev;
                prev.next = node;
                node.prev = prev;
                node.next = origin;
                origin.prev = node;
            }
        }

        size++;
    }

    /**
     * 更新index位置处元素的值
     * @param index
     * @param data
     */
    public void set(int index, T data){
        if(index > size - 1 || index < 0){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        getNode(index).data = data;
    }

    /**
     * 删除index位置处的元素
     * @param index
     */
    public void delete(int index){
        if(index > size - 1 || index < 0){
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if(index == 0){//删除链头
            head = head.next;
            head.prev = null;
        }else if(index == size -1){//删除链尾
            tail = tail.prev;
            tail.next = null;
        }else {//普通节点
            Node<T> node = getNode(index);
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;
            node.prev = null;
            node.next = null;
        }
        size--;
    }

    /**
     * 获取index位置处的元素的值
     * @param index
     * @return
     */
    public T getValue(int index){
        return getNode(index) == null ? null : getNode(index).data;
    }

    public T getValue(Node<T> node){
        return node == null ? null : node.data;
    }

    /**
     * 获取节点node的上一个节点
     * @param node
     * @return
     */
    public Node<T> getPrevNode(Node<T> node){
        return node == null ? null : node.prev;
    }

    /**
     * 获取节点node的下一个节点
     * @param node
     * @return
     */
    public Node<T> getNextNode(Node<T> node){
        return node == null ? null : node.next;
    }

    public Node<T> getHeadNode(){
        return head;
    }

    public Node<T> getTailNode(){
        return tail;
    }

    /**
     * 获取index位置处的元素
     * @param index
     * @return
     */
    public Node<T> getNode(int index){

        if (isEmpty() && (index > size - 1)) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<T> result = head;
        int n = 0;
        while (n < index) {//注意这里是 n < index， 而不是n <= index
            result = result.next;
            n++;
        }
        return result;
    }

    /**
     * 获取值为data的元素在链表中的位置（第一次出现的位置，可能含有多个）
     * @param data
     * @return
     */
    public int indexOf(T data){
        if(isEmpty() || data == null){
            return -1;
        }

        int n = 0;
        Node<T> node = head;
        while (n < size){
            if(data.equals(node.data)){
                return n;
            }
            n++;
        }

        return -1;
    }

    /**
     * 判断是否有值为data的元素
     * @param data
     * @return
     */
    public boolean containValue(T data){
        return indexOf(data) != -1;
    }

    /**
     * 获取链表的大小
     * @return
     */
    public int size(){
        return size;
    }

    /**
     * 判断链表是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }


}
