package algorithm.string;

import org.junit.Test;

/************************************************************************************
 * 功能描述：判断字符串是否是回文：正反读都一样，如"aba"、"我是我"、"123321"等
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2017年08月14日 --  下午9:01 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class StringPalindrome {

    /**
     * 从两边向中间扫描
     * @param s
     * @return
     */
    public boolean isPalindrome1(String s){
        //判空
        if(s == null || s.length() ==0){
            return true;
        }

        int head = 0;//头
        int hail = s.length() -1;//尾
        while (head < hail){
            if(s.charAt(head) != s.charAt(hail)){
                return false;
            }
            head ++;
            hail --;
        }

        return true;
    }

    /**
     * 从中间向两边扫描
     * @param s
     * @return
     */
    public boolean isPalindrome2(String s){
        //判空
        if(s == null || s.length() <= 1){
            return true;
        }

        int l = s.length();

        int middle = l >> 1 >= 0 ? l >> 1 : 0;

        int right= l % 2 == 0 ? l / 2 : l / 2 + 1;//向右
        int left = l / 2 - 1;//向左

        while (left >= 0){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left --;
            right ++;
        }

        return true;
    }

    @Test
    public void test(){
        String s = "12421";
        System.out.println(isPalindrome1(s));
        System.out.println(isPalindrome2(s));

    }





}
