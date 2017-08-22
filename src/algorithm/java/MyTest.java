package algorithm.java;

import org.junit.Test;

import java.util.Iterator;

/************************************************************************************
 * 功能描述：
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2017年08月18日 --  下午9:22 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class MyTest {

    @org.junit.Test
    public void booleanArrayTest() {
        BooleanArray array = new BooleanArray(10);
        array.set(0, false);
        array.set(2, true);
        array.set(9, false);
        array.set(3, true);


        System.out.println(array.get(0));
        System.out.println(array.get(2));
        System.out.println(array.get(3));

        array.set(3, false);
        System.out.println(array.get(3));
    }

    @Test
    public void singleLinkedListTest(){
        //测试：添加
        SingleLinkedList<Integer> singleLinkedList = new SingleLinkedList<>();
        singleLinkedList.add(1);
        singleLinkedList.add(2);
        singleLinkedList.add(3);
        singleLinkedList.add(4);
        /*Iterator iterator = singleLinkedList.iterator();
        while (iterator.hasNext()){
            System.out.print((Integer)iterator.next() + "--");
        }

        singleLinkedList.set(0, 10);
        singleLinkedList.set(1,9);*/

       /* System.out.println();
        System.out.println(singleLinkedList.getValue(0));
        System.out.println(singleLinkedList.getValue(1));

        singleLinkedList.delete(0);
        Iterator iterator1 = singleLinkedList.iterator();
        while (iterator1.hasNext()){
            System.out.print((Integer)iterator1.next() + "--");
        }*/

        SingleLinkedList.Node<Integer> node = singleLinkedList.getHead();
        while (node != null){
            System.out.print(node.getValue() + "--");
            node = node.getNext();
        }

    }

    @Test
    public void doubleLinkedListTest(){
        DoubleLinkedList<String> doubleLinkedList = new DoubleLinkedList<>();
        doubleLinkedList.add("1");
        doubleLinkedList.add(1, "2");
        doubleLinkedList.add("3");
        doubleLinkedList.add(3, "4");
        /*print(doubleLinkedList.getValue(0));
        print(doubleLinkedList.getValue(1));
        print(doubleLinkedList.getValue(2));
        print(doubleLinkedList.getValue(3));

        doubleLinkedList.set(2, "22");
        doubleLinkedList.set(1, "11");
        print(doubleLinkedList.getValue(1));
        print(doubleLinkedList.getValue(2));*/

        doubleLinkedList.delete(0);
        doubleLinkedList.delete(1);
        DoubleLinkedList.Node<String> node = doubleLinkedList.getHeadNode();
        while (node != null){
            print(doubleLinkedList.getValue(node));
            node = doubleLinkedList.getNextNode(node);
        }

    }

    @Test
    public void stackTest(){
        SimpleStack<String> stack = new SimpleStack<>();

        for(int i = 0; i < 100; i++){
            stack.push(i + "");
        }


        Iterator<String> iterator = stack.iterator();
        while (iterator.hasNext()){
            print(iterator.next());
        }

        /*print(stack.peek()+ " :::: 33");
        print(stack.peek()+ " :::: 33");
        print(stack.pop()+ " :::: 33");
        print(stack.pop()+ " :::: 22");
        print(stack.peek()+ " :::: 11");
        print(stack.size() + " :::: 1");
*/
    }

    private void print(String s){
        System.out.println(s);
    }

}
