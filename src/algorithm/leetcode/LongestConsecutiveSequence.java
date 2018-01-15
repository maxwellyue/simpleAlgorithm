package algorithm.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/************************************************************************************
 * 功能描述：
 *
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 *
 * For example,
 * Given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 *
 * Your algorithm should run in O(n) complexity.
 *
 * 求序列中最长可以连续的数字的个数
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2018年01月15日 --  下午7:59 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class LongestConsecutiveSequence {

    /**
     * 排序法
     *
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);
        int res = 1;
        int consecutive = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == 1) {
                consecutive++;
                res = Math.max(res, consecutive);
            } else if (nums[i] == nums[i - 1]) {
                continue;
            } else {
                consecutive = 1;
            }

        }

        return res;
    }

    /**
     *
     * 来自leetcode的solution:
     *
     * 时间复杂度是O(n)
     *
     * Although the time complexity appears to be quadratic due to the while loop nested within the for loop,
     * closer inspection reveals it to be linear.
     * Because the while loop is reached only when currentNum marks the beginning of a sequence
     * (i.e. currentNum-1 is not present in nums),
     * the while loop can only run for n iterations throughout the entire runtime of the algorithm.
     *
     * This means that
     * despite looking like O(n*n) complexity,
     * the nested loops actually run in O(n+n)=O(n) time.
     *
     * All other computations occur in constant time, so the overall runtime is linear.
     *
     *
     * 非常巧妙
     *
     * 当然空间复杂度是：O(n)
     *
     *
     *
     * @param nums
     * @return
     */
    public int longestConsecutive2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }

        int res = 0;

        for (Integer n : set) {
            if(set.contains(n - 1)){
                continue;
            }
            int currentNum = n;
            int currentStreak = 1;
            while (set.contains(currentNum + 1)) {
                currentNum += 1;
                currentStreak += 1;
            }
            res = Math.max(res, currentStreak);
        }

        return res;
    }


    @Test
    public void test() {
        int[] a = {0, -1};
        System.out.println(longestConsecutive(a));
    }
}
