package com.maxwell.sort;

import org.junit.Test;

import java.util.Arrays;

/************************************************************************************
 * 功能描述：
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2017年06月14日 --  下午10:54 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class HeapSort {

    public static void heapSort(int[] array) {
        /*
         *  第一步：将数组堆化---建堆
         *
         *  从第一个非叶子节点开始即可。无需从最后一个叶子节点开始。
         *  叶子节点可以看作已符合堆要求的节点（只含有一个节点的大顶堆）
         *
         *  beginIndex = 第一个非叶子节点的位置。
         *  index大于beginIndex的都是叶子节点。
         *  一直循环到array[0]
         */
        int length = array.length;
        int beginIndex = (length - 2) >> 1;
        for (int i = beginIndex; i >= 0; i--) {
            maxHeapify(array, i, length - 1);
        }

        /*
         * 第二步：对堆化数据排序
         *
         * 当对初始数组进行建堆之后，
         * 此时，数组中最大元素是array[0]，最尾部节点就是当前数组的最后一个元素。
         * 交换这两个元素后，数组中最大元素已经排好成为数组的最后一个元素；
         * 然后，断开堆的最尾部节点（初始数组中的最大元素），
         * 这里的断开，在操作中的实现是：调整堆的时候，忽略该节点；
         *
         * 对剩下的元素重新建堆，此时仅仅需要调整堆顶节点即可，
         * 因为其他节点在建堆的时候都满足了堆的特性。
         *
         * 直至未排序的堆长度为 0。
         */
        for (int i = length - 1; i > 0; i--) {
            Util.swap(array, 0, i);
            //再次建堆：仅仅调整此时的堆顶节点即可
            maxHeapify(array, 0, i - 1);
        }
    }


    /**
     * 调整索引为i处的数据，使其符合堆的特性。
     * 调整思路为：
     * 先找到array[i]的两个子节点中的较大的节点，比较array[i]与子节点中的较大者，
     * 如果子节点中的较大者大于array[i]，则交换，否则结束；
     * 如果发生了交换（假设是左子节点array[left]与array[i]交换），
     * 则递归调整array[left]
     * 从堆的结构来看，这个递归过程是自上而下的调整过程
     *
     * @param i     需要堆化处理的数据的索引
     * @param array 未排序的堆（数组）的长度
     */
    private static void maxHeapify(int[] array, int i, int unHeaplength) {
        int left = (i << 1) + 1; // 左子节点位置
        int right = (i << 1) + 2;// 右子节点位置
        int maxChild = left; // array[i]的所有子节点中位置最大的，默认左子节点。

        if (left > unHeaplength) return;       // 左子节点索引超出计算范围，直接返回。
        if (right <= unHeaplength && array[right] > array[left]) // 先判断左右子节点，哪个较大。
            maxChild = right;
        if (array[maxChild] > array[i]) {
            Util.swap(array, maxChild, i);
            //如果节点交换，则要继续堆化该节点
            maxHeapify(array, maxChild, unHeaplength);
        }
    }


    @Test
    public void validate() {
        for (int i = 0; i < 10000; i++) {
            int[] array = Util.randomArray(10, 0, 10000);
            System.out.println("随机数组为：" + Arrays.toString(array));
            heapSort(array);
            if (!Util.assertOrder(array)) {
                System.out.print("排序出现错误");
            }
        }
        System.out.print("排序没出现问题");
    }
}
