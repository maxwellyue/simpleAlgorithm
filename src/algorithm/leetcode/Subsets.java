package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/************************************************************************************
 * 功能描述：
 *
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * For example,
 * If nums = [1,2,3], a solution is:
 *
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 *
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2018年01月10日 --  下午1:06 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class Subsets {

    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for(int i = 0; i < nums.length; i++){
            for(int j = i; j < nums.length; j++){
                List<Integer> list = new ArrayList<>();
                for(int k = i; k <= j; k++){
                    list.add(nums[k]);
                }
                res.add(list);
            }
        }
        return res;
    }

    /**
     *
     * 起始subset集为：[]
     * 添加S0后为：[], [S0]
     * 添加S1后为：[], [S0], [S1], [S0, S1]
     * 添加S2后为：[], [S0], [S1], [S0, S1], [S2], [S0, S2], [S1, S2], [S0, S1, S2]
     * 红色subset为每次新增的。显然规律为添加Si后，新增的subset为克隆现有的所有subset，并在它们后面都加上Si。
     *
     * 每次都是前一次的两倍
     *
     *
     * 来自：https://leetcode.com/problems/subsets/discuss/27279
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());

        for(int n : nums){
            List<List<Integer>> temp = new ArrayList<>();
            for(List<Integer> sub : res){
                List<Integer> list = new ArrayList<>(sub);
                list.add(n);
                temp.add(list);
            }
            res.addAll(temp);
        }

        return res;
    }


}
