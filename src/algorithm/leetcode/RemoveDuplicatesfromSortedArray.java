package algorithm.leetcode;

/************************************************************************************
 * 功能描述：
 *
 * Given a sorted array, remove the duplicates in-place such that
 *
 * each element appear only once and return the new length.
 *
 * Do not allocate extra space for another array,
 *
 * you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * Example:
 *
 * Given nums = [1,1,2],
 *
 * Your function should return length = 2,
 *
 * with the first two elements of nums being 1 and 2 respectively.
 *
 *
 * It doesn't matter what you leave beyond the new length.
 *
 *
 *
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2018年01月18日 --  下午5:08 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class RemoveDuplicatesfromSortedArray {

    /**
     *
     * 将数组中重复元素去掉，并返回最终数组的长度
     *
     * 注意，原数组假如为[0, n]，取出重复元素后为：[0, m]，
     * 至于[m+1, n]是什么，无所谓。
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        int res = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[i-1]){
                nums[res++] = nums[i];
            }
        }

        return res;
    }

}
