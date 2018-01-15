package algorithm.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/************************************************************************************
 * 功能描述：
 *
 * You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].
 *
 * Example:
 *
 * Given nums = [5, 2, 6, 1]
 *
 * To the right of 5 there are 2 smaller elements (2 and 1).
 * To the right of 2 there is only 1 smaller element (1).
 * To the right of 6 there is 1 smaller element (1).
 * To the right of 1 there is 0 smaller element.
 * Return the array [2, 1, 1, 0].
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2018年01月15日 --  下午4:50 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class CountSmallerNumbersAfterSelf {

    /**
     * 暴力循环
     *
     *
     * 时间复杂度O(n^2)
     * 空间复杂度O(n)
     *
     * 无法通过LeetCode， Time Limit Exceeded
     *
     * @param nums
     * @return
     */
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }

        for (int i = 0; i < nums.length; i++) {
            int smaller = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    smaller++;
                }
            }
            res.add(smaller);
        }

        return res;
    }

    /**
     *
     * 时间复杂度O(nlog(n))
     * 空间复杂度O(n)
     *
     * @param nums
     * @return
     */
    public List<Integer> countSmaller2(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Node node = new Node(nums[nums.length - 1]);
        res.add(0);
        for (int i = nums.length - 2; i >= 0; i--) {
            int count = insert(node, nums[i]);
            res.add(count);
        }
        Collections.reverse(res);
        return res;
    }

    /**
     * 将value插入到树上，并返回树上比value小的结点个数
     *
     * 即构建二分查找树
     *
     *
     * @param root
     * @param value
     * @return
     */
    private int insert(Node root, int value){
        Node node = root;
        int count = 0;
        while (true){
            if(value > node.value){
                count = count + node.count;
                if(node.right == null) {
                    node.right = new Node(value); break;
                } else {
                    node = node.right;
                }
            }else {
                node.count++;
                if(node.left == null) {
                    node.left = new Node(value); break;
                } else {
                    node = node.left;
                }
            }
        }
        return count;
    }

    /**
     *
     * 建立二分查找树使用的结点数据结构
     */
    class Node{
        int value;
        int count = 1;
        Node left;
        Node right;

        Node(int value){
            this.value = value;
        }
    }

}
