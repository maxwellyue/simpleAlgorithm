package algorithm.leetcode;

/************************************************************************************
 * 功能描述：
 *
 *
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 *
 * Example:
 * Given a binary tree
 *      1
 *     / \
 *    2   3
 *   / \
 *  4   5
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 *
 * Note: The length of path between two nodes is represented by the number of edges between them.
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2018年01月04日 --  下午8:24 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class DiameterOfBinaryTree {

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
     * http://blog.csdn.net/u012814856/article/details/76212141
     *
     * 递归的奥妙
     *
     * 这个问题可以分两个方面来考虑：
     * 1. 最长路径经过根节点：那么根节点的左子树的深度和右子树的深度就是我们的结果
     * 2. 最长路径没有经过根节点：这个问题就分为两个子问题，分别设置新的根节点为其左子节点和右子节点，然后重复步骤 1
     *
     *
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }

        //最长路径经过根节点的情况：
        int result1 = depthOfBinaryTree(root.left) + depthOfBinaryTree(root.right);

        //最长路径不经过根节点的情况：
        int result2 = Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right));

        return Math.max(result1, result2);
    }

    private int depthOfBinaryTree(TreeNode root){
        if(root == null){
            return 0;
        }
        return Math.max(depthOfBinaryTree(root.left), depthOfBinaryTree(root.right)) + 1;
    }
}
