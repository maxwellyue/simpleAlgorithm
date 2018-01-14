package algorithm.leetcode;

import java.util.List;

/************************************************************************************
 * 功能描述：
 *
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 * You may assume the dictionary does not contain duplicate words.
 *
 * For example, given
 * s = "leetcode",
 * dict = ["leet", "code"].
 *
 * Return true because "leetcode" can be segmented as "leet code".
 *
 * UPDATE (2017/1/4):
 * The wordDict parameter had been changed to a list of strings (instead of a set of strings).
 * Please reload the code definition to get the latest changes.
 *
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2018年01月14日 --  下午5:53 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class WordBreak {

    /**
     *
     * 动态规划
     *
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return true;
        }
        // res[i] represents whether s[0...i] can be formed by dict
        boolean[] res = new boolean[s.length() + 1];
        res[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (res[j] && wordDict.contains(s.substring(j, i))) {
                    res[i] = true;
                    break;
                }
            }
        }

        return res[s.length()];
    }
}
