package algorithm.leetcode;

/************************************************************************************
 * 功能描述：
 *
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 *
 * For example, given the following matrix:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * Return 4.
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2018年01月15日 --  下午8:40 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class MaximalSquare {

    /**
     * 暴力循环
     * <p>
     * 以每一个点为方形的左上角，向右、下扩展长度，求最大长度
     *
     * Time complexity : O((mn)^2)
     *          In worst case, we need to traverse the complete matrix for every 1.
     * Space complexity :O(1). No extra space is used.
     *
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        int max = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i--][j--] == '1') {
                    int length = 1;
                    boolean flag = true;
                    while (length + i < rows && length + j < cols && flag) {
                        for (int k = j; k <= length + j; k++) {
                            if (matrix[i + length][k] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        for (int k = i; k <= length + i; k++) {
                            if (matrix[k][j + length] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        if (flag)
                            length++;
                    }
                    max = Math.max(max, length);
                }
            }
        }
        return max * max;
    }

    /**
     *
     * 动态规划：
     *
     * d(i, j) = min{d(i, j-1), d(i-1, j), d(i-1, j-1)} + 1
     *
     *
     * Time complexity : O(mn)O(mn). Single pass.
     * Space complexity : O(mn)O(mn). Another matrix of same size is used for dp.
     *
     * @param matrix
     * @return
     */
    public int maximalSquare2(char[][] matrix) {
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        int[][] dp = new int[rows + 1][cols + 1];
        int max = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (matrix[i-1][j-1] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }
}
