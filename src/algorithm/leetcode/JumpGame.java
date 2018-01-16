package algorithm.leetcode;

import org.junit.Test;

/************************************************************************************
 * 功能描述：
 *
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Determine if you are able to reach the last index.
 *
 * For example:
 * A = [2,3,1,1,4], return true.
 *
 * A = [3,2,1,0,4], return false.
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2018年01月16日 --  下午3:36 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class JumpGame {


    /**
     * 动态规划
     * <p>
     * d[i] 表示nums中i位置处的元素是否可以调到最后
     * 则有 d[i] = d[a1] || d[a2] || ... || d[an]，
     * 其中a1,a2,...,an为[i+1, i+nums[i]]的值
     *
     *
     * 但不知道为啥，会超时，无法通过leetcode
     *
     * leetcode上的solutions前三种也是动态规划，也是超时，
     * 只有最后一种解法没有超时
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        boolean[] res = new boolean[nums.length];

        if(nums[0] >= nums.length - 1){
            return true;
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] + i >= nums.length - 1) {
                res[i] = true;
            } else {
                for (int j = nums[i]; j >= 1; j--) {
                    res[i] = res[i] || res[i + j];
                    if (res[i]) {
                        break;
                    }
                }
            }
        }
        return res[0];
    }


    /**
     *
     * leetcode上的solutions中给出的唯一不超时的解答
     *
     *
     *
     * 思路是：
     * 只要有一种通过即可，其他的不必再求
     * 要想明白：只要可以跳到i，就必然可以跳到[0, i]的任意位置
     *
     * 这样就可以大幅跳跃，避免不必要的求取计算
     *
     *
     *
     * @param nums
     * @return
     */
    public boolean canJump2(int[] nums) {
        //最后的可以调到最后的位置
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }

    @Test
    public void test() {
        int[] a = {1, 1, 1, 0};
        System.out.println(canJump(a));
    }
}
