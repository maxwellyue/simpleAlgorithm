package algorithm.leetcode;

import java.util.Stack;

/************************************************************************************
 * 功能描述：
 *
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2018年01月11日 --  下午7:06 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class ValidateBinarySearchTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 判断是否为平衡树
     *
     * 就是中序遍历
     *
     *
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        TreeNode prev = null;
        while (!stack.isEmpty() || node != null){
            while (node != null){
                stack.push(node);
                node = node.left;
            }
            if(!stack.isEmpty()){
                node = stack.pop();
                if(prev != null && prev.val >= node.val){
                    return false;
                }
                prev = node;
                node = node.right;
            }
        }
        return true;
    }


    /**
     *
     * 递归写法
     *
     * 来自：https://leetcode.com/problems/validate-binary-search-tree/discuss/32109
     *
     * @param root
     * @return
     */
    public boolean isValidBST2(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null) return true;
        if (root.val >= maxVal || root.val <= minVal) return false;
        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
    }
}
