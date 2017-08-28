package algorithm.array;

import algorithm.sort.QuickSort;
import org.junit.Assert;
import org.junit.Test;

/************************************************************************************
 * 功能描述：
 *
 * 数组中有一个数字出现的次数超过了数组长度的一半，找出这个数字。
 *
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2017年08月25日 --  下午12:46 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class ExceedHalf {

    /**
     *
     * 先排序，则在数组中间的位置上，一定是要找个那个数
     *
     * @param array
     * @return
     */
    public int findExceedHalf(int[] array){
        //快排
        QuickSort.sort(array);
        return array[array.length >> 1];
    }

    /**
     *
     * 每次删除两个不同的数（不管是不是我们要查找的那个出现次数超过一半的数字），
     * 那么，在剩下的数中，我们要查找的数（出现次数超过一半）出现的次数仍然超过总数的一半。
     * 通过不断重复这个过程，不断排除掉其它的数，最终找到那个出现次数超过一半的数字。
     * 这个方法，免去了排序，也避免了空间O(n)的开销，
     * 总得说来，时间复杂度只有O(n)，空间复杂度为O(1)，貌似不失为最佳方法。
     *
     * 但是Java里数组只能通过复制，不能删除元素。。。
     * 
     * @param array
     * @return
     */
    public int findExceedHalf2(int[] array){

        // TODO: 2017/8/25
        
        return 0;
    }

    /**
     * 在遍历数组的时候保存两个值：
     * 一个candidate，用来保存数组中遍历到的某个数字；
     * 一个nTimes，表示当前数字的出现次数，其中，nTimes初始化为1。
     *
     * 当我们遍历到数组中下一个数字的时候：
     * 如果下一个数字与之前candidate保存的数字相同，则nTimes加1；
     * 如果下一个数字与之前candidate保存的数字不同，则nTimes减1；
     * 每当出现次数nTimes变为0后，用candidate保存下一个数字，并把nTimes重新设为1。
     * 直到遍历完数组中的所有数字为止。
     *
     * @param array
     * @return
     */
    public int findExceedHalf3(int[] array){
        int candidate = array[0];
        int times = 1;
        for (int i = 1; i < array.length; i++){
            if(array[i] == candidate){
                times++;
            }else {
                times--;
                if((times == 0) && (i+1 < array.length)){
                    candidate = array[++i];
                    times = 1;
                }
            }
        }

        return candidate;
    }

    @Test
    public void test(){
        int[] array = {1,5,4,5,3,1,1,1,1};
        Assert.assertSame(1, findExceedHalf(array));
        Assert.assertSame(1, findExceedHalf3(array));
    }


}
