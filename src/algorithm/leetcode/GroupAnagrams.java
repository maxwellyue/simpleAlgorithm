package algorithm.leetcode;

import org.junit.Test;

import java.util.*;

/************************************************************************************
 * 功能描述：
 *
 * Given an array of strings, group anagrams together.
 *
 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Return:
 *
 * [
 * ["ate", "eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * Note: All inputs will be in lower-case.
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2018年01月15日 --  下午1:13 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class GroupAnagrams {


    /**
     *
     * 通过List保存结果
     * 时间复杂度：O(n^2)
     *
     * 要改善时间复杂度，则从循环中else中的逻辑改善
     *
     * todo 提交leetcode时，当输入{"",""}时，说输出不对，但它的输出与我本地输出不同，所以没有通过
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new LinkedList<>();
        if (strs == null || strs.length == 0) {
            return res;
        }

        for (String s : strs) {
            if (res.isEmpty()) {
                List<String> list = new LinkedList<>();
                list.add(s);
                res.add(list);
            } else {
                boolean anagrams = false;
                for (List<String> list : res) {
                    if(isAnagrams(list.get(0),s)){
                        anagrams = true;
                        list.add(s);
                    }
                }
                if (!anagrams) {
                    List<String> list = new LinkedList<>();
                    list.add(s);
                    res.add(list);
                }
            }
        }
        return res;
    }

    private boolean isAnagrams(String s1, String s2) {
        if(s1.length() == 0 || s2.length() == 0){
            return s1 == s2;
        }
        int a = 1;
        for (Character c1 : s1.toCharArray()) {
            for (Character c2 : s2.toCharArray()) {
                a = a ^ c1 ^ c2;
            }
        }
        return a == 1;
    }

    /**
     *
     * 借助HashMap降低时间复杂度
     *
     * O(n)  --- 不考虑Arrays.sort(chars);的时间复杂度，因为String的长度有限，可以认为是常数
     *           否则，如果考虑Arrays.sort(chars)的时间复杂度O(n log(n))，则O(n^2 log(n))
     *
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams2(String[] strs) {
        List<List<String>> res = new LinkedList<>();
        if (strs == null || strs.length == 0) {
            return res;
        }

        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            if (!map.containsKey(String.valueOf(chars))) {
                List<String> list = new LinkedList<>();
                list.add(s);
                map.put(String.valueOf(chars), list);
            } else {
                List<String> list = map.get(String.valueOf(chars));
                list.add(s);
            }
        }

        res.addAll(map.values());
        return res;
    }

    /**
     *
     * 其他思路：
     *
     * 关键在于map中key的计算，即用什么作为相似字符串的key
     * ①使用素数：
     *      int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};
     *      for (char ch : s.toCharArray()) {
     *           key *= prime[ch - 'a'];
     *      }
     *
     *
     *
     *
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams3(String[] strs) {

        return null;
    }



    @Test
    public void test(){
        String s1 = "";
        String s2 = "";
        //System.out.println(isAnagrams(s1,s2));

        String[] strings = {"eat","tea","tan","ate","nat","bat"};

        System.out.println( groupAnagrams2(strings));
    }
}
