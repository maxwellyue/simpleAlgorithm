package algorithm.leetcode;

/************************************************************************************
 * 功能描述：
 *
 * Given a binary tree, determine if it is height-balanced.
 *
 * For this problem,
 * a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more than 1.
 *
 *
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2018年01月09日 --  上午11:21 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class BalancedBinaryTree {


    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    /**
     * 两遍递归
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (Math.abs(depth(root.left) - depth(root.right)) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(depth(node.left), depth(node.right)) + 1;
    }


    /**
     * 只需要一遍递归
     */
    private boolean res = true;

    public boolean isBalanced2(TreeNode root) {
        depth2(root);
        return res;
    }

    private int depth2(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftDept = depth2(node.left);
        int rightDept = depth2(node.right);

        if (Math.abs(leftDept - rightDept) > 1) {
            res = false;
        }
        return Math.max(leftDept, rightDept) + 1;
    }
}
