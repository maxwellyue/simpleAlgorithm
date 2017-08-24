package algorithm.array;

import org.junit.Test;

/************************************************************************************
 * 功能描述：
 *
 * 给定一个有序的数组，查找某个数是否在数组中，请编程实现。
 *
 * 程序的难点在于：边界值的取法。
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2017年08月24日 --  下午9:29 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class FindInArray {

    /**
     *
     * 数组array是否包含a
     *
     * 二分查找
     *
     * @param array 有序数组（从小到大的）
     * @param a
     * @return
     */
    public boolean contains(int[] array, int a){

        if(array == null || array.length == 0){
            return false;
        }

        int left = 0;
        int right = array.length -1;
        while(left <= right){
            int middle = left + ((right - left) >> 1);
            if(array[middle] == a){
                return true;
            }else if(array[middle] > a){
                right = middle - 1;//middle位置已经判断，所以右边界变为middle-1
            }else {
                left = middle + 1;//middle位置已经判断，所以左边界变为middle+1
            }
        }

        return false;
    }

    /**
     *
     * 数组array是否包含a
     *
     * 二分查找
     *
     * todo
     * 直接计算middle的位置：代码有误，
     *
     *
     * @param array 有序数组（从小到大的）
     * @param a
     * @return
     */
    public boolean contains2(int[] array, int a){

        if(array == null || array.length == 0){
            return false;
        }

        int middle = (array.length - 1) >> 2;//取小
        int i = 0;
        // TODO: 2017/8/24 以下代码有误
        while (i <= (array.length >>1)){
            i++;
            if(array[middle] == a){
                return true;
            }else if(array[middle] > a){
                middle = middle >> i;
            }else {
                middle = middle + (middle >> i);
            }
        }

        return false;
    }


    @Test
    public void test(){
        int[] array = {1,2,3,4,5,6,7,8};

        print(contains2(array, 1));
        print(contains2(array, 2));
        print(contains2(array, 3));
        print(contains2(array, 4));
        print(contains2(array, 5));
        print(contains2(array, 10));
        print(contains2(array, 11));


    }

    public void print(boolean b){
        System.out.println(b);
    }



}
