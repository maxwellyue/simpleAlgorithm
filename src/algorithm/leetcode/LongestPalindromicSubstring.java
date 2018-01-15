package algorithm.leetcode;

import org.junit.Test;

/************************************************************************************
 * 功能描述：
 *
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Example:
 *
 * Input: "babad"
 *
 * Output: "bab"
 *
 * Note: "aba" is also a valid answer.
 * Example:
 *
 * Input: "cbbd"
 *
 * Output: "bb"
 *
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2018年01月15日 --  上午11:53 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class LongestPalindromicSubstring {


    /**
     *
     * 以s中的每个字符为中心，向两边扩展，一直到不是回文，
     * 要注意分奇偶两种情况
     *
     *
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        String res = "";

        for (int i = 0; i < s.length(); i++) {
            String s1 = extendPalindrome(s, i, i);
            String s2 = extendPalindrome(s, i, i + 1);

            if(s1.length() > res.length()){
                res = s1;
            }
            if(s2.length() > res.length()){
                res = s2;
            }
        }

        return res;
    }


    private String extendPalindrome(String s, int i, int j) {
        while (i >= 0 && j < s.length()) {
            if (s.charAt(i) == s.charAt(j)) {
                i--;
                j++;
            }else {
                break;
            }
        }
        //注意，上面结束之后，i+1, j-1才是符合回文的字符串的位置，而不是i,j

        //包括左边界，不包括右边界，即要截取的是s[i+1, j-1]
        return s.substring(i+1, j);
    }


    @Test
    public void test(){
        String s = "babad";
        System.out.println(longestPalindrome(s));

    }

}
