package com.maxwell.sort;

import org.junit.Test;

/************************************************************************************
 * 功能描述：归并排序
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2017年06月17日 --  下午2:47 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class MergeSort {

    static void mergeSortRecursive(int[] array, int[] result, int start, int end) {
        if (start >= end)
            return;
        int len = end - start, mid = (len >> 1) + start;
        int start1 = start, end1 = mid;
        int start2 = mid + 1, end2 = end;

        mergeSortRecursive(array, result, start1, end1);
        mergeSortRecursive(array, result, start2, end2);

        int k = start;
        while (start1 <= end1 && start2 <= end2)
            result[k++] = array[start1] < array[start2] ? array[start1++] : array[start2++];
        while (start1 <= end1)
            result[k++] = array[start1++];
        while (start2 <= end2)
            result[k++] = array[start2++];
        for (k = start; k <= end; k++)
            array[k] = result[k];
    }

    //归并排序的递归法实现
    public static void mergeSort(int[] array) {
        int length = array.length;
        int[] result = new int[length];//申请空间，保存结果
        mergeSortRecursive(array, result, 0, length - 1);
    }

    /**
     * 有助于理解的一个小算法：
     * 合并两个有序序列：假设均为从小到大的顺序
     *
     * @param a
     * @param b
     * @return
     */
    public static int[] mergeArrays(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int m = 0, n = 0, i = 0;

        while (m < a.length && n < b.length) {
            result[i++] = a[m] <= b[n] ? a[m++] : b[n++];
        }

        while (m < a.length) {
            result[i++] = a[m++];
        }

        while (n < b.length) {
            result[i++] = b[n++];
        }

        return result;
    }


    @Test
    public void validate() {
        for (int i = 0; i < 10000; i++) {
            int[] array = Util.randomArray(10, 0, 10000);
            mergeSort(array);
            if (!Util.assertOrder(array)) {
                System.out.print("排序出现错误");
            }
        }
        System.out.print("排序没出现问题");
    }




    //归并排序的迭代法实现
    public static void merge_sort(int[] arr) {
        int len = arr.length;
        int[] result = new int[len];
        int block, start;

        // 原版代码的迭代次数少了一次，没有考虑到奇数列数组的情况
        for(block = 1; block < len*2; block *= 2) {
            for(start = 0; start <len; start += 2 * block) {
                int low = start;
                int mid = (start + block) < len ? (start + block) : len;
                int high = (start + 2 * block) < len ? (start + 2 * block) : len;
                //两个块的起始下标及结束下标
                int start1 = low, end1 = mid;
                int start2 = mid, end2 = high;
                //开始对两个block进行归并排序
                while (start1 < end1 && start2 < end2) {
                    result[low++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
                }
                while(start1 < end1) {
                    result[low++] = arr[start1++];
                }
                while(start2 < end2) {
                    result[low++] = arr[start2++];
                }
            }
            int[] temp = arr;
            arr = result;
            result = temp;
        }
        result = arr;
    }




}
