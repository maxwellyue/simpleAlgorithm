package algorithm.leetcode;

/************************************************************************************
 * 功能描述：
 *You are climbing a stair case. It takes n steps to reach to the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Note: Given n will be a positive integer.
 *
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2018年01月02日 --  下午6:08 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class ClimbingStairs {

    /**
     * 总结出公式，进行递归
     * <p>
     * 1                             n = 1
     * f(n)=   2                             n = 2
     * f(n-1) + f(n-2)               n > 2
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    /**
     * 利用f(n) = f(n-1) + f(n-2)
     * 用一个数组保存前两次的结果
     * @param n
     * @return
     */
    public int climbStairs2(int n){
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        int[] d = {1, 2};

        int result = 0;

        for (int i = 3; i <= n; i++) {
            result = d[0] + d[1];
            d[0] = d[1];
            d[1] = result;
        }

        return result;
    }

}
