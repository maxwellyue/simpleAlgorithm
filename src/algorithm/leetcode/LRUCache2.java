package algorithm.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

/************************************************************************************
 * 功能描述：
 *
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 *
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 *
 * Example:
 *
 *      LRUCache cache = new LRUCache( 2 );
 *      cache.put(1,1);
 *      cache.put(2,2);
 *      cache.get(1);       // returns 1
 *      cache.put(3,3);    // evicts key 2
 *      cache.get(2);       // returns -1 (not found)
 *      cache.put(4,4);    // evicts key 1
 *      cache.get(1);       // returns -1 (not found)
 *      cache.get(3);       // returns 3
 *      cache.get(4);       // returns 4
 *
 *
 *
 *
 *创建人：岳增存 yuezc@seentao.com
 *创建时间： 2018年01月08日--下午7:57
 *其他说明：
 *修改时间：
 *修改人：
 *************************************************************************************/
public class LRUCache2 {

    private LinkedHashMap<Integer, Integer> map;
    private final int CAPACITY;

    public LRUCache2(int capacity) {
        CAPACITY = capacity;
        map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > CAPACITY;
            }
        };
    }

    public int get(int key) {
        return map.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        map.put(key, value);
    }


}
