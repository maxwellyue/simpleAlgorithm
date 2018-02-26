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
     * 滑动窗口方法
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {

        int left = 0, right = 0, max = 0;

        //存储不重复子串
        Set<Character> set = new HashSet<>();

        while (right < s.length()) {
            //如果不包含该字符，则放到set中
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
                max = Math.max(max, set.size());
            } else {//否则，移除左侧的字符，一次移动一个位置
                //因为这种只移动左侧的操作并未改变right指向，所以会继续循环，直到左侧移动到与
                //此时右侧元素相同的那个字符之后。
                set.remove(s.charAt(left));
                left++;
            }
        }

        return max;
    }

}
