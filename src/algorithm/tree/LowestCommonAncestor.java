package algorithm.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/************************************************************************************
 * 功能描述：
 *
 * 最近公共祖先问题
 *
 * 最近公共祖先简称LCA（Lowest Common Ancestor），
 * 所谓LCA，是当给定一个有根树T时，对于任意两个结点u、v，找到一个离根最远的结点x，
 * 使得x同时是u和v的祖先，x 便是u、v的最近公共祖先。
 *
 * 此类问题的变种：求树上两个节点的最近距离
 * 其实也是求最近公共祖先，求出最近祖先节点之后，
 * 由最近祖先节点到这两个节点的距离之和就是两个节点的最近距离
 *
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2017年08月16日 --  下午9:12 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class LowestCommonAncestor {

    public static class Node {
        Node left;
        Node right;
        Object object;
        int value;//编号
    }

    /**
     *
     * 如果树为二叉查找树，并已知根节点
     *
     * 二叉查找树的性质：节点值的大小关系满足：左<根<右
     *
     * 那么从树根开始：
     *
     * ①如果当前结点t 小于结点u、v，说明u、v都在t 的右侧，所以它们的共同祖先必定在t 的右子树中，故从t 的右子树中继续查找；
     * ②如果当前结点t 满足 u <t < v，说明u和v分居在t 的两侧，故当前结点t 即为最近公共祖先；
     * ③而如果u是v的祖先，那么返回u的父结点，同理，如果v是u的祖先，那么返回v的父结点。
     *
     * @param root 树的根节点
     * @param node1
     * @param node2
     * @return
     */
    public Node getLCA1(Node root, Node node1, Node node2){
        //计算出这两个节点的值
        int left = node1.value > node2.value ? node2.value : node1.value;
        int right = node1.value > node2.value ? node1.value : node2.value;
        //根据注释中的关系，进行迭代
        while (true){
            if(root.value < left){
                root = root.right;
            }else if(root.value > right){
                root = root.left;
            }else {
                return root;
            }
        }
    }

    /**
     *
     * 如果树为普通二叉查找树，并已知根节点
     *
     * 二叉树的性质：只知道节点间的关系
     *
     *
     * 递归入口：以root为根节点寻找node1和node2的公共祖先
     * 递归出口为：node1或者node2成为了根节点（子树的），或者已经到了最底层还没有遇到node1或者node2；
     *
     * @param root 树的根节点
     * @param node1
     * @param node2
     * @return
     */
    public Node getLCA2(Node root, Node node1, Node node2){

        if(root == null || root == node1 || root == node2){
            return root;
        }

        //以root.left为根节点进行递归寻找
        Node left = getLCA2(root.left, node1, node2);
        //以root.right为根节点进行递归寻找
        Node right = getLCA2(root.right, node1, node2);

        if(left != null && right != null){
            return root;
        }else if(left != null){
            return left;
        }else if(right != null){
            return right;
        }else {
            return null;
        }
    }

    /**
     *
     * 如果树为普通二叉查找树，并已知根节点
     *
     * 二叉树的性质：只知道节点间的关系
     *
     * 最原始的想法：从根节点出发，分两路向node1和node2前进（前序遍历），将经过的结点各自保存在数组中
     * 然后从两个数组中找到最后一个相同的节点，该节点即为最近公共祖先
     *
     * @param root 树的根节点
     * @param node1
     * @param node2
     * @return
     */
    public Node getLCA3(Node root, Node node1, Node node2){

        //保存根节点到node1的路径
        List<Node> pathList1 = new ArrayList<>();
        //保存根节点到node2的路径
        List<Node> pathList2 = new ArrayList<>();

        boolean passNode1 = false;
        boolean passNode2 = false;

        //前序遍历用，即借助Stack对树进行前序遍历（直到遇到node1和node2）
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while ((root != null) && (!stack.isEmpty()) && ((!passNode1) || (!passNode2)) ){
            while(root != null){

                if(!passNode1) {
                    pathList1.add(root);
                }

                if(!passNode2){
                    pathList2.add(root);
                }

                if(root.equals(node1)){
                    passNode1 = true;
                }
                if(root.equals(node2)){
                    passNode2 = true;
                }

                stack.push(root);
                root = root.left;
            }

            if(!stack.isEmpty()){
                stack.pop();
                root = root.right;
            }
        }

        //找到两个路径中最后一个相同的结点
        if(!pathList1.isEmpty() && !pathList2.isEmpty()){
            int size = pathList1.size() > pathList2.size() ? pathList2.size() : pathList1.size();
            for(int i = 0; i < size; i++){
                if(!pathList1.get(i).equals(pathList2.get(i))){
                    return pathList1.get((i-1 >= 0) ? (i-1) : 0);
                }
            }
        }

        return null;
    }


    /**
     *
     * 如果树为普通二叉查找树，并已知根节点
     *
     * Tarjan算法
     *
     * 该算法基于深度优先搜索
     *
     * 对于新搜索到的一个结点u，先创建由u构成的集合，再对u的每颗子树进行搜索，
     * 每搜索完一棵子树，这时候子树中所有的结点的最近公共祖先就是u了。
     *
     * @return
     */
    public Node getLCA3(){

        // TODO: 2017/8/24 待研究
        return null;
    }



}
