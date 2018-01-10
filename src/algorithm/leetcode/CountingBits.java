package algorithm.leetcode;

/************************************************************************************
 * 功能描述：
 *
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.
 *
 * Example:
 * For num = 5 you should return [0,1,1,2,1,2].
 *
 * Follow up:
 *
 * It is very easy to come up with a solution with run time O(n*sizeof(integer)).
 * But can you do it in linear time O(n) /possibly in a single pass?
 * Space complexity should be O(n).
 * Can you do it like a boss?
 * Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
 *
 *
 *
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2018年01月10日 --  下午5:15 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class CountingBits {

    /**
     * 借助Integer.bitCount(i)方法
     * <p>
     * 但题目中要求不要使用自带函数
     * <p>
     * 但这是最直观的方法
     *
     * @param num
     * @return
     */
    public int[] countBits(int num) {
        int[] res = new int[num + 1];

        for (int i = 0; i <= num; i++) {
            res[i] = Integer.bitCount(i);
        }

        return res;
    }

    /**
     * 动态规划
     * <p>
     * 来自：https://discuss.leetcode.com/topic/40195/how-we-handle-this-question-on-interview-thinking-process-dp-solution
     * <p>
     * <p>
     * dp[1] = dp[1-1] + 1;
     * <p>
     * dp[2] = dp[2-2] + 1;
     * <p>
     * dp[3] = dp[3-2] +1;
     * <p>
     * dp[4] = dp[4-4] + 1;
     * <p>
     * dp[5] = dp[5-4] + 1;
     * <p>
     * dp[6] = dp[6-4] + 1;
     * <p>
     * dp[7] = dp[7-4] + 1;
     * <p>
     * dp[8] = dp[8-8] + 1;
     * ..
     * <p>
     * Obviously, we can find the pattern for above example, so now we get the general function
     * <p>
     * dp[index] = dp[index - offset] + 1;
     *
     * @param num
     * @return
     */
    public int[] countBits2(int num) {
        int[] res = new int[num + 1];
        res[0] = 0;
        int offset = 1;
        for (int index = 1; index < num + 1; ++index) {
            if (offset * 2 == index) {
                offset *= 2;
            }
            res[index] = res[index - offset] + 1;
        }
        return res;
    }

    /**
     * 找到规律：f[i] = f[i / 2] + i % 2.
     * <p>
     * 如果i是偶数的话，1的个数是和i/2一样多的。
     * 如果i是奇数的话，1的个数比i/2多1个。
     *
     * @param num
     * @return
     */
    public int[] countBits3(int num) {
        int[] res = new int[num + 1];
        res[0] = 0;
        for (int i = 1; i <= num; i++) {
            res[i] = res[i >> 1] + (i & 1);
        }
        return res;
    }
}
