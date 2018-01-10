package algorithm.leetcode;

import org.junit.Test;

/************************************************************************************
 * 功能描述：
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2018年01月10日 --  下午6:00 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class CoinChange {


    /**
     * 来自：https://leetcode.com/problems/coin-change/discuss/77404
     * <p>
     * <p>
     * 对于钱数i
     * 假设有n中钱币种数，
     * <p>
     * d[i] = min{1 + d[i - coins[0]，1 + d[i - coins[1]， 1 + d[i - coins[2] ， .... ，1 + d[i - coins[n-1]}
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount <= 0) {
            return 0;
        }

        int[] min = new int[amount + 1];

        for (int i = 1; i <= amount; i++) {
            //钱数为i时的最小组合数
            min[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i && min[i - coins[j]] != Integer.MAX_VALUE) {
                    min[i] = Integer.min(min[i], 1 + min[i - coins[j]]);
                }
            }
        }

        return min[amount] == Integer.MAX_VALUE ? -1 : min[amount];
    }


    public int coinChange2(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount <= 0) {
            return 0;
        }

        return min(coins, amount, new int[amount + 1]);
    }


    /**
     *
     *
     * 从计算的正确性上将，也可以不使用int[] minNumber，
     * 但会导致大量的重复计算，
     * 无法通过leetcode
     *
     *
     * 思路来自：https://leetcode.com/problems/coin-change/discuss/77368
     * 但无法理解其中的：if(count[rem-1] != 0) return count[rem-1];
     * 所以进行了改写，主要是对何时重复使用之前计算结果的判断，
     * 我觉得下面的代码会更容易理解，
     *
     * @param coins     钱币种数
     * @param remainder 剩余的钱数
     * @param minNumber 结算的结果：minNumber[i] 表示钱数i的最小组成数为minNumber[i]
     * @return
     */
    private int min(int[] coins, int remainder, int[] minNumber) {
        if (remainder < 0) {//找不到解
            return -1;
        } else if (remainder == 0) {//解为0个
            return 0;
        } else {
            int min = Integer.MAX_VALUE;
            for (int n : coins) {
                // remainder - n >= 0 确保minNumber不会越界
                // minNumber[remainder - n] != 0 时，
                // 说明钱为remainder - n时的最小组成数之前已经计算过，直接取即可，不必重复计算
                // min(coins, remainder - n, minNumber) ：求钱为remainder - n时的最小组成数
                int res = remainder - n >= 0 && minNumber[remainder - n] != 0 ? minNumber[remainder - n] : min(coins, remainder - n, minNumber);
                if (res != -1) {
                    min = Math.min(min, res + 1);
                }
            }
            min = min == Integer.MAX_VALUE ? -1 : min;
            minNumber[remainder] = min;
            return min;
        }
    }


    @Test
    public void test() {
        int[] a = {1, 2, 5};
        int b = 100;
        System.out.println(coinChange2(a, b));
    }


}


