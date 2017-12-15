package algorithm.array;

import java.util.HashMap;
import java.util.Map;

/************************************************************************************
 * 功能描述：输入一个数组和一个数，在数组中查找两个数，使这两个数的和等于输入的那个数。
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2017年08月15日 --  下午7:30 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class ConstantSumTwo {

    /**
     * 暴力循环：枚举所有的情况（无论有序、无序都可以）
     *
     * @param array
     * @param a
     */
    public void constantSum1(int[] array, int a) {
        //判空代码...
        //核心代码
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                if (array[i] + array[j] == a) {
                    System.out.println(array[i] + "  and  " + array[j]);
                }
            }
        }
    }


    /**
     * 指针两端扫描
     *
     * @param array
     * @param a
     */
    public void constantSum2(int[] array, int a) {
        //判空代码...

        //如果数组无序，需要先进行排序

        //核心代码
        int head = 0;
        int hail = array.length - 1;

        while(head < hail){
            int currentSum = array[head] + array[hail];
            if(currentSum == a){
                System.out.println(array[head] + "  and  " + array[hail]);
                break;
            }else if(currentSum > a){
                hail--;
            }else{
                head++;
            }
        }
    }

    /**
     * 借助哈希表实现
     *
     * @param array
     * @param a
     */
    public void constantSum3(int[] array, int a){
        //判空代码
        //......

        //以数组的值为map的key，以数组的下标为map的value
        //每次放入的时候，判断map是否含有（a-当前数组某值）这个key
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < array.length; i++){
            if(map.containsKey(a- array[i])){
                System.out.println(array[i] + "  and  " + (a- array[i]));
                break;//找到一个符合要求的就停止
            }else {
                map.put(array[i], i);
            }
        }
    }


}
