package algorithm.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/************************************************************************************
 * 功能描述：
 *
 * Given a digit string, return all possible letter combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 *
 *
 *
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Note:
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2018年01月11日 --  上午11:12 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class LetterCombinationsPhoneNumber {

    private String[] dict = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};


    /**
     *
     * 思路：
     *
     * 例如输入"123"，循环每个字符
     *
     * 对于第一个数字1：对应abc，则结果就是
     * a
     * b
     * c
     * 对于第二个数字2：对应def，则将d、e、f分别于前面计算的结果组合，即
     * ad ae af
     * bd be bf
     * cd ce cf
     * 对于第二个数字3：对应ghi，则将g、h、i分别于前面计算的结果组合，即
     * adg aeg afg bdg beg bfg cdg ceg cfg
     * adh aeh afh bdh beh bfh cdh ceh cfh
     * adi aei afi bdi bei bfi cdi cei cfi
     *
     *
     *
     *
     * 时间复杂度：n^2 （最内层循环为常数3或4）
     *
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {

        List<String> res = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return res;
        }

        char[] chars = digits.toCharArray();

        for (Character s : chars) {
            if(res.size() > 0){
                List<String> temp = new ArrayList<>(res);
                res.clear();
                for(String string : temp){
                    String d = dict[Integer.parseInt(s.toString())];
                    for(Character dd : d.toCharArray()){
                        res.add(string + dd);
                    }
                }
            }else {
                String d = dict[Integer.parseInt(s.toString())];
                for(Character dd : d.toCharArray()){
                    res.add(dd.toString());
                }
            }
        }

        return res;
    }

    /**
     *
     * 递归解法
     *
     * 来自：https://leetcode.com/problems/letter-combinations-of-a-phone-number/discuss/8109
     *
     * @param digits
     * @return
     */
    public List<String> letterCombinations2(String digits) {
        LinkedList<String> res = new LinkedList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        combination("", digits, 0, res);
        return res;

    }

    private void combination(String prefix, String digits, int index, List<String> res){
        if (index >= digits.length()) {
            res.add(prefix);
            return;
        }
        String letters = dict[(digits.charAt(index) - '0')];
        for (int i = 0; i < letters.length(); i++) {
            combination(prefix + letters.charAt(i), digits, index + 1, res);
        }
    }





    @Test
    public void test(){
        String s = "22";
        List<String> strings = letterCombinations(s);
        int a = 0;

    }
}
