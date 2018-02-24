package algorithm.leetcode;

import java.util.*;

/************************************************************************************
 * 功能描述：
 *
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 *
 * For example,
 * [1,1,2] have the following unique permutations:
 *   [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 *   ]
 *
 *
 * 创建人：岳增存  yueyuemax@gmail.com
 * 创建时间： 2018年02月24日 --  下午1:18 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class PermutationsII {

    /**
     * 与Permutations思路一致，直接拼接，
     * 最后，对结果进行去重处理
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        res.add(new LinkedList<>());
        for (int n : nums) {
            int size = res.size();
            for (; size > 0; size--) {
                List<Integer> list = res.pollFirst();
                for (int i = 0; i <= list.size(); i++) {
                    LinkedList<Integer> combination = new LinkedList<>(list);
                    combination.add(i, n);
                    res.add(combination);
                }
            }
        }
        //去重
        return new ArrayList<>(new HashSet<>(res));
    }


    /**
     * 来源：https://leetcode.com/problems/permutations-ii/discuss/18594/Really-easy-Java-solution-much-easier-than-the-solutions-with-very-high-vote
     *
     *
     * Use an extra boolean array " boolean[] used" to indicate whether the value is added to list.
     *
     * Sort the array “int[] nums” to make sure we can skip the same value.
     *
     * when a number has the same value with its previous, we can use this number only if his previous is used
     *
     *
     * todo :未理解剪枝条件
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique2(int[] nums) {

        List<List<Integer>> res = new ArrayList<List<Integer>>();

        if (nums == null || nums.length == 0) {
            return res;
        }

        boolean[] used = new boolean[nums.length];

        Arrays.sort(nums);

        dfs(nums, used, new ArrayList<>(), res);

        return res;
    }

    public void dfs(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> res) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<Integer>(list));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i]) {
                    continue;
                }
                if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) {
                    continue;
                }

                used[i] = true;
                list.add(nums[i]);
                dfs(nums, used, list, res);
                used[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}
