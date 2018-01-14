package algorithm.leetcode;

import org.junit.Test;

import java.util.LinkedList;

/************************************************************************************
 * 功能描述：
 *
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.
 *
 * Find out how many ways to assign symbols to make sum of integers equal to target S.
 *
 * Example 1:
 * Input: nums is [1, 1, 1, 1, 1], S is 3.
 * Output: 5
 * Explanation:
 *
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 *
 There are 5 ways to assign symbols to make the sum of nums be target 3.
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2018年01月14日 --  下午3:08 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class TargetSum {

    /**
     * 暴力循环，穷举所有情况
     * <p>
     * 无法通过leetcode，Time Limit Exceeded
     * <p>
     * 时间复杂度：O(n*2^n)
     * 空间复杂度：O(2^n)
     *
     * @param nums
     * @param s
     * @return
     */
    public int findTargetSumWays(int[] nums, int s) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int res = 0;
        LinkedList<Integer> list = new LinkedList<>();
        list.add(0);
        for (int i = 0; i < nums.length; i++) {
            int size = list.size();
            for (; size >= 0; size--) {
                Integer first = list.pollFirst();
                if (i == nums.length - 1) {
                    if (first + nums[i] == s) {
                        res++;
                    }
                    if (first - nums[i] == s) {
                        res++;
                    }
                } else {
                    list.add(first + nums[i]);
                    list.add(first - nums[i]);
                }
            }
        }

        return res;
    }


    /**
     * 深度优先搜索
     * <p>
     * 来自：https://leetcode.com/problems/target-sum/discuss/97371
     */
    private int res = 0;

    public int findTargetSumWays2(int[] nums, int s) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        findTarget(nums, s, 0, 0);
        return res;
    }

    private void findTarget(int[] nums, int target, int prevSum, int start) {
        if (start == nums.length) {
            if (target == prevSum) {
                res++;
            }
            return;
        } else {
            findTarget(nums, target, prevSum + nums[start], start + 1);
            findTarget(nums, target, prevSum - nums[start], start + 1);
        }
    }


    /**
     * 不使用全局变量的DFS写法
     *
     * @param nums
     * @param s
     * @return
     */
    public int findTargetSumWays3(int[] nums, int s) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return findTarget2(nums, s, 0, 0);
    }

    private int findTarget2(int[] nums, int target, int prevSum, int start) {
        if (start == nums.length) {
            return target == prevSum ? 1 : 0;
        } else {
            return findTarget2(nums, target, prevSum + nums[start], start + 1)
                    + findTarget2(nums, target, prevSum - nums[start], start + 1);
        }
    }

    /**
     *
     * todo 如何剪枝来优化DFS
     *
     * @param nums
     * @param s
     * @return
     */
    public int findTargetSumWays4(int[] nums, int s) {
        return 0;
    }

    @Test
    public void test() {
        int[] a = {1, 1, 1, 1, 1};
        findTargetSumWays2(a, 3);
    }

}
