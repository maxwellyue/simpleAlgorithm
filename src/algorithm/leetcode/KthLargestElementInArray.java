package algorithm.leetcode;

import java.util.Arrays;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/************************************************************************************
 * 功能描述：
 *
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * For example,
 * Given [3,2,1,5,6,4] and k = 2, return 5.
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2018年01月15日 --  下午2:34 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class KthLargestElementInArray {

    /**
     * 排序法
     * <p>
     * 时间复杂度：O(nlog(n))
     *
     * 可以通过leetcode
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    /**
     * 借助TreeMap
     * <p>
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * 可以通过leetcode
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest2(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }

        int res = nums[0];

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        while (k > 0) {
            Map.Entry<Integer, Integer> entry = map.pollLastEntry();
            k -= entry.getValue();
            if (k <= 0) {
                res = entry.getKey();
            }
        }

        return res;
    }


    /**
     * 借助优先队列
     *
     * 优先队列可以按照元素的自然顺序或指定的顺序（Comparator）来排序元素
     * 普通的队列则是先进先出，
     * 优先队列则不是先进先出，而是先出小的，再出大的
     *
     * peek：查看队头元素
     * poll：取出队头元素
     *
     * 时间复杂度为O(n)**优先队列添加元素的时间复杂度O(log(n)) = O(nlog(n))
     *
     * 为啥优先队列添加元素的时间复杂度是O(log(n))
     * 没看源码，猜想是：使用二分法（因为元素是排序好的）找到当前元素应该插入的位置
     * 而二分法的时间复杂度为O(log(n))
     *
     *
     * 可以通过leetcode
     *
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest3(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }

        //创建优先队列，元素数量为k个
        PriorityQueue<Integer> queue = new PriorityQueue<>(k);

        for (int i = 0; i < nums.length; i++) {
            //如果当前优先队列中元素个数小于k个，则直接添加到优先队列中
            if (i < k) {
                queue.offer(nums[i]);
            } else {
                //如果当前优先队列中元素个数已经等于k个，
                //则比较当前元素是否大于队头元素（最小的元素），
                //是的话，则移除队头元素，并添加当前元素
                if (nums[i] > queue.peek()) {
                    queue.poll();
                    queue.offer(nums[i]);
                }
            }
        }
        return queue.peek();
    }

    /**
     *
     * 利用快排
     *
     * todo 完成代码
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest4(int[] nums, int k) {
        return 0;
    }
}
