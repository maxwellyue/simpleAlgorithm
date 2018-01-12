package algorithm.leetcode;

/************************************************************************************
 * 功能描述：
 *
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 *
 * If the last word does not exist, return 0.
 *
 * Note: A word is defined as a character sequence consists of non-space characters only.
 *
 * Example:
 *
 * Input: "Hello World"
 * Output: 5
 *
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2018年01月12日 --  上午11:06 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class LengthofLastWord {


    /**
     *
     * 使用JDK自带方法
     *
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {
        String[] split = s.split(" ");
        if(split.length == 0){
            return 0;
        }
        return split[split.length - 1].length();
    }

    /**
     *
     *
     * @param s
     * @return
     */
    public int lengthOfLastWord2(String s) {

        return 0;
    }
}
