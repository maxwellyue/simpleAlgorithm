package algorithm.leetcode;

import org.junit.Test;

/************************************************************************************
 * 功能描述：
 *
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Example 1:
 *
 * Input: 123
 * Output:  321
 * Example 2:
 *
 * Input: -123
 * Output: -321
 * Example 3:
 *
 * Input: 120
 * Output: 21
 * Note:
 * Assume we are dealing with an environment which could only hold integers within the 32-bit signed integer range.
 * For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 *
 *
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2018年01月10日 --  上午10:20 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class ReverseInteger {


    /**
     * 借助字符串
     *
     * @param x
     * @return
     */
    public int reverse(int x) {

        boolean positive = x >= 0;
        x = Math.abs(x);

        String s = String.valueOf(x);
        double res = 0;
        for (int i = 0; i < s.length(); i++) {
            double value = (s.charAt(i) - '0') * Math.pow(10, i);
            res += value;
        }

        if (res > Integer.MAX_VALUE) {
            return 0;
        }

        return positive ? (int) res : (int) -res;
    }


    /**
     *
     *
     *
     * 比如输入123，
     *
     * 则循环中：res等于前一步的结果乘以10，再加上下一位的数（x % 10）
     * res = 0    x = 123
     * res = 3    x = 12
     * res = 32   x = 1
     * res = 321  x = 0
     *
     *
     * 来自：https://leetcode.com/problems/reverse-integer/discuss/4240
     *
     * @param x
     * @return
     */
    public int reverse2(int x) {
        long res = 0;
        while (x != 0) {
            res = (res * 10) + (x % 10);
            if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE){
                return 0;
            }
            x = x / 10;
        }
        return (int)res;
    }


    @Test
    public void test() {
        System.out.println(reverse2(-123));
    }
}
