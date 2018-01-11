package algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

/************************************************************************************
 * 功能描述：
 *
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Examples:
 *
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 *
 * Given "bbbbb", the answer is "b", with the length of 1.
 *
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2017年12月17日 --  下午12:49 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class LongestSubstringWithoutRepeatingCharacters {

    /**
     * 暴力循环
     *
     * 时间复杂度O(n^2)
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        Set<String> set = new HashSet<>();
        char[] chars = s.toCharArray();
        int maxLength = 0;

        int i = 0, j = 0;

        while (i < chars.length && j < chars.length) {


        }


        return 0;
    }

    /**
     *
     * 来自：https://leetcode.com/problems/longest-substring-without-repeating-characters/discuss/1812
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<>();

        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(i++));
            }
        }

        return max;
    }

}
