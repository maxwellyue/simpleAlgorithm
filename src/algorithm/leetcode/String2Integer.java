package algorithm.leetcode;

/************************************************************************************
 * 功能描述：
 *
 * Implement atoi to convert a string to an integer.
 *
 * Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.
 *
 * Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.
 *
 * Update (2015-02-10):
 * The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button  to reset your code definition.
 *
 * spoilers alert... click to show requirements for atoi.
 *
 * Requirements for atoi:
 *
 *
 * The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
 *
 * The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
 *
 * If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
 *
 * If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
 *
 *
 *
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2018年01月16日 --  下午5:17 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class String2Integer {

    /**
     *
     * 来自：https://leetcode.com/problems/string-to-integer-atoi/discuss/4643
     *
     * 正负号一般都能处理
     *
     * 边界的判断不要使用 num  > Integer.MAX_VALUE 这种形式，因为此时num已经越界，
     * 而是使用 num的前一步 > Integer.MAX_VALUE / 10这种形式
     *
     *
     * @param str
     * @return
     */
    public int myAtoi(String str) {
        int i = 0;
        str = str.trim();
        char[] c = str.toCharArray();

        int sign = 1;
        if (i < c.length && (c[i] == '-' || c[i] == '+')) {
            if (c[i] == '-') {
                sign = -1;
            }
            i++;
        }

        int num = 0;
        int bound = Integer.MAX_VALUE / 10;
        while (i < c.length && c[i] >= '0' && c[i] <= '9') {
            int digit = c[i] - '0';
            if (num > bound || (num == bound && digit > 7)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            num = num * 10 + digit;
            i++;
        }
        return sign * num;
    }


}
