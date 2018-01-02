package algorithm.leetcode;

/************************************************************************************
 * 功能描述：
 *
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth term of the count-and-say sequence.
 *
 * Note: Each term of the sequence of integers will be represented as a string.
 *
 * Example 1:
 *
 * Input: 1
 * Output: "1"
 * Example 2:
 *
 * Input: 4
 * Output: "1211"
 *
 * 题目描述：
 *
 * 按照一定的规则以字符串的形式读出数字，
 * 规定第一个是1，接下去就是按照前一个数的读法记录，
 * 所以第二个就是1个1，记录为11，那第三个就是对11的读法就是2个1，记录为21，
 * 第四个就是对21的读法，一个2一个1，记录为1211，
 * 依次类推
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 6.     312211
 * 7.     13112221
 * 8.     1113213211
 * 9.     31131211131221
 * 10.    13211311123113112211
 *
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2018年01月02日 --  上午11:37 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class CountAndSay {

    /**
     * 递归
     *
     * @param n
     * @return
     */
    public String countAndSay(int n) {
        if (n == 0) {
            return "";
        }

        //递归出口
        if (n == 1) {
            return "1";
        }

        //上一次的字符串，即n-1对应的字符串
        String previous = countAndSay(n - 1);

        //n对应的字符串为sb
        StringBuilder sb = new StringBuilder();

        // 对n-1对应的字符串进行循环，拼出n对应的字符串
        char last = previous.charAt(0); // 通过记录上次的字符来判断是否重复
        int count = 1;//计数器，记录当前字符连续出现的次数
        for (int i = 1; i < previous.length(); i++) {
            if (previous.charAt(i) == last) {
                count++;
            } else {
                sb.append(count);
                sb.append(last);
                count = 1;
                last = previous.charAt(i);
            }
        }

        // 最后记得把最后的字符加上（因为上面的循环中，并没有拼接最后的连续字符）
        sb.append(count);
        sb.append(last);

        return sb.toString();
    }

    /**
     * 非递归
     *
     * 每次循环，读取上次的计算结果，根据上次的结算结果来计算本次的读法，并更新当前计算结果
     *
     *
     * @param n
     * @return
     */
    public String countAndSay2(int n) {
        if (n == 0) {
            return "";
        }

        String s = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            char last = s.charAt(0);
            int count = 1;
            for (int j = 1; j < s.length(); j++) {
                if (s.charAt(j) == last) {
                    count++;
                } else {
                    sb.append(count);
                    sb.append(last);
                    last = s.charAt(j);
                    count = 1;
                }
            }
            sb.append(count);
            sb.append(last);
            s = sb.toString();
        }

        return s;

    }


}
