package algorithm.leetcode;

import java.util.*;

/************************************************************************************
 * 功能描述：
 *
 * Given an array of integers, every element appears twice except for one. Find that single one.
 *
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2018年01月03日 --  上午11:13 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class SingleNumber {

    /**
     * 异或运算
     * <p>
     * 操作位上，同时为1或同时为0，则返回0，一个1一个0则返回1，即相同返回0，不同返回1
     * 所以，任何数异或0，都还是它自身
     * <p>
     * 异或运算的规律：
     * a^a = 0
     * a^b = b^a
     * a^0 = a
     * 所以，题目的给定的数组中，两个相同的数异或后都是0，最终0^singleNumber = singleNumber
     * <p>
     * <p>
     * 时间复杂度O(n)
     * 空间复杂度为O(1)
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }


    /**
     * 借助Hash表
     * <p>
     * 循环数组，将元素尝试放入哈希表：加入哈希表中已经包含该元素，则删除该元素；不包含，则放入
     * 循环结束后，哈希表中就只剩下一个元素了，即为我们要找的那个数
     *
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     *
     * @param nums
     * @return
     */
    public int singleNumber2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.remove(nums[i]);
            } else {
                map.put(nums[i], i);
            }
        }

        Iterator<Integer> iterator = map.keySet().iterator();
        return iterator.next();
    }

    /**
     * 借助set，利用2∗(a+b+c)−(a+a+b+b+c)=c 计算出要找的那个数
     *
     * 时间复杂度O(n)
     * 空间复杂度O(n)
     *
     * @param nums
     * @return
     */
    public int singleNumber3(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
            set.add(nums[i]);
        }

        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()){
            sum -= 2*iterator.next();
        }

        return -sum;
    }
}
