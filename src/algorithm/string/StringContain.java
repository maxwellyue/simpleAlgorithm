package algorithm.string;

import org.junit.Test;

/************************************************************************************
 * 功能描述：
 *
 * 字符串A是否包含字符串B中的所有字母(假设均为大写)
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2017年08月14日 --  下午7:05 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class StringContain {

    /**
     * 暴力循环
     *
     * @param a
     * @param b
     * @return
     */
    public boolean contain1(String a, String b) {

        //判空处理代码......

        //核心代码
        for (int i = 0; i < b.length(); i++) {
            for (int j = 0; j < a.length(); j++) {
                //如果有相等的元素出现，则跳出该循环（内层对a的循环）
                if (a.charAt(j) == b.charAt(i)) {
                    break;
                }

                //到了a中最后一个元素，且还没有相等的元素出现，说明没有相等的字母出现
                if (j == a.length() - 1) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * 先排序，再循环
     *
     * @param a
     * @param b
     * @return
     */
    public boolean contain2(String a, String b) {
        //先对a,b中的字母排序，使其都按照abcd...的顺序排列

        //核心代码
        for (int i = 0; i < b.length(); i++) {

            for (int j = 0; j < a.length(); j++) {
                if (a.charAt(j) == b.charAt(i)) {
                    break;
                }

                //如果a的第j个字母大于了b的第i个元素，还没有结束内层循环，
                //由于排序，a后面不可能再有与b的第i个元素相等的元素
                if (a.charAt(j) > b.charAt(i)) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * 素数法
     *
     *
     * @param a
     * @param b
     * @return
     */
    public boolean contain3(String a, String b) {
        int[] primeNumber = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};

        //求出a的素数积
        int result = 1;
        for (int i = 0; i < a.length(); i++) {
            int x = primeNumber[a.charAt(i) - 'A'];
            if (result % x != 0) {//去掉重复的字母
                result *= x;
            }
        }

        for (int i = 0; i < b.length(); i++) {
            int x = primeNumber[b.charAt(i) - 'A'];
            if (result % x != 0) {
                return false;
            }
        }
        return true;
    }


    @Test
    public void test() {
        String a = "ABCD";
        String b = "S";
        System.out.println(contain1(a, b));
        System.out.println(contain2(a, b));
        System.out.println(contain3(a, b));
    }
}
