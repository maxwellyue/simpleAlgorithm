package algorithm.leetcode;

/************************************************************************************
 * 功能描述：
 *
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * Example 1:
 *
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 *
 *
 *
 * Example 2:
 *
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 *
 *
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2018年01月02日 --  上午9:48 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class ImplementstrStr {

    public int strStr(String haystack, String needle) {
        if(haystack.isEmpty() || needle.isEmpty()){
            return -1;
        }

        char[] chars = haystack.toCharArray();
        char[] needleChars = needle.toCharArray();

        for(int i = 0; i < chars.length; i++){
            boolean contains = true;
            for(int j = 0; j < needleChars.length; j++){
                if(needleChars[j] != chars[i + j]){
                    contains = false;
                }
            }
            if (contains){
                return i;
            }
        }
        return -1;
    }

}
