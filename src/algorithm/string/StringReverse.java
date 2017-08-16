package algorithm.string;

import org.junit.Test;

/************************************************************************************
 * 功能描述：
 *
 * 将字符串s中的前a个字符移到后面
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2017年08月14日 --  下午6:12 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class StringReverse {

    /**
     * 暴力循环法
     * @param s
     * @param a
     * @return
     * @throws Exception
     */
    public char[] reverseSimple(char[] s, int a){

        if(s == null || s.length == 0 || a < 0){
            return  s;
        }

        int l = s.length;

        //核心代码：从第一个字符移动，移动完之后相当于对新的字符串，再从第一个移动；
        while(a > 0){
            char temp = s[0];
            for (int i = 1; i < l; i ++){
                s[i-1] = s[i];
            }
            s[l-1] = temp;
            a--;
        }
        return s;
    }

    /**
     * 三步反转法
     * @param s
     * @param a
     * @return
     * @throws Exception
     */
    public char[] reverseComplex(char[] s, int a){

        if(s == null || s.length == 0 || a <= 0){
            return  s;
        }

        int l = s.length;

        a = a > l ? l : a;

        //核心代码：先将前面的反转，再将后面的反转，再将整体反转
        reverse(s, 0, a-1);
        reverse(s, a, l-1);
        reverse(s, 0, l-1);
        return s;
    }

    /**
     * 将s中的字符从m到n进行反转
     * @param s
     * @param m
     * @param n
     */
    private void reverse(char[] s, int m, int n){
        while (m < n){
            char temp = s[m];
            s[m++] = s[n];
            s[n--] = temp;
        }
    }


    @Test
    public void test(){
        char[] s = {'a', 'b', 'c', 'd'};
        //System.out.println("结果：" + String.valueOf(reverseSimple(s, 2)));
        System.out.println("结果：" + String.valueOf(reverseComplex(s, 1)));

    }



}
