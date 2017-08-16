package algorithm.string;

import org.junit.Test;

/************************************************************************************
 * 功能描述：求一个字符串的最长回文子字符串
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2017年08月15日 --  下午6:05 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class StringLongestPalindrome {

    /**
     * 字符串是回文的话，则中心两边一定相等，进行枚举中心（分奇偶两种情况）
     * 难点：左右两边下标与中心下标的关系，越界情况，回文长度的计算
     * @param s
     * @return
     */
    public int longestPalindrome(char[] s){
        if(s == null || s.length ==0){
            return 0;
        }

        int l = s.length;
        int max = 0;

        //以s中的每个元素作为中心：对于每个中心，分为回文字符串长度不为奇、偶两种情况
        for (int i = 0; i < l; i++){//i即中心

            //为偶数的情况
            for(int j = i; (j >= 0) && (2*i + 1 -j < l); j--){

                if(s[j] != s[2*i + 1 - j]){
                    break;
                }

                int c = 2*(i - j + 1);//回文长度
                if( c > max){
                    max = c;
                }
            }


            //为奇数的情况
            for(int j = i-1; (j >= 0) && (2*i - j < l); j--){//从中心的左边一个元素开始循环

                if(s[j] != s[2*i - j]){
                    break;
                }

                int c = 2*(i - j) + 1;//回文长度
                if( c > max){
                    max = c;
                }
            }
        }

        return max;
    }

    @Test
    public void test(){
        String s = "1234abcbaa46999";
        System.out.println(longestPalindrome(s.toCharArray()));
    }
}
