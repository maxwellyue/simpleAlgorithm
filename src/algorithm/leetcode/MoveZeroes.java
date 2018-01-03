package algorithm.leetcode;

/************************************************************************************
 * 功能描述：
 *
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 *
 * Note:
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 *
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2018年01月03日 --  下午4:52 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class MoveZeroes {

    /**
     *
     * 循环，遇到0，则在本次循环之后的元素中寻找非0元素，并交换
     * 在循环过程中，
     * 记录非0元素的位置，避免重复寻找；
     * 如果非0元素的位置到了数组最后的位置还没有找到，说明完成移动，要结束整个循环
     *
     *
     * 空间复杂度是O(1)
     * 时间复杂度：O(n^2)
     *
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int startNoneZero = 1;
        boolean notEnd = true;
        for(int i = 0; i < nums.length && notEnd; i++){
            if(nums[i] == 0){
                int start = startNoneZero > i + 1 ? startNoneZero : i+1;
                for(int j = start; j < nums.length; j++ ){
                    if(nums[j] != 0){
                        //交换i、j这两个位置的元素
                        nums[i] = nums[j];
                        nums[j] = 0;
                        startNoneZero = j++;
                        break;
                    }
                    if(j == nums.length - 1 && nums[j] == 0){
                        notEnd = false;
                    }
                }
            }
        }
    }

    /**
     *
     * 来自：https://leetcode.com/problems/move-zeroes/discuss/72000
     *
     * 思想：循环找非0的元素，找到后，依次从数组的第一个位置开始放
     *      交换的位置必定是其自身所在位置或该位置为0
     *
     * 空间复杂度是O(1)
     * 时间复杂度：O(n)
     *
     * @param nums
     */
    public void moveZeroes2(int[] nums) {
        int j = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }
    }

    /**
     * 对moveZeroes2的改进：避免不必要的交换
     *
     * 空间复杂度是O(1)
     * 时间复杂度：O(n)
     *
     * @param nums
     */
    public void moveZeroes3(int[] nums) {
        int j = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                if(nums[j] == 0){
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                j++;
            }
        }
    }

}
