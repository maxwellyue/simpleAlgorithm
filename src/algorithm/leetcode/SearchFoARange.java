package algorithm.leetcode;

/************************************************************************************
 * 功能描述：
 *
 * Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 *
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 *
 * todo  最优解法没有写
 *
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2018年01月04日 --  下午6:00 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class SearchFoARange {


    /**
     * O（n）解法的思路很容易想到（但正确写出来也要注意很多边界条件）
     * <p>
     * 虽然要求O(log n)，但这种O(n)的解法也通过了leetcode
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};

        for (int i = 0; i < nums.length; i++) {
            boolean start = (nums[i] == target && i == 0) || (i != 0 && nums.length > 1 && nums[i] == target && nums[i - 1] != target);
            boolean end = (nums[i] == target && i == nums.length - 1) || (nums[i] == target && nums[i + 1] != target);
            if (start) {
                res[0] = i;
            }
            if (end) {
                res[1] = i;
            }
        }

        return res;
    }


    /**
     * 为了达到要求的O(log n)，可以用二分查找来分别找到起始位置
     *
     * 来自：https://leetcode.com/problems/search-for-a-range/discuss/14734
     *
     *
     * 更优的解法是：将两次二分合并为一次
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange2(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findFirst(nums, target);
        result[1] = findLast(nums, target);
        return result;
    }

    private int findFirst(int[] nums, int target) {
        int idx = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] >= target) {//即使相等也要继续
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            if (nums[mid] == target) idx = mid;
        }
        return idx;
    }

    private int findLast(int[] nums, int target) {
        int idx = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            if (nums[mid] == target) idx = mid;
        }
        return idx;
    }


}
