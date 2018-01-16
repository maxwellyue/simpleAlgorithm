package algorithm.leetcode;

/************************************************************************************
 * 功能描述：
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2018年01月16日 --  上午8:46 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class BinaryTreeMaximumPathSum {

    //difinition
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }



    int max = Integer.MIN_VALUE;

    /**
     *
     * 求最大路径和
     *
     * 基本思想是：
     * 遍历每个节点，并将该节点作为子树的根，求该子树的左、右子树的最大路径和
     * 并保持更新最大值
     *
     * 来自：https://leetcode.com/problems/binary-tree-maximum-path-sum/discuss/39875
     *
     * @param root
     * @return
     */
    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }

    // helper returns the max branch
    // plus current node's value
    int helper(TreeNode root) {
        if (root == null) return 0;

        //注意，左右子树并不是helper(root.left)，而是Math.max(helper(root.left), 0)
        //因为子树有可能最后是负数，此时，直接舍弃为负数的结点即可，即可保持最大
        int left = Math.max(helper(root.left), 0);
        int right = Math.max(helper(root.right), 0);

        max = Math.max(max, root.val + left + right);

        //返回当前节点的一个分值的最大路径值和当前节点的值
        //这样，在计算下一个节点的时候，可以直接直接使用
        return root.val + Math.max(left, right);
    }

}
