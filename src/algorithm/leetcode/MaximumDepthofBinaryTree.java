package algorithm.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/************************************************************************************
 * 功能描述：
 *
 * Given a binary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2018年01月08日 --  上午10:21 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class MaximumDepthofBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

    }

    /**
     * 递归写法
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    /**
     *
     * 非递归写法
     *
     * 思想：
     * 层序遍历，
     * 最外层while循环：每次循环一层
     * 内层while循环：将当前层的结点出队，将当前层的下一层的结点全部入队
     *
     * @param root
     * @return
     */
    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            //当前层节点的数量
            int curLevelNodeCount = queue.size();
            //已经遍历的当前层的节点数
            int count = 0;
            while (count < curLevelNodeCount){
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
                count++;
            }
            //至此，当前层已经遍历结束
            depth++;
        }

        return depth;
    }
}
