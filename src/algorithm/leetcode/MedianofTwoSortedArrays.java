package algorithm.leetcode;

import org.junit.Test;

/************************************************************************************
 * 功能描述：
 *
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 *
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 * Example 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * The median is 2.0
 * Example 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * The median is (2 + 3)/2 = 2.5
 *
 *
 * 求两个排序序列的中位数
 *
 * 计算有限个数的数据的中位数的方法是：把所有的同类数据按照大小的顺序排列。
 * 如果数据的个数是奇数，则中间那个数据就是这群数据的中位数；
 * 如果数据的个数是偶数，则中间那2个数据的算术平均值就是这群数据的中位数。
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2018年01月11日 --  下午5:57 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class MedianofTwoSortedArrays {


    /**
     *
     * 思路：
     *
     * 合并两个有序序列
     * 但是不必合并完全，只需要合并到（两个序列总长度/2 + 1）即可
     *
     * 时间复杂度：O(m+n)
     *
     * 不符合题目要求，但是可以通过leetcode
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int sum = nums1.length + nums2.length;

        //是否为奇数
        boolean odd = (sum & 1) != 0;

        int length = (sum >> 1) + 1;
        int[] res = new int[length];
        int i = 0, j = 0, k = 0;
        while (k < length) {
            if (i < nums1.length && j < nums2.length) {
                if (nums1[i] < nums2[j]) {
                    res[k++] = nums1[i++];
                } else {
                    res[k++] = nums2[j++];
                }
            } else if (i < nums1.length && j >= nums2.length) {
                res[k++] = nums1[i++];
            } else if (i >= nums1.length && j < nums2.length) {
                res[k++] = nums2[j++];
            }
        }
        return odd ? res[length - 1] : ((double) res[length - 1] + (double) res[length - 2]) / (double) 2;
    }


    /**
     *
     * todo 时间复杂度为O(m+n)的待研究
     *
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        return 0;
    }



        @Test
    public void test(){
        int[] a = {1, 3};
        int[] b = {2};
        System.out.println(findMedianSortedArrays(a, b));

    }

}
