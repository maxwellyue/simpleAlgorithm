package algorithm.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/************************************************************************************
 * 功能描述：
 *
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
 *
 * Note:
 * ①You must not modify the array (assume the array is read only).
 * ②You must use only constant, O(1) extra space.
 * ③Your runtime complexity should be less than O(n2).
 * ④There is only one duplicate number in the array, but it could be repeated more than once.
 *
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2018年01月09日 --  下午7:05 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class FindTheDuplicateNumber {

    /**
     * 排序法
     *
     * 但不满足①
     *
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++){
            if(nums[i] == nums[i+1]){
                return i;
            }
        }

        return -1;
    }

    /**
     *
     * 使用Set元素不能重复的特性
     * 但不满足②
     *
     * @param nums
     * @return
     */
    public int findDuplicate2(int[] nums) {
        Set<Integer> seen = new HashSet<Integer>();
        for (int num : nums) {
            if (seen.contains(num)) {
                return num;
            }
            seen.add(num);
        }

        return -1;
    }


    /**
     *
     * 快慢指针法
     *
     * 借助两个快慢指针
     *
     * 详细的解释：http://blog.csdn.net/monkeyduck/article/details/50439840
     * 图文并茂，解释的非常好
     *
     * @param nums
     * @return
     */
    public int findDuplicate3(int[] nums) {

        //先找到快慢指针第一次相遇的交点
        //这里的一步，并不是i+1这种，而是根据下标和值的关系
        int slow = nums[0];
        int fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        //将快指针从位置0开始，不再快，而是与满指针同速
        //再次相遇，必定是在重复的那个数字上
        fast = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }



}
