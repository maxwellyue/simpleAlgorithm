package algorithm.leetcode;

import org.junit.Test;

/************************************************************************************
 * 功能描述：
 *
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 *
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 *
 * Note:
 * You are not suppose to use the library's sort function for this problem.
 *
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
 *
 * Could you come up with an one-pass algorithm using only constant space?
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2018年01月12日 --  下午5:18 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class SortColors {

    /**
     *
     * 解释来自：http://bangbingsyb.blogspot.jp/2014/11/leetcode-sort-colors.html
     *
     *
     * @param nums
     */
    public void sortColors(int[] nums) {

        //left表示0..0的右边界，right表示2....2的左边界
        int left = 0;
        int right = nums.length - 1;
        int i = 0;
        while (i < right) {
            switch (nums[i]) {
                case 0://红色：由于nums[left]=1或0，所以交换以后nums[cur]已经就位，cur++，left++
                    swap(nums, left++, i++);
                    break;
                case 1://白色
                    i++;
                    break;
                case 2://蓝色：由于交换后i位置处的颜色仍然不能确定，所以，此时交换完之后，不能i++
                    swap(nums, right--, i);
                    break;
                default:
            }
        }
    }

    private void swap(int[] nums, int idx1, int idx2) {
        if (idx1 < 0 || idx1 > nums.length - 1 || idx2 < 0 || idx2 > nums.length - 1) {
            return;
        }
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }

    @Test
    public void test() {

        int[] a = {1, 2, 0};
        sortColors(a);
    }
}
