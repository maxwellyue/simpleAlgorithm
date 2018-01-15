package algorithm.leetcode;

/************************************************************************************
 * 功能描述：
 *
 * Implement a trie with insert, search, and startsWith methods.
 *
 * Note:
 * You may assume that all inputs are consist of lowercase letters a-z.
 *
 *
 *
 * 实现数据结构-字典树， 又称前缀树或单词查找树
 *
 * 什么是字典树：http://dongxicheng.org/structure/trietree/
 *
 * Trie树的基本性质可以归纳为：
 *
 * （1）根节点不包含字符，除根节点意外每个节点只包含一个字符。
 *
 * （2）从根节点到某一个节点，路径上经过的字符连接起来，为该节点对应的字符串。
 *
 * （3）每个节点的所有子节点包含的字符串不相同。
 *
 *
 *
 *
 *
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2018年01月15日 --  下午3:28 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class Trie {

    //字典树的根
    Node root;


    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new Node(' ');
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (node.children == null) {
                node.children = new Node[26];
            }

            if (node.children[index] == null) {
                node.children[index] = new Node(c);
            }
            node = node.children[index];
        }
        node.end = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        if (word == null || word.length() == 0) {
            return true;
        }

        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (node.children == null || node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }

        return node.end;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.length() == 0) {
            return true;
        }

        Node node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            int index = c - 'a';
            if (node.children == null || node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }

        return true;
    }


    class Node {
        char value;
        Node[] children;
        boolean end;//已该字符结尾的单词是否存在

        Node(char value) {
            this.value = value;
        }
    }

}

//最初版本的代码：可以通过leetcode
//插入、查找时间复杂度均为：O(n)
//但是空间复杂度太高：O(26^(n-1))


////字典树的根
//    Node root;
//
//
//    /**
//     * Initialize your data structure here.
//     */
//    public Trie() {
//        root = new Node(null);
//    }
//
//    /**
//     * Inserts a word into the trie.
//     */
//    public void insert(String word) {
//        Node node = root;
//        for (int i = 0; i < word.length(); i++) {
//            char c = word.charAt(i);
//            int index = c - 'a';
//            if (node.children == null) {
//                node.children = new Node[26];
//            }
//
//            if (node.children[index] == null) {
//                node.children[index] = new Node(c);
//            }
//            node = node.children[index];
//
//            if(i == word.length() - 1){
//                node.end = true;
//            }
//        }
//    }
//
//    /**
//     * Returns if the word is in the trie.
//     */
//    public boolean search(String word) {
//        if(word == null || word.length() == 0){
//            return true;
//        }
//
//        Node node = root;
//        for (int i = 0; i < word.length(); i++) {
//            char c = word.charAt(i);
//            int index = c - 'a';
//            if (node.children == null || node.children[index] == null) {
//                return false;
//            }
//            node = node.children[index];
//            if(i == word.length() - 1 && !node.end){
//                return false;
//            }
//        }
//
//        return true;
//    }
//
//    /**
//     * Returns if there is any word in the trie that starts with the given prefix.
//     */
//    public boolean startsWith(String prefix) {
//        if(prefix == null || prefix.length() == 0){
//            return true;
//        }
//
//        Node node = root;
//        for (int i = 0; i < prefix.length(); i++) {
//            char c = prefix.charAt(i);
//            int index = c - 'a';
//            if (node.children == null || node.children[index] == null) {
//                return false;
//            }
//            node = node.children[index];
//        }
//
//        return true;
//    }
//
//
//    class Node {
//        Character value;
//        Node[] children;
//        boolean end;//已该字符结尾的单词是否存在
//        Node(Character value) {
//            this.value = value;
//        }
//    }
