package algorithm.leetcode;

import java.util.Stack;

/************************************************************************************
 * 功能描述：
 *
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 *
 *              1
 *             / \
 *            2   2
 *           / \ / \
 *          3  4 4  3
 * But the following [1,2,2,null,3,null,3] is not:
 *              1
 *             / \
 *            2   2
 *            \   \
 *            3    3
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2018年01月08日 --  下午3:38 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class SymmetricTree {


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
     * 来自：https://leetcode.com/problems/symmetric-tree/discuss/33054
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        return root == null || isSymmetricHelper(root.left, root.right);
    }

    public boolean isSymmetricHelper(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == right;
        }

        if (left.val != right.val) {
            return false;
        }

        return isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right, right.left);
    }


    /**
     * 非递归
     *
     * 来自：https://leetcode.com/problems/symmetric-tree/solution/
     *
     * @param root
     * @return
     */
    public boolean isSymmetric2(TreeNode root) {
        if (root == null) {
            return true;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);

        while (!stack.isEmpty()) {
            TreeNode left = stack.pop();
            TreeNode right = stack.pop();

            if (left == null && right == null) {
                continue;
            }

            if (left == null || right == null || left.val != right.val) {
                return false;
            }

            stack.push(left.left);
            stack.push(right.right);
            stack.push(left.right);
            stack.push(right.left);
        }
        return true;
    }


}
