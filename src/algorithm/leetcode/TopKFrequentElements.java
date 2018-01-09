package algorithm.leetcode;

import java.util.*;

/************************************************************************************
 * 功能描述：
 *
 * Given a non-empty array of integers, return the k most frequent elements.
 *
 * For example,
 * Given [1,1,1,2,2,3] and k = 2, return [1,2].
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 *
 *
 *
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2018年01月09日 --  下午6:20 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class TopKFrequentElements {


    //解题思路来自：https://leetcode.com/problems/top-k-frequent-elements/discuss/81635



    /**
     *
     * 使用TreeMap：内部使用红黑树实现排序，默认按key从小到大排序
     *
     * 更多TreeMap内容：http://yikun.github.io/2015/04/06/Java-TreeMap%E5%B7%A5%E4%BD%9C%E5%8E%9F%E7%90%86%E5%8F%8A%E5%AE%9E%E7%8E%B0/
     *
     *
     * @param nums
     * @param k
     * @return
     */
    public List<Integer> topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        TreeMap<Integer, List<Integer>> treeMap = new TreeMap<>();
        for(int n : map.keySet()){
            int freq = map.get(n);
            if(!treeMap.containsKey(freq)){
                treeMap.put(freq, new LinkedList<>());
            }

            treeMap.get(freq).add(n);
        }

        List<Integer> res = new ArrayList<>();
        while (res.size() < k){
            List<Integer> list = treeMap.pollLastEntry().getValue();
            res.addAll(list);
        }
        return res;
    }

    /**
     *
     * 使用优先队列
     *
     *
     * 优先队列的头是基于自然排序或者Comparator排序的最小元素。
     * 当我们获取队列时，返回队列的头对象。
     *
     * 更多优先队列的内容：http://www.importnew.com/6932.html
     *
     *
     * @param nums
     * @param k
     * @return
     */
    public List<Integer> topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums){
            map.put(n, map.getOrDefault(n,0) + 1);
        }

        //由于PriorityQueue默认是按头小尾大的顺序排序，
        //所以要自定义Comparator，让频次（value）大的Entry排在队头
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap =
                new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
                    @Override
                    public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                        return o2.getValue()- o1.getValue();
                    }
                });

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            maxHeap.add(entry);
        }

        List<Integer> res = new ArrayList<>();
        while(res.size()<k){
            Map.Entry<Integer, Integer> entry = maxHeap.poll();
            res.add(entry.getKey());
        }
        return res;
    }



}
