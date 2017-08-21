package algorithm.java;

import org.junit.Test;

import java.util.Stack;

/************************************************************************************
 * 功能描述：
 *
 * 二叉树的定义和遍历
 *
 * 二叉树的性质：每个节点至多有两个分支（子节点），分支具有左右次序，不能颠倒。
 *
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2017年08月18日 --  下午10:32 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class BinaryTree {

    //根节点
    private Node root;


    //树的节点定义
    public static class Node {
        int data;//该节点上存放的数据
        Node left;//左子节点
        Node right;//右子节点

        public Node(int data) {
            this.data = data;
        }
    }

    public void relation(Node parent, Node left, Node right){
        parent.left = left;
        parent.right = right;
    }

    /**
     * 访问某结点
     *
     * @param node
     */
    public void visit(Node node) {
        System.out.print(node.data);
    }


    /**
     * 前序遍历：根-左-右
     * <p>
     * 递归实现
     *
     * @param root 二叉树的根节点
     */
    public void preOrderRect(Node root) {
        if (root != null) {
            visit(root);
            preOrderRect(root.left);
            preOrderRect(root.right);
        }
    }


    /**
     * 中序遍历：左-根-右
     * <p>
     * 递归实现
     *
     * @param root 二叉树的根节点
     */
    public void inOrderRect(Node root) {
        if (root != null) {
            inOrderRect(root.left);
            visit(root);
            inOrderRect(root.right);
        }
    }

    /**
     * 后序遍历：左-右-根
     * <p>
     * 递归实现
     *
     * @param root 二叉树的根节点
     */
    public void postOrderRect(Node root) {
        if (root != null) {
            postOrderRect(root.left);
            postOrderRect(root.right);
            visit(root);
        }
    }


    /**
     * 前序遍历：根-左-右
     * <p>
     * 非递归实现，借助栈来实现
     *
     * @param root
     */
    public void preOrder(Node root) {
        Stack<Node> stack = new Stack<>();
        if (root != null) {
            stack.push(root);
            while (!stack.empty()) {
                root = stack.pop();
                visit(root);
                if (root.right != null) {
                    stack.push(root.right);
                }
                if (root.left != null) {
                    stack.push(root.left);
                }
            }
        }
    }

    /**
     * 前序遍历：根-左-右
     * <p>
     * 非递归实现，借助栈来实现
     * <p>
     * 第二种实现方式
     *
     * @param root
     */
    public void preOrder2(Node root) {
        Stack<Node> stack = new Stack<>();
        while ((root != null) || (!stack.isEmpty())) {
            //将所有左子节点入栈，在入栈之前访问
            while (root != null) {
                visit(root);
                stack.push(root);
                root = root.left;
            }

            //出栈，并将根设置为右子节点
            if (!stack.isEmpty()) {
                root = stack.pop();
                root = root.right;
            }
        }
    }

    /**
     * 中序遍历：左-根-右
     * <p>
     * 非递归实现：借助栈来实现
     *
     * @param root 二叉树的根节点
     */
    public void inOrder(Node root) {
        Stack<Node> stack = new Stack<>();
        while ((root != null) || (!stack.isEmpty())) {
            //从某一节点开始，将该节点以及该节点的左子节点入栈
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            //出栈，并访问，并将根设为右子节点，进入最外while循环
            if (!stack.isEmpty()) {
                root = stack.pop();
                visit(root);
                root = root.right;
            }
        }
    }

    /**
     * 后序遍历：左-右-根
     * <p>
     * 非递归实现：借助栈来实现
     *
     * @param root 二叉树的根节点
     */
    public void postOrder(Node root) {
        Stack<Node> stack = new Stack<>();
        Node prev = root;
        while ((root != null) || (!stack.isEmpty())) {
            //从某一节点开始，将该节点以及该节点的左子节点入栈
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            if (!stack.isEmpty()) {
                Node temp = stack.peek().right;
                if (temp == null || temp == prev) {
                    root = stack.pop();
                    visit(root);
                    prev = root;
                    root = null;
                } else {
                    root = temp;
                }
            }
        }
    }

    /**
     * 后序遍历：左-右-根
     * <p>
     * 非递归实现：借助栈来实现
     *
     * 第二种实现方式
     *
     * @param root 二叉树的根节点
     */
    public void postOrder2(Node root) {
        Stack<Node> stack = new Stack<>();
        Stack<Node> temp = new Stack<Node>();//保存所有的节点，入栈顺序为根-右-左
        while ((root != null) || (!stack.isEmpty())) {
            while (root != null){
                temp.push(root);
                stack.push(root);
                root = root.right;
            }
            if(!stack.isEmpty()){
                root = stack.pop();
                root = root.left;
            }
        }
        //遍历temp，出栈顺序为左-右-根
        while(!temp.isEmpty()){
            root = temp.pop();
            visit(root);
        }
    }

    @Test
    public void test(){
        /**
         *
         *          1
         *
         *     2         3
         * 4       5
         *      6     7
         * 前序：1-2-4-5-6-7-3
         * 中序：4-2-6-5-7-1-3
         * 后序：4-6-7-5-2-3-1
         *
         *
         */
        Node root = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        relation(root, node1, node2);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        relation(node1, node3, node4);
        Node node5 = new Node(6);
        Node node6 = new Node(7);
        relation(node4, node5, node6);

        //前序
        preOrderRect(root);
        System.out.println();
        preOrder(root);
        System.out.println();
        preOrder2(root);
        System.out.println();

        //中序
        inOrderRect(root);
        System.out.println();
        inOrder(root);
        System.out.println();


        //后序
        postOrderRect(root);
        System.out.println();
        postOrder(root);
        System.out.println();
        postOrder2(root);

        //测试结果
        /*
            1245673
            1245673
            1245673
            4265713
            4265713
            4675231
            4675231
            4675231
       */
    }

}
