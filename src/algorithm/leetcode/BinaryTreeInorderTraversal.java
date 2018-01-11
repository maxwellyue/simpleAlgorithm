package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/************************************************************************************
 * 功能描述：
 *
 * Given a binary tree, return the inorder traversal of its nodes' values.
 *
 * For example:
 * Given binary tree [1,null,2,3],
 *       1
 *       \
 *        2
 *       /
 *      3
 * return [1,3,2].
 *
 * Note: Recursive solution is trivial, could you do it iteratively?
 *
 * 中序遍历
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2018年01月11日 --  下午4:08 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class BinaryTreeInorderTraversal {


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
     * 中序遍历递归写法
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traversal(root, res);
        return res;
    }

    private void traversal(TreeNode root, List<Integer> res) {
        if(root == null){
            return;
        }

        traversal(root.left, res);
        res.add(root.val);
        traversal(root.right, res);
    }

    /**
     *
     * 中序遍历非递归写法
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode node = root;
        while (node != null || !stack.isEmpty()){
            while (node != null){
                stack.push(node);
                node = node.left;
            }

            if(!stack.isEmpty()){
                node = stack.pop();
                res.add(node.val);
                node = node.right;
            }
        }

        return res;
    }

}
