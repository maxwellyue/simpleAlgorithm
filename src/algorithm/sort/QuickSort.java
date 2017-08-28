package algorithm.sort;

/************************************************************************************
 * 功能描述：
 *
 * 快速排序
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2017年08月25日 --  下午2:00 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class QuickSort {

    public static void sort(int[] arr) {
        if(arr == null || arr.length == 0)
            return ;
        quickSort(arr, 0, arr.length-1);
    }

    //分治+递归
    private static void quickSort(int[] arr, int left, int right) {
        if(left >= right)
            return ;
        int baseIndex = partition(arr, left, right);
        quickSort(arr, left, baseIndex-1);
        quickSort(arr, baseIndex+1, right);
    }

    //一次排序中完成的工作：从右边找出比基准数小的，从左边找到比基准数大的，交换
    //使用排序序列中最左边即第一个元素作为基准数
    private static int partition(int[] arr, int left, int right) {
        int base = arr[left];
        int baseIndex = left;
        //右指针从右边寻找比基准数小的数，左指针从左边寻找比基准数大的数，找到后，交换；下次循环的时候，从上次指针到达的位置开始；
        while(left < right) {//这里会直到left=right的时候停止
            //先从右边开始，找出右边比基准数小的
            while(left < right && arr[right] >= base)
                right --;
            //找到左边比基准数大的
            while(left < right && arr[left] <= base)
                left ++;
            swap(arr, left, right); //把大的交换到右边，把小的交换到左边。
        }

        //最后把baseIndex交换到中间，此时left所在位置以及小于left的元素一定是<=基准数的
        //所以将基准数与left位置的元素交换，然后返回本次排序中最终的基准数的位置。
        //下次排序的时，只要排这个基准数两边的即可。
        swap(arr, baseIndex, left);
        return left;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
