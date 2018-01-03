package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/************************************************************************************
 * 功能描述：
 *
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 *
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 *
 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 *
 * Example:
 *
 * Input:
 * [4,3,2,7,8,2,3,1]
 *
 * Output:
 * [5,6]
 *
 * 题的条件：数组中每个元素在[1,n]之间，且数组大小为n
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2018年01月03日 --  下午7:21 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class FindAllNumbersDisappearedInAnArray {


    /**
     *
     * 正负表示法
     *
     * 数组下标为0，1， 2，...， n-1
     * 假设a = nums[i] - 1，a如果是数组下标，则必定是0，1， 2，...， n-1中的一个
     *
     * 循环数组，让位置a = nums[i] - 1处对应的数组元素变为本身的负值，
     * 这样就表示数字a = nums[i] - 1出现过
     *
     *
     * 没出现的数字是哪些呢？
     *
     * 如果i位置上元素为负值，说明i+1这个数字出现过，才让i位置上元素变为负值
     * 如果i位置上元素为正值，说明i+1这个数字没有出现过
     *
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < nums.length; i++){
            nums[Math.abs(nums[i]) - 1] = -nums[Math.abs(nums[i]) - 1];
        }

        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                list.add(i + 1);
            }
        }

        return list;
    }
}
