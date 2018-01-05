package algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/************************************************************************************
 * 功能描述：
 *
 *
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 *
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 *
 * The order of output does not matter.
 *
 * Example 1:
 *
 * Input:
 * s: "cbaebabacd" p: "abc"
 *
 * Output:
 * [0, 6]
 *
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * Example 2:
 *
 * Input:
 * s: "abab" p: "ab"
 *
 * Output:
 * [0, 1, 2]
 *
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 *
 *
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2018年01月05日 --  下午12:13 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class FindAllAnagramsInAString {


    /**
     * 时间复杂度O(mn)
     * <p>
     * 无法通过leetcode，time limit exceeded
     *
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();

        int length = p.length();
        for (int i = 0; i < s.length() - length + 1; i++) {
            String sub = s.substring(i, i + length);
            if (isAnagrams(sub, p)) {
                list.add(i);
            }
        }

        return list;
    }

    private boolean isAnagrams(String s, String b) {

        List<Character> list = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            list.add(s.charAt(i));
        }

        for (int i = 0; i < b.length(); i++) {
            int index = list.indexOf(b.charAt(i));
            if (index >= 0) {
                list.remove(index);
            } else {
                return false;
            }
        }

        return list.size() == 0;
    }


    /**
     *
     * 滑动窗口方法
     *
     * 来自：https://leetcode.com/problems/find-all-anagrams-in-a-string/discuss/92007?page=2
     *
     * todo 未能理解
     *
     *
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams2(String s, String p) {
        List<Integer> res = new ArrayList<>();

        //key：p中的字符，value：p中该字符出现的次数
        Map<Character, Integer> map = new HashMap<>();
        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int counter = map.size();

        //滑动窗口
        int left = 0, right = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) {
                    counter--;
                }
            }
            right++;
            //counter = 0，说明窗口中已经包含了p中所有字符，
            //但还可能包含了多余的元素，要去掉左边的多余的字符，
            //
            while (counter == 0) {
                char tempc = s.charAt(left);
                if (map.containsKey(tempc)) {
                    map.put(tempc, map.get(tempc) + 1);
                    if (map.get(tempc) > 0) {
                        counter++;
                    }
                }
                if (right - left == p.length()) {
                    res.add(left);
                }
                left++;
            }
        }

        return res;
    }


}
