package algorithm.leetcode;

import java.util.*;

/************************************************************************************
 * 功能描述：
 *
 * Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 *
 * The same repeated number may be chosen from C unlimited number of times.
 *
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set [2, 3, 6, 7] and target 7,
 * A solution set is:
 * [
 * [7],
 * [2, 2, 3]
 * ]
 *
 *
 * 动态规划问题，与换硬币问题类似
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2018年01月04日 --  下午7:03 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class CombinationSum {

    /**
     * 来自：https://segmentfault.com/a/1190000003743112
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(candidates);

        combinationSumRec(candidates, 0, target, res, new LinkedList<>());

        return res;
    }


    /**
     *
     * todo 未能理解 DFS
     *
     * 2018-02-27 貌似理解了
     *
     *
     * @param candidates 组合
     * @param start      从组合中的哪个位置开始
     * @param target     目标
     * @param res        最终结果
     * @param combination        当前组合
     */
    public void combinationSumRec(int[] candidates, int start, int target, List<List<Integer>> res, List<Integer> combination) {
        // 如果当前和已经大于目标，说明该路径错误
        if (target < 0) {
            return;
            // 如果当前和等于目标，说明这是一条正确路径，记录该路径
        } else if (target == 0) {
            List<Integer> oneComb = new LinkedList<Integer>(combination);
            res.add(oneComb);
            // 否则，对剩余所有可能性进行深度优先搜索
        } else {
            // 选取之后的每个数字都是一种可能性
            for (int i = start; i < candidates.length; i++) {
                // 这里的add \remove 只是为了保证下一次循环时，combination的正确性
                combination.add(candidates[i]);
                combinationSumRec(candidates, i, target - candidates[i], res, combination);
                combination.remove(combination.size() - 1);
            }
        }
    }






}
