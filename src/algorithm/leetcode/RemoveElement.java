package algorithm.leetcode;

/************************************************************************************
 * 功能描述：
 *
 * Given an array and a value, remove all instances of that > value in place and
 * return the new length.
 * The order of elements can be changed. It doesn't matter what you leave
 * beyond the new length.
 *
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 *
 * Given nums = [3,2,2,3], val = 3,
 *
 * Your function should return length = 2, with the first two elements of nums being 2.
 *
 *
 * 在一个数组里面移除指定value，并且返回新的数组长度
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2017年12月29日 --  下午3:41
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class RemoveElement {

    public int removeElement(int[] nums, int val) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        //相当于新数组的下标，下面的循环，就理解为为新数组赋值
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != val){
                nums[j] = nums[i];
                j++;
            }
        }

        return j;
    }


}
