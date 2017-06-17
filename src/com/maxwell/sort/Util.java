package com.maxwell.sort;

import java.util.Arrays;
import java.util.Random;

/************************************************************************************
 * 功能描述：
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2017年06月14日 --  下午10:08 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class Util {

    /**
     * 交换数组中两个元素的位置
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 生成随机数组
     * @param length
     * @param min
     * @param max
     * @return
     */
    public static int[] randomArray(int length, int min, int max){
        if(length <= 0)
            length = 100;
        int[] array = new int[length];
        Random random = new Random();
        for(int i = 0; i < length-1; i++){
            array[i] = random.nextInt(max)+ min;
        }
        return array;
    }

    /**
     * 生成排序的数组
     * @param length
     * @param min
     * @param max
     * @return
     */
    public static int[] sortedArray(int length, int min, int max){
        int[] array = randomArray(length, min, max);
        Arrays.sort(array);
        return array;
    }


    /**
     * 判读数组是否从小到大排序
     * @param array
     * @return
     */
    public static boolean assertOrder(int[] array){
        if(array == null || array.length ==0)
            return false;
        for(int i=0; i < array.length -1;i++){
            if(array[i+1]<array[i]){
                return false;
            }
        }
        return true;
    }

    public static void print(int[] array){
        System.out.println(Arrays.toString(array));
    }

}
