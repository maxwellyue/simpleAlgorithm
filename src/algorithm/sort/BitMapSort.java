package algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

/************************************************************************************
 * 功能描述：
 *
 * 利用BitMap实现排序
 *
 * 与高效boolean数组的实现类似，
 * 只是这里每个位表示的是待排序的元素的值
 * 而高效boolean数组里，每个位表示的是元素的位置index
 *
 * 而且，必须已知待排序的数的最大值，以便确定bit数组的大小，
 * 即要先将从0到这个最大值的中间的所有数用bit的位表示出来，
 * 然后再判断待排序的是哪些数（在哪个位置），包含的话该位就置为1，否则保持0
 *
 *
 *
 * 7,6,5,4,3,2,1,0（从低位到高位的顺序）
 *
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2017年08月28日 --  上午9:31 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class BitMapSort {

    /**
     *
     * 简单起见，假设数组中不包含重复的数，且全为正整数
     *
     * @param array 待排序的数组
     * @return 从小到大排序的数组
     */
    private int[] sort(int[] array){
        //判空
        if(array == null || array.length == 0){
            return array;
        }

        //找到最大元素，确定bytes数组大小
        int max = array[0];
        for(int i = 1; i < array.length; i++){
            if(array[i] > max){
                max = array[i];
            }
        }

        int length = (max >> 3) + 1;
        byte[] bytes = new byte[length];

        //判断元素
        for(int i = 0; i < array.length; i++){
            int a = array[i];
            int indexInBytes = a >> 3;//取值为0~length-1
            int mod = a &((1 << 3) -1);//取值为0~7（自右向左，即从低位到高位的，也可以从低位到高位）
            //将bytes数组中的indexInBytes位置的元素byte的第mod位置为1
            bytes[indexInBytes] = (byte) (bytes[indexInBytes] | (1 << mod));
        }

        //返回结果
        int k = 0;
        for(int i = 0; i < length; i++){
            for (int j = 0; j < 8; j++){
                //如果bytes数组中的i位置的byte的j位不为0，说明该位置表示的数存在于待排序数组array中
                if((bytes[i] & (1 << j)) != 0){
                    array[k] = (i << 3) + j;
                    k++;
                }
            }
        }

        return array;
    }

    @Test
    public void test(){
        int[] array = {1,5,3,7,2,4,8,13,456,34,19,36,69};
        System.out.println(Arrays.toString(sort(array)));
    }
}
