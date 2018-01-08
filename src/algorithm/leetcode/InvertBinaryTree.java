package algorithm.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/************************************************************************************
 * 功能描述：
 *
 * Invert a binary tree.
 *            4
 *          /   \
 *         2     7
 *        / \   / \
 *       1  3  6   9
 * to
 *            4
 *          /   \
 *         7     2
 *        / \   / \
 *       9  6  3   1
 *
 * Trivia:
 * This problem was inspired by this original tweet by Max Howell:
 * Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree on a whiteboard so fuck off.
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2018年01月08日 --  上午10:55 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class InvertBinaryTree {

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
     * 递归解法
     *
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {

        if(root != null){
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            invertTree(root.left);
            invertTree(root.right);
        }

        return root;
    }

    /**
     * 非递归解法
     *
     * 层序遍历
     *
     *
     * @param root
     * @return
     */
    public TreeNode invertTree2(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null){
            queue.add(root);
        }

        //"交换子节点"和"子节点入队"这两个操作的顺序并不影响结果
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();

            //交换子节点
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            //子节点入队
            if(node.left != null){
                queue.offer(node.left);
            }
            if(node.right != null){
                queue.offer(node.right);
            }
        }

        return root;
    }


}
