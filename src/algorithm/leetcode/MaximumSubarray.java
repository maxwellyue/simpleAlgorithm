package algorithm.leetcode;

/************************************************************************************
 * 功能描述：
 *
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 *
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 *
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2018年01月04日 --  上午11:07 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class MaximumSubarray {

    /**
     * 令currSum为当前最大子数组的和，maxSum为最后要返回的最大子数组的和，当我们往后扫描时，
     * 对第i+1个元素有两种选择：要么放入前面找到的子数组，要么做为新子数组的第一个元素；
     * 如果currSum加上当前元素a[i]后不小于a[i]，则令currSum加上a[i]，否则currSum重新赋值，置为下一个元素，即currSum = a[i]。
     * 同时，当currSum > maxSum，则更新maxSum = currSum，否则保持原值，不更新。
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int curSum = nums[0];

        for(int i = 1; i < nums.length; i++){
            curSum = nums[i] > nums[i] + curSum ? nums[i] : nums[i] + curSum;
            max = curSum > max ? curSum : max;
        }

        return max;
    }

}
