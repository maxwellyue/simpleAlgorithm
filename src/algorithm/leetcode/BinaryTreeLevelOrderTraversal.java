package algorithm.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/************************************************************************************
 * 功能描述：
 *
 *
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *          3
 *         / \
 *        9  20
 *          /  \
 *         15   7
 * return its level order traversal as:
 *  [
 *   [3],
 *   [9,20],
 *   [15,7]
 *  ]
 *
 * 二叉树层序遍历
 *
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2018年01月12日 --  下午6:45 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class BinaryTreeLevelOrderTraversal {


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
     * 借助队列
     *
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null){
            queue.offer(root);
        }

        while (!queue.isEmpty()){
            List<Integer> level = new LinkedList<>();
            int size = queue.size();
            int i = 0;
            while (i < size){
                TreeNode node = queue.poll();
                i++;
                level.add(node.val);
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            res.add(level);
        }
        return res;
    }
}
