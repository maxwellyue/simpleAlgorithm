package algorithm.leetcode;

import org.junit.Test;

import java.util.Stack;

/************************************************************************************
 * 功能描述：
 *
 * Given an encoded string, return it's decoded string.
 *
 *
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times.
 *
 * Note that k is guaranteed to be a positive integer.
 *
 * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
 *
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k.
 *
 * For example, there won't be input like 3a or 2[4].
 *
 * Examples:
 *
 * s = "3[a]2[bc]", return "aaabcbc".
 * s = "3[a2[c]]", return "accaccacc".
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2018年01月16日 --  上午11:37 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class DecodeString {


    /**
     * 最初的写法
     * <p>
     * 没有看清题目要求，
     * 会出现2[3[ab]]的情况，即括号中含有括号的情况
     *
     * @param s
     * @return
     */
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        StringBuilder cur = new StringBuilder();
        int lastNum = 0;
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                lastNum = c - '0';
                //处理ab2[abc]的情况：即开始是字母
                if (cur.length() > 0) {
                    res.append(cur);
                    cur.setLength(0);
                }

            } else if (c == '[') {
                //do nothing
            } else if (c == ']') {
                //将[]里的字符串添加到res中
                if (cur.length() > 0) {//加上判断，是防止3[]的情况
                    for (int j = 0; j < lastNum; j++) {
                        res.append(cur);
                    }
                    //重置cur
                    cur.setLength(0);
                }
            } else {//字母
                cur.append(c);
            }
            i++;
        }
        //处理类似：2[abc]3[cd]ef的情况，即以字母结束
        if (cur.length() > 0) {
            res.append(cur);
        }
        return res.toString();
    }


    /**
     *
     * 借助栈
     *
     * 思路：
     * 循环整个字符串，遇到非]字符，则放到栈中，
     * 遇到]字符时，
     *      则依次出栈，直到出栈元素等于[，并将[前面的连续数字出栈，这样就完成了一对括号的解析
     *
     * 因为输入是合法的，所以最终stack中即是最终的结果
     *
     * 要注意字符的顺序
     *
     *
     * 可以通过leetcode
     *
     *
     * 时间复杂度：
     * 空间复杂度：最终字符串的字符个数
     *
     * @param s
     * @return
     */
    public String decodeString2(String s) {

        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if (c != ']') {
                stack.push(c);
            } else {
                StringBuilder cur = new StringBuilder();
                while (!stack.isEmpty()) {
                    char pop = stack.pop();
                    if (pop != '[') {
                        cur.append(pop);
                    } else {
                        //取出 [ 前面的数字，有可能是多个，如100[abc]
                        String numString = "";
                        while (!stack.isEmpty() && stack.peek() >= '0' && stack.peek() <= '9'){
                            numString = stack.pop() + numString;
                        }
                        int num = Integer.parseInt(numString);

                        StringBuilder temp = new StringBuilder(cur);
                        for (int i = 1; i < num; i++) {
                            cur.append(temp);
                        }
                        char[] cc = cur.toString().toCharArray();
                        for(int i = cc.length - 1; i >= 0; i--){
                            stack.push(cc[i]);
                        }
                        break;//end while
                    }
                }
            }
        }

        char[] res = new char[stack.size()];
        int i = stack.size() - 1;
        while (!stack.isEmpty()){
            res[i--] = stack.pop();
        }

        return String.valueOf(res);
    }


    @Test
    public void test() {
        String s = "30[laoyue]";
        System.out.println(decodeString2(s));
    }
}
