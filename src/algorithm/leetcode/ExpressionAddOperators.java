package algorithm.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/************************************************************************************
 * 功能描述：
 *
 * Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.
 *
 * Examples:
 * "123", 6 -> ["1+2+3", "1*2*3"]
 * "232", 8 -> ["2*3+2", "2+3*2"]
 * "105", 5 -> ["1*0+5","10-5"]
 * "00", 0 -> ["0+0", "0-0", "0*0"]
 * "3456237490", 9191 -> []
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2018年01月14日 --  下午4:13 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class ExpressionAddOperators {

    List<String> res = new LinkedList<>();
    public List<String> addOperators(String num, int target) {

        if (num == null || num.length() == 0) {
            return res;
        }
        add(num, target, 0, 0, "");
        return res;
    }

    /**
     *
     * 该方法并没有考虑"105", 5 -> ["1*0+5","10-5"]这种情况
     *
     * @param num
     * @param target
     * @param index
     * @param preSum
     * @param cur
     */
    private void add(String num, int target, int index, long preSum, String cur) {
        if (index == num.length() - 1) {
            if (preSum == target) {
                res.add(cur);
            }
        } else {
            //下一步：+
            add(num, target, index + 1, preSum + (num.charAt(index + 1) - '0'), cur + "+" + num.charAt(index + 1));
            //下一步：—
            add(num, target, index + 1, preSum - (num.charAt(index + 1) - '0'), cur + "-" + num.charAt(index + 1));
            //下一步：*
            if(cur.length() - 1 > 0){
                int lastNumber = num.charAt(index) - '0';
                char lastOperation = cur.charAt(cur.length() - 2);
                if(lastOperation == '+'){
                    preSum = preSum - lastNumber + lastNumber * (num.charAt(index + 1) - '0');
                }else if(lastOperation == '-'){
                    preSum = preSum + lastNumber - lastNumber * (num.charAt(index + 1) - '0');
                }else if(lastOperation == '*'){
                    preSum = preSum * (num.charAt(index + 1) - '0');
                }
                add(num, target, index + 1, preSum, cur + "*" + num.charAt(index + 1));
            }else {
                add(num, target, index + 1, preSum * (num.charAt(index + 1) - '0'), cur + "*" + num.charAt(index + 1));
            }
        }
    }


    /**
     *
     * 来自：https://leetcode.com/problems/expression-add-operators/discuss/71921
     *
     * @param num
     * @param target
     * @return
     */
    public List<String> addOperators2(String num, int target) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(res, sb, num, 0, target, 0, 0);
        return res;

    }

    /**
     *
     *
     *
     *
     * @param res 最终结果
     * @param sb 当前表达式
     * @param num 给出的数字字符串
     * @param pos 当前位置
     * @param target 目标数字
     * @param prev 前面所有计算的结果
     * @param multi 当前计算所进行的操作结果
     */
    public void dfs(List<String> res, StringBuilder sb, String num, int pos, int target, long prev, long multi) {
        if(pos == num.length()) {
            if(target == prev) res.add(sb.toString());
            return;
        }
        for(int i = pos; i < num.length(); i++) {
            if(num.charAt(pos) == '0' && i != pos) break;
            long curr = Long.parseLong(num.substring(pos, i + 1));
            int len = sb.length();
            if(pos == 0) {
                dfs(res, sb.append(curr), num, i + 1, target, curr, curr);
                sb.setLength(len);
            } else {
                dfs(res, sb.append("+").append(curr), num, i + 1, target, prev + curr, curr);
                sb.setLength(len);
                dfs(res, sb.append("-").append(curr), num, i + 1, target, prev - curr, -curr);
                sb.setLength(len);
                dfs(res, sb.append("*").append(curr), num, i + 1, target, prev - multi + multi * curr, multi * curr);
                sb.setLength(len);
            }
        }
    }

    @Test
    public void test(){
        String num = "232";
        int target = 8;
        List<String> strings = addOperators(num, target);
        int a  = 0;


    }

}
