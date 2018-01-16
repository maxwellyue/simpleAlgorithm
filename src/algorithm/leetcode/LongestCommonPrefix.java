package algorithm.leetcode;

import org.junit.Test;

/************************************************************************************
 * 功能描述：
 *
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2018年01月16日 --  下午5:33 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class LongestCommonPrefix {


    /**
     *
     * 可以通过
     *
     * 时间复杂度：O(mn)，m为长度最小的字符串的长度，n为字符串的个数，mn是最坏情况
     * 空间复杂度：O(1)
     *
     * leetcode的solution：https://leetcode.com/problems/longest-common-prefix/solution/
     *
     * 代码与它的第二种解法类似
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        if (strs.length == 1) {
            return strs[0];
        }


        StringBuilder res = new StringBuilder();

        int minLength = Integer.MAX_VALUE;
        for (String s : strs) {
            minLength = Math.min(minLength, s.length());
        }

        boolean end = false;
        for (int i = 0; i < minLength && !end; i++) {
            char c = strs[0].charAt(i);
            boolean valid = true;
            for (int j = 1; j < strs.length; j++) {
                if (c != strs[j].charAt(i)) {
                    valid = false;
                    end = true;
                    break;
                }
            }
            if (valid) {
                res.append(c);
            }
        }
        return res.toString();
    }




    @Test
    public void test() {
        String[] a = {"a"};
        System.out.println(longestCommonPrefix(a));

    }
}
