package algorithm.java;

/************************************************************************************
 * 功能描述：
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2017年08月18日 --  下午10:32 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class BinaryTree {

    //根节点
    private TreeNode root;



    //树的节点定义
    public static class TreeNode{
        Object data;//该节点上存放的数据
        TreeNode leftNode;//左子节点
        TreeNode rightNode;//右子节点

        public TreeNode(Object data){
            this.data  = data;
        }
    }


    public BinaryTree build(){
        return new BinaryTree();
    }



}
