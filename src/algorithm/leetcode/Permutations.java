package algorithm.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/************************************************************************************
 * 功能描述：
 *
 * Given a collection of distinct numbers, return all possible permutations.
 *
 * For example,
 * [1,2,3] have the following permutations:
 * [
 *  [1,2,3],
 *  [1,3,2],
 *  [2,1,3],
 *  [2,3,1],
 *  [3,1,2],
 *  [3,2,1]
 * ]
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2018年01月12日 --  下午2:40 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class Permutations {

    /**
     * 直接循环拼接
     * <p>
     * <p>
     * 来自：https://leetcode.com/problems/permutations/discuss/18255
     * <p>
     * 思路：
     * 遍历nums（第一个for loop），
     * 当进行nums[i]时，res中的结果是数字nums[0,i-1]的全排列。
     * 每一次循环中，需要将nums[i]加入到res中的每一个结果中的每一个位置，然后开始下一次循环。
     * 具体做法是，
     * 每一次循环开始，先记录当前res的大小（size），
     * 取出res中的第一个组合，在这个组合的每个位置添加nums[i]，形成新的组合，然后加到res末尾，
     * 一共进行size次（第二个for loop）。
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        res.add(new LinkedList<>());

        for (int n : nums) {
            int size = res.size();
            for (; size > 0; size--) {
                List<Integer> list = res.pollFirst();
                //注意，这里i <= list.size()，因为可以插到最后
                for (int i = 0; i <= list.size(); i++) {
                    LinkedList<Integer> com = new LinkedList<>(list);
                    com.add(i, n);
                    res.add(com);
                }
            }
        }

        return res;
    }

    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), nums);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            res.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (tempList.contains(nums[i])) {
                    continue;// element already exists, skip
                }
                tempList.add(nums[i]);
                backtrack(res, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }


    /**
     * 全排列的结果：n个数字则有n
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute3(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // Arrays.sort(nums); // not necessary
        backtrack(res, new ArrayList<>(), nums);
        return res;
    }

    @Test
    public void test(){
        int[] a = {1,2,3,4,5,6};
        permute2(a);
    }
}
