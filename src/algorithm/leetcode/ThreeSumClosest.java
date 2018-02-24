package algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/************************************************************************************
 * 功能描述：
 *
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
 *
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 *
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 *
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 *
 *
 * 创建人：岳增存  yueyuemax@gmail.com
 * 创建时间： 2018年02月24日 --  下午2:18 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class ThreeSumClosest {

    /**
     *
     * 参照三数之和为0的思路
     *
     * 在此基础之上，添加一个变量minDistance，维护最小差值
     *
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0;
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i + 2 < nums.length; i++) {
            // skip same result
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1, k = nums.length - 1;
            int remain = target - nums[i];
            while (j < k) {
                int curDistance = Math.abs(remain - nums[j] - nums[k]);
                if (curDistance < minDistance) {
                    res = nums[i] + nums[j] + nums[k];
                    minDistance = curDistance;
                }

                if (nums[j] + nums[k] == remain) {
                    return nums[i] + nums[j] + nums[k];
                } else if (nums[j] + nums[k] > remain) {
                    k--;
                } else {
                    j++;
                }
            }
        }

        return res;
    }

    @Test
    public void test(){
        Assert.assertEquals(2, threeSumClosest(new int[]{1,1,1,0}, -100));
    }

}
