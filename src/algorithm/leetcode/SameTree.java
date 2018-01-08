package algorithm.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/************************************************************************************
 * 功能描述：
 *
 * Given two binary trees, write a function to check if they are the same or not.
 *
 * Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
 *
 *
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2018年01月08日 --  上午9:35 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class SameTree {

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
     * 非递归：
     *
     * 思想就是层序遍历，比较每一个节点
     *
     * 这里用的是队列（层序遍历），也可以采用栈的形式
     *
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {

        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();

        if(p != null){
            queue1.offer(p);
        }

        if(q != null){
            queue2.offer(q);
        }

        while (!queue1.isEmpty() && !queue2.isEmpty()){
            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();

            if(node1.val != node2.val){
                return false;
            }

            int flagLeft = 0;
            int flagRight = 0;

            if(node1.left != null){
                queue1.offer(node1.left);
                flagLeft++;
            }

            if(node1.right != null){
                queue1.offer(node1.right);
                flagRight++;
            }

            if(node2.left != null){
                queue2.offer(node2.left);
                flagLeft++;
            }

            if(node2.right != null){
                queue2.offer(node2.right);
                flagRight++;
            }

            if(!(flagLeft == 0 || flagLeft == 2)){
                return false;
            }

            if(!(flagRight == 0 || flagRight == 2)){
                return false;
            }
        }

        return queue1.isEmpty() && queue2.isEmpty();
    }

    /**
     *
     * 递归的写法
     *
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree2(TreeNode p, TreeNode q) {
        if(p == null || q == null){
            return p == q;
        }

        return p.val == q.val && isSameTree2(p.left, q.left) && isSameTree2(p.right, q.right);
    }


}
