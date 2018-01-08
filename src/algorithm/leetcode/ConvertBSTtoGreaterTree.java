package algorithm.leetcode;

import java.util.Stack;

/************************************************************************************
 * 功能描述：
 *
 * Given a Binary Search Tree (BST), convert it to a Greater Tree such that
 *
 * every key of the original BST
 *
 * is changed to
 *
 * the original key plus sum of all keys greater than the original key in BST.
 *
 * Example:
 *
 * Input: The root of a Binary Search Tree like this:
 *          5
 *        /   \
 *      2     13
 *
 * Output: The root of a Greater Tree like this:
 *         18
 *        /   \
 *      20     13
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2018年01月08日 --  上午11:20 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class ConvertBSTtoGreaterTree {


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
     *
     * 先遍历右节点的中序遍历
     *
     * @param root
     * @return
     */
    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.right;
            }
            cur = stack.pop();
            cur.val += sum;
            sum = cur.val;
            cur = cur.left;
        }
        return root;
    }



    int sum = 0;

    /**
     *
     * 递归解法
     *
     * @param root
     * @return
     */
    public TreeNode convertBST2(TreeNode root) {
        if(root == null){
            return null;
        }
        convertBST(root.right);

        root.val += sum;
        sum = root.val;

        convertBST(root.left);
        return root;
    }


    private void convert(TreeNode cur) {
        if (cur == null) return;
        convert(cur.right);
        cur.val += sum;
        sum = cur.val;
        convert(cur.left);
    }


}
