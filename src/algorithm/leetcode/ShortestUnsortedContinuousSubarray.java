package algorithm.leetcode;

import org.junit.Test;

import java.util.Arrays;

/************************************************************************************
 * 功能描述：
 *
 * Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.
 *
 * You need to find the shortest such subarray and output its length.
 *
 * Example 1:
 * Input: [2, 6, 4, 8, 10, 9, 15]
 * Output: 5
 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
 *
 * Note:
 * Then length of the input array is in range [1, 10,000].
 * The input array may contain duplicates, so ascending order here means <=.
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2018年01月08日 --  下午4:52 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class ShortestUnsortedContinuousSubarray {


    /**
     *
     * 排序法
     *
     * 时间复杂度：O(nlogn)
     * 空间复杂度：O(n)
     *
     * 也可以通过leetcode
     *
     *
     * @param nums
     * @return
     */
    public int findUnsortedSubarray(int[] nums) {

        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);

        int i = 0, j = nums.length - 1;

        while (i < nums.length && nums[i] == copy[i]){
            i++;
        }

        while (j > i && nums[j] == copy[j]){
            j--;
        }

        return j - i + 1;
    }

    /**
     *
     * todo 理解更优的解法
     *
     * 更优解法参考：https://leetcode.com/problems/shortest-unsorted-continuous-subarray/discuss/103066
     *
     * @param nums
     * @return
     */
    public int findUnsortedSubarray2(int[] nums) {

        return 0;
    }


    @Test
    public void test(){
        int[] a = {1,3,5,4,2};
        findUnsortedSubarray2(a);
    }

}
