package algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/************************************************************************************
 * 功能描述：
 *
 * Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.
 *
 * Example 1:
 * Input:nums = [1,1,1], k = 2
 * Output: 2
 * Note:
 * The length of the array is in range [1, 20,000].
 * The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
 *
 *
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2018年01月14日 --  下午2:00 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class SubarraySumEqualsK {


    /**
     * 暴力破解
     * <p>
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * <p>
     * 可以通过leetcode
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            if (sum == k) {
                res++;
            }

            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    res++;
                }
            }
        }

        return res;
    }

    /**
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * 思路来自：https://leetcode.com/problems/subarray-sum-equals-k/discuss/102106
     * we know the key to solve this problem is SUM[i, j].
     * So if we know SUM[0, i - 1] and SUM[0, j],
     * then we can easily get SUM[i, j].
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum2(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int res = 0;
        //key：[0, i]元素的和
        //value：[0, i]元素的和出现的次数
        Map<Integer, Integer> preSum = new HashMap<>();

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (preSum.containsKey(sum - k)) {
                res += preSum.get(sum - k);
            }
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }

        return res;
    }
}
