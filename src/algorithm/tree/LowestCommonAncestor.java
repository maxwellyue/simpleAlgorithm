package algorithm.tree;

/************************************************************************************
 * 功能描述：
 *
 * 最近公共祖先问题
 *
 * 最近公共祖先简称LCA（Lowest Common Ancestor），
 * 所谓LCA，是当给定一个有根树T时，对于任意两个结点u、v，找到一个离根最远的结点x，
 * 使得x同时是u和v的祖先，x 便是u、v的最近公共祖先。
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2017年08月16日 --  下午9:12 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class LowestCommonAncestor {


    /**
     *
     * 如果数为二叉查找树：
     *
     * 二叉查找树的性质：节点值的大小关系满足：左<根<右
     *
     * 那么从树根开始：（）
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
        int left = node1.value > node2.value ? node2.value : node1.value;
        int right = node1.value > node2.value ? node1.value : node2.value;

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

}
