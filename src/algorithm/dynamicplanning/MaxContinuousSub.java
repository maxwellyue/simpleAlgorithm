package algorithm.dynamicplanning;

import org.junit.Assert;
import org.junit.Test;

/************************************************************************************
 * 功能描述：
 *
 * 给一个浮点数序列，取最大乘积连续子串的值。
 *
 * 例如 -2.5，4，0，3，0.5，8，-1，则取出的最大乘积连续子串为3，0.5，8。
 * 也就是说，上述数组中，3 0.5 8这3个数的乘积3*0.5*8=12是最大的，而且是连续的。
 *
 * 变种：最大连续自序列和，见方法maxSubArray
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2017年08月25日 --  下午3:38 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class MaxContinuousSub {

    /**
     * 暴力循环
     *
     * @param array
     * @return
     */
    public double maxContinuousSub(double[] array) {

        double maxProduct = 0;
        for (int i = 0; i < array.length; i++) {
            double product = 1;
            for (int j = i; j < array.length; j++) {
                product *= array[j];
                if (product > maxProduct) {
                    maxProduct = product;
                }
            }
        }
        return maxProduct;
    }


    /**
     * 动态规划
     * <p>
     * 要理解：
     * max和min一定是由连续的一个或多个数相乘计算出来的结果
     * 比如，在for循环的i=2的时候，
     * 刚进入循环体时，max表示包含array[1]在内的连续子串的最大乘积
     * 然后，将array[2]， array[2]*max，array[2]*min之间的最大值选出来，作为包含array[2]在内的连续子串的最大乘积，
     * 因为刚进入循环体时max表示包含array[1]在内的连续子串的最大乘积，所以无论取这三种情况的哪一个值，都能确保结果包含array[2]，
     * 即计算后的max表示包含array[2]在内的连续子串的最大乘积，
     * 进入下次循环的时候，i=3，刚刚进入循环体时，max表示包含array[2]在内的连续子串的最大乘积
     *
     * @param array
     * @return
     */
    public double maxContinuousSub2(double[] array) {
        double max = array[0];
        double min = array[0];
        double result = array[0];
        for (int i = 1; i < array.length; i++) {
            double temp = max;//将之前计算的最大值先保存起来，下面计算本次最小值的时候要用到
            //当前最大值只可能是以下3种情况之一：
            //①自身；②之前的最大值与自身的乘积；③之前的最小值与自身的乘积
            max = max(array[i], max * array[i], min * array[i]);
            //同理，当前最小值只可能是：①自身；②之前的最大值与自身的乘积；③之前的最小值与自身的乘积
            min = min(array[i], temp * array[i], min * array[i]);
            if (max > result) {
                result = max;
            }
        }
        return result;
    }

    public int maxSubArray(int[] A) {
        int curMax = A[0];
        int max = A[0];
        for (int i = 1; i < A.length ; i++) {
            curMax = Math.max(A[i], curMax + A[i]);
            max = Math.max(max, curMax);
        }
        return max;
    }




    private double max(double a, double b, double c) {
        return Math.max(a, Math.max(b, c));
    }

    private double min(double a, double b, double c) {
        return Math.min(a, Math.min(b, c));
    }

    @Test
    public void test() {
        double[] array = {-2.5, 4, 0, 3, 0.5, 8, -1};
        Assert.assertEquals((double) 12.0, maxContinuousSub(array), 0);
        Assert.assertEquals((double)12.0, maxContinuousSub2(array), 0);
    }

}
