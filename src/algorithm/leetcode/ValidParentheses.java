package algorithm.leetcode;

import org.junit.Test;

import java.util.Stack;

/************************************************************************************
 * 功能描述：
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 *
 * 其实，"([])"这种字符串也是符合要求的，题目描述的不够准确
 *
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2018年01月02日 --  下午5:13 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class ValidParentheses {

    /**
     *
     *
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if(s.isEmpty() || s.length() % 2 != 0){
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){

            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
                stack.push(s.charAt(i));
            }else{//非([{这三个字符
                if(stack.isEmpty()){
                    return false;
                }

                Character pop = stack.pop();
                if(s.charAt(i) == ')' && pop != '('){
                    return false;
                }
                if(s.charAt(i) == ']' && pop != '['){
                    return false;
                }
                if(s.charAt(i) == '}' && pop != '{'){
                    return false;
                }
            }
        }

        //最后，如果栈不为空，说明还含有开始符号没有与之匹配的结束符号，则为false
        return stack.isEmpty();
    }

    @Test
    public void test(){
        System.out.println(isValid("()"));
    }

}
