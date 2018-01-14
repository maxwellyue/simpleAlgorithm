package algorithm.leetcode;

/************************************************************************************
 * 功能描述：
 *
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * How many possible unique paths are there?
 *
 *
 * Above is a 3 x 7 grid. How many possible unique paths are there?
 *
 * Note: m and n will be at most 100.
 *
 *
 *
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2018年01月12日 --  下午5:04 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class UniquePath {


    /**
     *
     * 动态规划
     *
     * 对于第i行，第j列的格子而言，达到这个位置是由到它上面和左边的两个格子的路径之和。
     * res[i][j]=res[i-1][j]+res[i][j-1]
     *
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {

        int[][] res = new int[m][n];
        //最上面一行
        for (int i = 0; i < m; i++) {
            res[i][0] = 1;
        }
        //最左一列
        for (int j = 0; j < n; j++) {
            res[0][j] = 1;
        }
        //其他小格子
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                res[i][j] = res[i - 1][j] + res[i][j - 1];
            }
        }
        return res[m - 1][n - 1];
    }


}
