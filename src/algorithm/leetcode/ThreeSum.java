package algorithm.leetcode;

import org.junit.Test;

import java.util.*;

/************************************************************************************
 * 功能描述：
 *
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 *
 * Note: The solution set must not contain duplicate triplets.
 *
 * For example, given array S = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 *
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2018年01月04日 --  上午11:21 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class ThreeSum {

    /**
     *
     * 借助和为定值的两个数的思想
     *
     * 但是这种解法无法通过leetcode，会报Time Limit Exceeded
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < nums.length - 2; i++){
            int a = nums[i];
            //寻找和为-a的两个数
            Map<Integer, Integer> map = new HashMap<>();
            for(int j = i+1; j < nums.length; j++){
                if(map.containsKey(-a - nums[j])){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(-a - nums[j]);
                    Collections.sort(list);
                    result.add(list);
                }else {
                    map.put(nums[j], j);
                }
            }
        }

        //去重
        Set<List<Integer>> set = new HashSet<>(result);
        result.clear();
        for (List<Integer> list : set){
            result.add(list);
        }

        return result;
    }


    /**
     *
     * 还是借助和为定值的两个数的思想，
     * 但是首先排序，采用两端指针扫描法而不是hash table
     *
     *
     * 这个解法可以通过
     *
     * 来自 ： https://leetcode.com/problems/3sum/discuss/7399
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i + 2 < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {              // skip same result
                continue;
            }
            int j = i + 1, k = nums.length - 1;
            int target = -nums[i];
            while (j < k) {
                if (nums[j] + nums[k] == target) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) j++;  // skip same result
                    while (j < k && nums[k] == nums[k + 1]) k--;  // skip same result
                } else if (nums[j] + nums[k] > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return res;
    }




    @Test
    public void test(){
        int[] array = {-1,0,1,2,-1,-4};
        threeSum(array);

    }


}
