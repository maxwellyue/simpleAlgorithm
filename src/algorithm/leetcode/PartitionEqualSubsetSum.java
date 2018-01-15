package algorithm.leetcode;

import org.junit.Test;

import java.util.Arrays;

/************************************************************************************
 * 功能描述：
 *
 * Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
 *
 * Note:
 * Each of the array element will not exceed 100.
 * The array size will not exceed 200.
 * Example 1:
 *
 * Input: [1, 5, 11, 5]
 *
 * Output: true
 *
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 * Example 2:
 *
 * Input: [1, 2, 3, 5]
 *
 * Output: false
 *
 * Explanation: The array cannot be partitioned into equal sum subsets.
 *
 *
 * 实质就是背包问题
 *
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2018年01月15日 --  下午6:15 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class PartitionEqualSubsetSum {

    /**
     * 基于深度优先搜索的思想
     * <p>
     * 无法通过LeetCode，超时
     *
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        //sum必须是偶数，否则一定不存在
        if ((sum & 1) != 0) {
            return false;
        }

        //寻找子序列，使和等于sum/2
        return helper(nums, sum >> 1, 0);
    }

    private boolean helper(int[] nums, int target, int start) {
        if (target == 0) {
            return true;
        } else if (target < 0) {
            return false;
        } else {
            for (int i = start; i < nums.length; i++) {
                if (helper(nums, target - nums[i], i + 1)) {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     *
     * 基于上面的深度优先搜索进行的改进：保存之前的计算结果，避免重复计算
     *
     * 可以通过LeetCode
     *
     * @param nums
     * @return
     */
    public boolean canPartition2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        //sum必须是偶数，否则一定不存在
        if ((sum & 1) != 0) {
            return false;
        }

        //寻找子序列，使和等于sum/2
        int[] res = new int[(sum >> 1) + 1];
        Arrays.fill(res, -1);//-1表示尚未计算，0表示false，1表示存在
        res[0] = 1;

        return helper2(nums, sum >> 1, 0, res);
    }

    private boolean helper2(int[] nums, int target, int start, int[] res) {
        if (target == 0) {
            return true;
        } else {
            boolean cur = false;
            for (int i = start; i < nums.length; i++) {
                if (target - nums[i] < 0) {
                    break;
                } else {
                    if (res[target - nums[i]] == 1) {
                        cur = true;
                        break;
                    } else if (res[target - nums[i]] == 0) {
                        continue;
                    } else {
                        if (helper2(nums, target - nums[i], i + 1, res)) {
                            cur = true;
                            break;
                        }
                    }
                }
            }
            res[target] = cur ? 1 : 0;
            return cur;
        }
    }

    /**
     *
     * 基于动态规划的思想
     *
     * @param nums
     * @return
     */
    public boolean canPartition3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        //sum必须是偶数，否则一定不存在
        if ((sum & 1) != 0) {
            return false;
        }

        sum = sum >> 1;

        //寻找子序列，使和等于sum/2
        boolean[] res = new boolean[sum + 1];
        res[0] = true;
        for(int i = 0; i < nums.length; i++){
            for(int j = sum; j >0; j--){
                res[j] = res[j] || res[j - nums[i-1]];
            }
        }
        return res[sum];
    }



    @Test
    public void test() {
        int[] a = {1, 5, 11, 5};
        System.out.println(canPartition2(a));
    }
}
