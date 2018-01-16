package algorithm.leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/************************************************************************************
 * 功能描述：
 *
 * Given a binary tree, flatten it to a linked list in-place.
 *
 * For example,
 * Given
 *
 *          1
 *         / \
 *        2   5
 *       / \   \
 *      3  4   6
 *
 * The flattened tree should look like:
 *        1
 *         \
 *          2
 *           \
 *            3
 *             \
 *              4
 *               \
 *                5
 *                 \
 *                  6
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2018年01月16日 --  下午2:42 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class FlattenBinaryTreeToLinkedList {

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
     * 先序遍历
     * <p>
     * 但是感觉不符合in-place这个要求
     *
     * @param root
     */
    public void flatten(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }

        TreeNode node = root;
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        //先序遍历，将遍历的结点依次保存在队列中
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                queue.offer(node);
                node = node.left;
            }

            if (!stack.isEmpty()) {
                node = stack.pop();
                node = node.right;
            }
        }
        //将队列中的结点取出，并指定其左右节点
        node = root;
        while (!queue.isEmpty() && node != null) {
            node.right = queue.poll();
            node.left = null;
            node = node.right;
        }
    }


    /**
     * 来自：https://leetcode.com/problems/flatten-binary-tree-to-linked-list/discuss/36991
     * <p>
     * 很巧妙
     *
     * @param root
     */
    public void flatten2(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stk = new Stack<TreeNode>();
        stk.push(root);
        while (!stk.isEmpty()) {
            TreeNode curr = stk.pop();
            if (curr.right != null)
                stk.push(curr.right);
            if (curr.left != null)
                stk.push(curr.left);
            if (!stk.isEmpty())
                curr.right = stk.peek();
            curr.left = null;  // dont forget this!!
        }
    }

    /**
     *
     * 得票最高的解法
     *
     * todo 未理解
     *
     */
    private TreeNode prev = null;
    public void flatten3(TreeNode root) {
        if (root == null)
            return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
}
