package algorithm.leetcode;

/************************************************************************************
 * 功能描述：
 *
 *
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 *
 * For example,
 * Given n = 3, there are a total of 5 unique BST's.
 *
 *      1         3     3      2      1
 *      \       /     /      / \      \
 *      3      2     1      1   3     2
 *      /     /       \                \
 *     2     1        2                 3
 *
 *
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2018年01月11日 --  下午5:01 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class UniqueBinarySearchTrees {


    /**
     *
     * 总结规律：
     *
     * http://www.cnblogs.com/grandyang/p/4299608.html
     *
     * 我们把n = 0 时赋为1，因为空树也算一种二叉搜索树，那么n = 1时的情况可以看做是其左子树个数乘以右子树的个数，左右字数都是空树，所以1乘1还是1。那么n = 2时，由于1和2都可以为跟，分别算出来，再把它们加起来即可。n = 2的情况可由下面式子算出：
     *
     * dp[2] =  dp[0] * dp[1]　　　(1为根的情况)
     *
     *        + dp[1] * dp[0]　　  (2为根的情况)
     *
     * 同理可写出 n = 3 的计算方法：
     *
     * dp[3] =  dp[0] * dp[2]　　　(1为根的情况)
     *
     *       + dp[1] * dp[1]　　  (2为根的情况)
     *
     *       + dp[2] * dp[0]　　  (3为根的情况)
     *
     *  这道题实际上是 Catalan Number卡塔兰数的一个例子
     *
     * @param n
     * @return
     */
    public int numTrees(int n) {
        //数字i有res[i]个不同二叉查找树
        int[] res = new int[n+1];
        res[0] = 1;
        res[1] = 1;

        for(int i = 2; i <= n; i++){
            for(int j = 0; j < i; j++){
                res[i] += res[j]*res[i-j-1];
            }
        }

        return res[n];
    }


}
