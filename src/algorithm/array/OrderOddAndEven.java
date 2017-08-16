package algorithm.array;

import org.junit.Test;

import java.util.Arrays;

/************************************************************************************
 * 功能描述：
 *
 * 输入一个整数数组，调整数组中数字的顺序，
 * 使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * 要求时间复杂度为O(n)。
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2017年08月16日 --  下午8:13 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class OrderOddAndEven {

    /**
     * 直接复制到另外一个新数组
     * @param array
     * @return
     */
    public int[] orderOddAndEven1(int[] array){

        int[] result = new int[array.length];
        int head = 0;
        int hail = array.length -1;
        for (int i = 0; i < array.length; i++){
            if(array[i] % 2 == 0){
                result[hail] = array[i];
                hail--;
            }else {
                result[head] = array[i];
                head++;
            }
        }

        return result;
    }

    /**
     * 直接从两边扫描，主要是判断两边的指针该怎么动：
     * 头指针遇到奇数时，无论尾指针遇到奇数还是偶数，头指针右移，尾指针不动；
     * 当头指针遇到偶数时，如果尾指针也遇到了偶数，则头指针不动，尾指针左移。
     * 其他情况，即头指针遇到偶数，尾指针遇到奇数，交换，并同时向中心前进
     * @param array
     * @return
     */
    public int[] orderOddAndEven2(int[] array){

        int head = 0;
        int hail = array.length -1;
        while(head < hail){
            if(array[head] % 2 != 0){//如果头指向奇数，则正常向右走，尾不动
                head++;
            }else if(array[hail] % 2 == 0){//如果头为偶，尾也为偶，则尾正常向左走
                hail--;
            }else {//头为偶，尾为奇，则交换这两个元素；由于交换后这两个位置均正常，不必再判断，直接正常前进一步
                int temp = array[hail];
                array[hail] = array[head];
                array[head] = temp;
                hail--;
                head++;
            }
        }

        return array;
    }

    @Test
    public void test(){
        int[] array1 = {1,2,3,4,5,6,7,8,9};
        int[] array2 = {1,2,3,4,5,6,7,8,9};

        System.out.println(Arrays.toString(orderOddAndEven1(array1)));
        System.out.println(Arrays.toString(orderOddAndEven2(array2)));
    }

}
