package algorithm.leetcode;

/************************************************************************************
 * 功能描述：
 * Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.
 *
 * Example 1:
 * Given tree s:
 *
 *     3
 *    / \
 *   4   5
 *  /     \
 * 1       2
 * Given tree t:
 *    4
 *   / \
 *  1   2
 * Return true, because t has the same structure and node values with a subtree of s.
 *
 * Example 2:
 * Given tree s:
 *
 *       3
 *      / \
 *     4   5
 *    /     \
 *   1       2
 *  /
 * 0
 * Given tree t:
 *    4
 *   / \
 *  1   2
 * Return false.
 *
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2018年01月04日 --  下午8:14 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class SubTreeOfAnotherTree {


    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        if (isSame(s, t)) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }


    /**
     * 根节点相同，且左右子树相同，则相同
     * @param s
     * @param t
     * @return
     */
    private boolean isSame(TreeNode s, TreeNode t) {
        if(s==null||t==null)return s==t;
        if (s.val != t.val) return false;
        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }


}
