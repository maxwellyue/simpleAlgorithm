package algorithm.sort;

import org.junit.Test;

/************************************************************************************
 * 功能描述：
 *
 * 希尔排序
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2017年06月14日 --  下午7:18 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class ShellSort {

    public static void shellSort(int[] array) {
        if (array == null || array.length == 0)
            return;

        int length = array.length;
        int gap = length;
        //最外层的循环是每次取不同步长时的循环，直到循环完最后一次：步长=1
        //循环体内实现的是根据步长进行分组，并对每组进行直接插入排序，最后组成新数组
        do {
            //计算本次循环时步长应该是多少
            gap = gap / 3 + 1;
            //对于每个序列中的元素，下标为k的元素的前一个和后一个元素的下标为k-gap,k+gap
            //步长为gap，则子序列个数为gap,每个子序列中的元素个数为：最少n/gap，最多为n/gap+1

            /*、
            *
            *
            * 下面的算法就是对每个分组分别就行简单插入排序
            *
            *
            *for(int i = 0; i < gap; i++){//对每个子序列进行简单插入排序
            *   for(int m = i + gap; m < length; m += gap){
            *        int target = array[m];
            *        int n = m;
            *        while(n > i && target < array[n-gap]){
            *            array[n] = array[n-gap];
            *            n -= gap;
            *        }
            *        array[n] = target;
            *    }
            *}
            *
            *
            *
            *
            */

            //这里的思路是将各个子序列的排序穿插进行
            for (int i = gap; i < length; i++) {
                int target = array[i];//待插入的数
                int j = i;//记录最终插入的位置，开始设为原位置
                while (j > i - gap && target < array[j - gap]) {//循环向左寻找插入位置，并将比target大的右移。
                    array[j] = array[j - gap];//左移，与简单插入排序不同的是，这里移动的距离是gap
                    j -= gap;
                }
                array[j] = target;//插入
            }
        }
        while (gap > 1);
    }


    /**
     * 维基上给出的算法
     *
     * @param arr
     */
    public static void shell_sort(int[] arr) {
        int gap = 1, i, j, len = arr.length;
        int temp;
        while (gap < len / 3)
            gap = gap * 3 + 1; // <O(n^(3/2)) by Knuth,1973>: 1, 4, 13, 40, 121, ...
        for (; gap > 0; gap /= 3)
            for (i = gap; i < len; i++) {
                temp = arr[i];
                for (j = i - gap; j >= 0 && arr[j] > temp; j -= gap)
                    arr[j + gap] = arr[j];
                arr[j + gap] = temp;
            }
    }


    @Test
    public void validate() {
        for (int i = 0; i < 1000; i++) {
            int[] array = Util.randomArray(1000, 0, 10000);
            shellSort(array);
            if (!Util.assertOrder(array)) {
                System.out.print("排序出现错误");
            }
        }
        System.out.print("排序没出现问题");
    }


}
