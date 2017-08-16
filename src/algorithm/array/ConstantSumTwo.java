package algorithm.array;

/************************************************************************************
 * 功能描述：输入一个数组和一个数，在数组中查找两个数，使这两个数的和等于输入的那个数。
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2017年08月15日 --  下午7:30 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class ConstantSumTwo {

    /**
     * 暴力循环：枚举所有的情况（无论有序、无序都可以）
     *
     * @param array
     * @param a
     */
    public void constantSum1(int[] array, int a) {
        //判空代码...
        //核心代码
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                if (array[i] + array[j] == a) {
                    System.out.println(array[i] + "  and  " + array[j]);
                }
            }
        }
    }


    /**
     * 指针两端扫描
     *
     * @param array
     * @param a
     */
    public void constantSum2(int[] array, int a) {
        //判空代码...

        //如果数组无序，需要先进行排序

        //核心代码
        int head = 0;
        int hail = array.length - 1;

        while(head < hail){
            int currentSum = array[head] + array[hail];
            if(currentSum == a){
                System.out.println(array[head] + "  and  " + array[hail]);
                break;
            }else if(currentSum > a){
                hail--;
            }else{
                head++;
            }
        }
    }


}
