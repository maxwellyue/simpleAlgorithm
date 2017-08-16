package algorithm.sort;

import org.junit.Test;

/************************************************************************************
 * 文件功能描述：
 * 创建人：岳增存
 * 创建时间： 2017年06月13日 --  下午7:26 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        if(arr == null || arr.length == 0)
            return ;
        boolean flag = true;//flag表示是否发生数据交换
        for(int i=0; i<arr.length-1 && flag ; i++) {
            flag  = false;//每次排序时设置为false
            for(int j=arr.length-1; j>i; j--) {
                if(arr[j] < arr[j-1]) {
                    Util.swap(arr, j-1, j);
                    flag = true; //如果发生了数据交换，再设置为true
                }
            }
        }
    }



    @Test
    public void validate(){
        for(int i=0;i<1000;i++){
            int[] array = Util.randomArray(1000, 0, 10000);
            bubbleSort(array);
            if(!Util.assertOrder(array)){
                System.out.print("排序出现错误");
            }
        }
        System.out.print("排序没出现问题");
    }
}

