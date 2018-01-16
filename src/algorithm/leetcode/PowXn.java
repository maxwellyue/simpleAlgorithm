package algorithm.leetcode;

import org.junit.Test;

/************************************************************************************
 * 功能描述：
 *
 *
 * Implement pow(x, n).
 *
 *
 * Example 1:
 *
 * Input: 2.00000, 10
 * Output: 1024.00000
 * Example 2:
 *
 * Input: 2.10000, 3
 * Output: 9.26100
 *
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2018年01月16日 --  上午10:14 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class PowXn {


    /**
     * 直接循环
     * <p>
     * 要注意n为负数的情况
     * <p>
     * 无法通过LeetCode，超时
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }

        if (n == 0) {
            return 1;
        }

        double res = 1;
        boolean positive = n > 0;
        n = positive ? n : -n;
        for (int i = 0; i < n; i++) {
            res *= x;
        }
        return positive ? res : 1 / res;
    }


    /**
     * 考虑n>0的情况
     * res = x*x*x*x*x*x  共n个
     * 上面的思路是依次循环，改进的思路就是减少循环次数：
     * 将所有x的个数进行折半
     * res1 = x*x*x       共n/2个
     * res = res1*res1
     * <p>
     * 时间复杂度 : O(log(n))
     * 空间复杂度：O(log(n))
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow2(double x, int n) {
        if (n == 0) {
            return 1;
        }

        if (n == Integer.MIN_VALUE) {
            n = n >> 1;
            x = x * x;
        }

        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        return (n & 1) != 0 ? x * myPow2(x * x, n / 2) : myPow2(x * x, n / 2);
    }

    /**
     * 基于上面的递归的思路
     *
     * 时间复杂度 : O(log(n))
     * 空间复杂度：O(1)
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow3(double x, int n) {
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        double res = 1;
        double curProduct = x;

        //共循环：
        // 第一次计算出currentProduct = x*x
        // 第二次计算出currentProduct = (x*x)*(x*x)
        // 2-->4-->8-->直到=n
        for (int i = n; i > 0; i >>= 1) {
            if ((n & 1) != 0) {
                res = res * curProduct;
            }
            curProduct = curProduct * curProduct;
        }
        return res;
    }


    @Test
    public void test() {
        System.out.println(myPow3(2, 10));

        Math.pow(1, 1);
    }
}
