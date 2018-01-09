package algorithm.leetcode;

/************************************************************************************
 * 功能描述：
 *
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
 *
 * For example, given the array [2,3,-2,4],
 * the contiguous subarray [2,3] has the largest product = 6.
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2018年01月09日 --  下午5:44 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        int max = nums[0];
        int min = nums[0];
        int res = nums[0];

        //每次循环记录最大值、最小值
        //最大值出现在：上次的max*nums[i], 上次的min*nums[i],nums[i]三者之间
        //最小值出现在：上次的max*nums[i], 上次的min*nums[i],nums[i]三者之间
        for (int i = 1; i < nums.length; i++) {
            int temp = max;
            max = Math.max(Math.max(max*nums[i], min*nums[i]), nums[i]);
            min = Math.min(Math.min(temp*nums[i], min*nums[i]), nums[i]);
            if(max > res){
                res = max;
            }
        }

        return res;
    }
}
