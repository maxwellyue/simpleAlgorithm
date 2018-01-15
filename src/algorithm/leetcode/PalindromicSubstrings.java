package algorithm.leetcode;

/************************************************************************************
 * 功能描述：
 *
 * Given a string, your task is to count how many palindromic substrings in this string.
 *
 * The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.
 *
 * Example 1:
 * Input: "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 *
 * Example 2:
 * Input: "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 *
 * Note:
 * The input string length won't exceed 1000.
 *
 * 求字符串的回文子串的个数
 *
 * 与求字符串的最长回文字符串类似
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2018年01月15日 --  下午7:51 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class PalindromicSubstrings {

    /**
     *
     * 与求字符串的最长回文字符串类似
     *
     * 以每个字符为中心，从中心向两边扩展
     * 注意有奇偶两种情况
     *
     * @param s
     * @return
     */
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res += extendPalindrome(s, i, i);
            res += extendPalindrome(s, i, i + 1);
        }
        return res;
    }

    private int extendPalindrome(String s, int i, int j) {
        int res = 0;
        while (i >= 0 && j < s.length()) {
            if (s.charAt(i--) == s.charAt(j++)) {
                res++;
            }else {
                break;
            }
        }
        return res;
    }
}
