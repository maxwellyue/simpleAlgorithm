package algorithm.leetcode;

import java.util.Arrays;

/************************************************************************************
 * 功能描述：
 *
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 *
 * You may assume that the array is non-empty and the majority element always exist in the array.
 *
 * 详见：https://github.com/maxwellyue/simpleAlgorithm/blob/master/src/algorithm/array/ExceedHalf.java
 * 与之相同
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2018年01月03日 --  下午4:02 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class MajorityElement {

    /**
     * 先排序，出现在中间的元素，必然是出现次数超过一半的那个数
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length /2];
    }

    /**
     *
     *
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        int candidate = nums[0];
        int times = 1;
        for (int i = 1; i < nums.length; i++){
            if(nums[i] == candidate){
                times++;
            }else {
                times--;
                if((times == 0) && (i+1 < nums.length)){
                    candidate = nums[++i];
                    times = 1;
                }
            }
        }

        return candidate;
    }



}
