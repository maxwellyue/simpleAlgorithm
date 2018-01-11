package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/************************************************************************************
 * 功能描述：
 *
 Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 For example, given n = 3, a solution set is:

 [
 "((()))",
 "(()())",
 "(())()",
 "()(())",
 "()()()"
 ]
 *
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2018年01月11日 --  下午1:15 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class GenerateParentheses {

    /**
     *
     * todo 未能理解：
     *
     * 来自leetcode的solutions：https://leetcode.com/problems/generate-parentheses/solution/
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generate(n,0, 0, res, "");
        return res;
    }

    /**
     *
     *
     * @param left 当前左括号的个数
     * @param right 当前右括号的个数
     * @param res 最终结果
     * @param out 当前结果
     */
    private void generate(int n, int left, int right, List<String> res, String out) {
        if (out.length() == n * 2) {
            res.add(out);
            return;
        }

        if (left < n)
            generate(n, left+1, right, res, out+"(");
        if (right < left)
            generate(n, left, right+1, res, out+")");
    }

}
