package algorithm.string;

import org.junit.Test;

/************************************************************************************
 * 功能描述：将字符串"123"转换为整数123
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2017年08月14日 --  下午8:34 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class String2Int {

    /**
     * 从左到右，将之前得到的数乘以10，再相加
     * 主要是各种非正常情况的判断，尤其是溢出，要提前判断
     * @param s
     * @return
     */
    public int string2Int(String s){

        //判空
        if(s == null && s.length() ==0){
            return 0;
        }

        //起始位置
        int start = 0;

        //正负判断
        boolean negative = false;
        if(s.charAt(0) == '-'){
            negative = true;
            start = 1;
        }
        if(s.charAt(0) == '+'){
            negative = false;
            start = 1;
        }


        int result = 0;

        for (int i = start; i < s.length(); i++){
            //非法输入
            if(s.charAt(i) < '0' || s.charAt(i) > '9'){
                return 0;//实际中应该抛出异常
            }

            int a = s.charAt(i) - '0';

            //溢出：提前判断
            if((Integer.MAX_VALUE - a) / 10 < result){
                return Integer.MAX_VALUE;//实际中应该抛出异常
            }

            result = a + result*10;
        }

        return negative ? -result: result;
    }


    @Test
    public void test(){
        System.out.println(
                string2Int("12000789")
        );
    }
}
