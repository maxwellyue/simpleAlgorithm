package algorithm.leetcode;

import org.junit.Test;

import java.util.Arrays;

/************************************************************************************
 * 功能描述：
 *
 *
 *Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 *
 *For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
 *
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2018年01月14日 --  下午1:31 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class PerfectSquares {


    /**
     * 动态规划
     * <p>
     * <p>
     * 来自：https://leetcode.com/problems/perfect-squares/discuss/71605
     *
     * @param n
     * @return
     */
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= n; i++) {
            int sqrt = (int) Math.sqrt(i);

            // If the number is already a perfect square,
            // then dp[number] can be 1 directly. This is
            // just a optimization for this DP solution.
            if (sqrt * sqrt == i) {
                dp[i] = 1;
                continue;
            }

            // To get the value of dp[n], we should choose the min
            // value from:
            //     dp[n - 1] + 1,
            //     dp[n - 4] + 1,
            //     dp[n - 9] + 1,
            //     dp[n - 16] + 1
            //     and so on...
            for (int j = 1; j <= sqrt; j++) {
                int dif = i - j * j;
                dp[i] = Math.min(dp[i], (dp[dif] + 1));
            }
        }

        return dp[n];
    }

    /**
     *
     * 来自：https://leetcode.com/problems/perfect-squares/discuss/71495
     *
     * dp[0] = 0
     * dp[1] = dp[0]+1 = 1
     * dp[2] = dp[1]+1 = 2
     * dp[3] = dp[2]+1 = 3
     * dp[4] = Min{ dp[4-1*1]+1, dp[4-2*2]+1 }
     *       = Min{ dp[3]+1, dp[0]+1 }
     *       = 1
     * dp[5] = Min{ dp[5-1*1]+1, dp[5-2*2]+1 }
     *       = Min{ dp[4]+1, dp[1]+1 }
     *       = 2
     * .
     * .
     * .
     * dp[13] = Min{ dp[13-1*1]+1, dp[13-2*2]+1, dp[13-3*3]+1 }
     *      = Min{ dp[12]+1, dp[9]+1, dp[4]+1 }
     *      = 2
     * .
     * .
     * .
     * dp[n] = Min{ dp[n - i*i] + 1 },  n - i*i >=0 && i >= 1
     *
     *
     *
     * @param n
     * @return
     */
    public int numSquares2(int n) {
        if(n <= 0){
            return 0;
        }

        int[] res = new int[n+1];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[0] = 0;
        res[1] = 1;

        for(int i = 2; i <= n; i++){
            for(int j = 1; j*j <= i; j++){
                res[i] = Math.min(res[i], res[i - j*j] + 1);
            }
        }
        return res[n];
    }

    @Test
    public void test(){
        numSquares2(2);
    }
}
