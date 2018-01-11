package algorithm.leetcode;

import java.util.Arrays;

/************************************************************************************
 * 功能描述：
 *
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 *
 * For example,
 * Given [10, 9, 2, 5, 3, 7, 101, 18],
 * The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4.
 * Note that there may be more than one LIS combination, it is only necessary for you to return the length.
 *
 * Your algorithm should run in O(n2) complexity.
 *
 * Follow up: Could you improve it to O(n log n) time complexity?
 *
 *
 * 注意：这个子序列并不一定是连续的
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2018年01月11日 --  上午9:26 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class LongestIncreasingSubsequence {


    /**
     * 暴力循环：枚举所有子序列
     * <p>
     * <p>
     * <p>
     * 时间复杂度O(n^3)
     * <p>
     * <p>
     * 解法错误：题目要求子序列并不一定是连续的，而这里是以连续的为标准进行判断的
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxLength = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                boolean increasing = true;
                for (int k = i + 1; k <= j; k++) {
                    if (nums[k] >= nums[k - 1]) {
                        increasing = false;
                    }
                }
                if (increasing) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }

        return maxLength;
    }

    /**
     *
     * 动态规划:
     *
     * d[i] = max{
     *          d[0]:if(nums[i] > nums[0] ),
     *          d[1]:if(nums[i] > nums[1],
     *          ...,
     *          d[i-1]:if(nums[i] > nums[i-1]
     *          }
     *
     *          + 1
     *
     * 时间复杂度O(n^2)
     *
     * 可以通过leetcode
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        //maxNumber[i] 表示“以nums[i]结尾的最长递增元素”个数
        //最终结果就是maxNumber中的最大值
        int[] maxNumber = new int[nums.length];
        int res = 1;
        for (int i = 0; i < nums.length; i++) {
            int maxLength = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxLength = Math.max(maxLength, maxNumber[j] + 1);
                }
            }
            maxNumber[i] = maxLength;
            if(maxLength > res){
                res = maxLength;
            }
        }

        return res;
    }


    /**
     *
     * todo 未能理解
     *
     * leetcode有solution：https://leetcode.com/problems/longest-increasing-subsequence/solution/
     *
     * 时间复杂度：O(nlog(n))
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS3(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }





}
