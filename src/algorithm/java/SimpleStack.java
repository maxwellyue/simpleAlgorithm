package algorithm.java;

import java.util.Arrays;
import java.util.Iterator;

/************************************************************************************
 * 功能描述：
 *
 * 栈的实现
 *
 * java.util.Stack有实现
 *
 * 主要是几个方法的练习
 *
 * pop()：出栈，即从栈顶取走一个元素
 * push()：入栈，即将一个元素压入栈中
 * peek()：查看栈顶元素
 *
 * 都是对栈顶元素的操作
 *
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2017年08月22日 --  下午7:19 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class SimpleStack<T> implements Iterable<T>{

    //栈的大小
    private int size;

    //内部数组，持有元素
    private Object[] array;//规则是：栈尾到栈顶的下标依次为0，1，2，3，...，size-1
    private final int DEFAULT_ARRAY_LENGTH = 16;

    public SimpleStack(int size){
        if(size < DEFAULT_ARRAY_LENGTH){
            size = DEFAULT_ARRAY_LENGTH;
        }
        array = new Object[size];
    }

    public SimpleStack(){
        array = new Object[DEFAULT_ARRAY_LENGTH];
    }


    /**
     * 取出栈顶元素
     * @return
     */
    public T pop(){
        if(isEmpty()){
            return null;
        }
        T element = (T)array[size - 1];
        array[size-1] = null;
        size--;
        return element;
    }

    /**
     * 元素入栈
     * @param data
     */
    public void push(T data){
        ensureCapacity();
        array[size++] = data;
    }

    /**
     * 查看栈顶元素
     * @return
     */
    public T peek(){
        if(isEmpty()){
            return null;
        }
        return (T)array[size-1];
    }

    private void ensureCapacity() {
        if(size == array.length){//如果已经装满了就扩容
            array = Arrays.copyOf(array, array.length << 2);
        }
    }

    private T get(int index){
        if(index > size -1 || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (T)array[index];
    }

    /**
     * 栈是否为空
     * @return
     */
    public boolean isEmpty(){return size == 0;}

    /**
     * 栈的大小
     * @return
     */
    public int size(){
        return size;
    }

    /**
     * 实现Iterable接口，支持迭代：从栈顶到栈尾的顺序
     * @return
     */
    @Override
    public Iterator<T> iterator() {

        return new Iterator<T>() {

            private int index = size - 1;

            @Override
            public boolean hasNext() {
                return index >= 0;
            }

            @Override
            public T next() {
                return (T)array[index --];
            }
        };
    }

}
