package algorithm.array;

import org.junit.Test;

/************************************************************************************
 * 功能描述：
 *
 * 一个台阶总共有n 级，如果一次可以跳1 级，也可以跳2 级。
 * 求总共有多少总跳法，并分析算法的时间复杂度。
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2017年08月15日 --  下午9:09 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class Fibonacci {

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
    public int fibonacci1(int n) {
        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        return fibonacci1(n - 1) + fibonacci1(n - 2);
    }

    /**
     * 还是依据上面的公式，用一个数组维护前面两次的计算结果
     * 则本次计算的结果等于前两次之和
     * @param n
     * @return
     */
    public int fibonacci2(int n) {

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

    /**
     * 问题变种：
     * 想兑换100元钱，有1,2,5,10四种钱，问总共有多少兑换方法。
     * @return
     */
    public int combinationCoin(){
        int[] dimes = {1, 2, 5, 10};
        int n = 100;
        int m = 4;
        return combinationCoinRect(n, m, dimes);
    }

    /**
     *
     * @param n 钱的总数
     * @param m 使用几种钱币
     * @param dimes 钱币数组
     * @return
     */
    private int combinationCoinRect(int n, int m, int[] dimes){
        if(n == 0){
            return 1;
        }
        if(n < 0 || m == 0){
            return 0;
        }

        return combinationCoinRect(n, m-1, dimes) + combinationCoinRect(n - dimes[m-1], m, dimes);
    }




    @Test
    public void test(){
        System.out.println(fibonacci1(12));
        System.out.println(fibonacci2(12));
        System.out.println(combinationCoin());
    }
}
