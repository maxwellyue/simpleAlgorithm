package algorithm.leetcode;

import org.junit.Test;

/************************************************************************************
 * 功能描述：
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2018年01月12日 --  下午1:46 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class SearchInRotatedSortedArray {


    /**
     * 思路：
     * <p>
     * 首先使用二分法找到最小值的位置，
     * 再判断target在最小值的左边还是右边，
     * 使用二分法在左边或右边查找target
     * <p>
     * 来自：https://leetcode.com/problems/search-in-rotated-sorted-array/discuss/14425
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int minIndex = findMinIndex(nums);
        if (target == nums[minIndex]) {
            return minIndex;
        }

        int length = nums.length;

        int start = (target > nums[length - 1]) ? 0 : minIndex;
        int end = (target > nums[length - 1]) ? minIndex : length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    private int findMinIndex(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return start;
    }


    @Test
    public void test(){
        int[] a = {1,3,5};
        System.out.println(search(a, 1 ));
    }
}
