package algorithm.leetcode;

import org.junit.Test;

/************************************************************************************
 * 功能描述：
 *
 * Implement int sqrt(int x).
 *
 * Compute and return the square root of x.
 *
 * x is guaranteed to be a non-negative integer.
 *
 *
 * Example 1:
 *
 * Input: 4
 * Output: 2
 * Example 2:
 *
 * Input: 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842...,
 * and since we want to return an integer, the decimal part will be truncated.
 *
 * 求平方根
 *
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2018年01月03日 --  下午6:08 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class Sqrt {

    /**
     * 暴力查找
     * <p>
     * 时间复杂度：O(sqrt(x))
     * leetcode上没有通过，Time Limit Exceeded
     *
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        for (int i = 0; i <= x; i++) {
            if (i * i == x) {
                return i;
            } else if (i * i > x && (i - 1) * (i - 1) < x) {
                return i - 1;
            }
        }
        return -1;
    }

    /**
     * 二分法查找
     * <p>
     * https://leetcode.com/problems/sqrtx/discuss/25198
     *
     * @param x
     * @return
     */
    public int mySqrt2(int x) {

        if(x == 0){
            return 0;
        }

        int start = 0, end = x;
        while (start <= end) {
            int middle = start + (end - start) / 2;
            if (middle  <= x / middle && (middle + 1) > x / (middle + 1)) {
                return middle;
            } else if (middle >  x / middle) {
                end = middle -1;
            } else {
                start = middle + 1;
            }
        }
        return start;
    }

    /**
     * 位运算
     *
     *  https://leetcode.com/problems/sqrtx/discuss/25048
     *
     *  todo 没理解
     * @param x
     * @return
     */
    public int mySqrt3(int x) {
        int res = 0;
        for (int mask = 1 << 15; mask != 0; mask >>>= 1) {
            int next = res | mask; //set bit
            if (next <= x / next) res = next;
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(mySqrt3(2147395599));
        Math.sqrt(1213);
    }


}
