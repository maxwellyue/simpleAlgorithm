package algorithm.leetcode;

/************************************************************************************
 * 功能描述：
 *
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 *
 * Note:
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 *
 * 合并有序数组
 *
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2018年01月02日 --  下午5:41 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class MergeSortedArray {

    /**
     * 因为结果仍然放在A中，所以，要从后向前扫描
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m-1, j = n-1, index = m+n-1;

        while (i >= 0 && j >= 0){
            if(nums1[i] > nums2[j]){
                nums1[index] = nums1[i];
                i--;
            }else {
                nums1[index] = nums2[j];
                j--;
            }
            index--;
        }

        while (j >= 0){
            nums1[index] = nums2[j];
            j--;
            index--;
        }
    }

}
