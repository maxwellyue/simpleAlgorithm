package algorithm.string;

import org.junit.Test;

/************************************************************************************
 * 功能描述：字符串全排列
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2017年08月15日 --  上午9:37 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class StringFullPermutation {

    public void fullPermutation(String s){
        char[] chars = s.toCharArray();
        permutation(chars, 0);
    }

    public void permutation(char[] s, int from){
        //判空处理
        if(s.length <=1){
            return;
        }

        if(from == s.length -1){//递归出口
            System.out.print(String.valueOf(s));
            System.out.println();
        }else {//循环
            for (int i = from; i < s.length; i++){
                swap(s, i, from);
                permutation(s, from + 1);
                swap(s, i, from);
            }
        }
    }

    public void swap(char[] s, int m, int n){
        char temp = s[m];
        s[m] = s[n];
        s[n] = temp;
    }

    @Test
    public void test(){
        String s = "abcd";
        fullPermutation(s);
    }




}
