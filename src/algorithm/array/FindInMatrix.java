package algorithm.array;

import org.junit.Assert;
import org.junit.Test;

/************************************************************************************
 * 功能描述：
 *
 * 在一个m行n列二维数组中，
 * 每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，
 * 判断数组中是否含有该整数。
 *
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2017年08月25日 --  上午9:09 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class FindInMatrix {

    /**
     * 二维数组matrix中是否包含数字a
     * <p>
     * 二分查找
     *
     * todo
     * 代码有误
     *
     * @param matrix 假如有m行n列
     * @param a
     * @return
     */
    public boolean contains(int[][] matrix, int a, int mTop, int mBottom, int nLeft, int nRight) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        if(mTop > mBottom || nLeft > nRight){
            return false;
        }

        int nMiddle = nLeft + ((nRight - nLeft) >> 1);
        int mMiddle = mTop + ((mBottom - mTop) >> 1);


        // TODO: 2017/8/25 杨氏矩阵查找的二分查找

        /*if (matrix[mMiddle][nMiddle] > a) {//行列均减小
            return contains(matrix, a, mTop, mBottom, nLeft, nMiddle-1)
                    || contains(matrix, a, mTop, mMiddle-1, nMiddle, nRight);
        }else if(matrix[mMiddle][nMiddle] < a){
            return contains(matrix, a, mTop, mBottom, nMiddle+1, nRight )
                    || contains(matrix, a, mMiddle+1, mBottom, nLeft, nMiddle-1);
        }else {
            return true;
        }*/

        return false;
    }



    /**
     * 二维数组matrix中是否包含数字a
     *
     * 定位法
     *
     * @param matrix
     * @param a
     * @return
     */
    public boolean contains2(int[][] matrix, int a){
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        //从右上角开始（也可以从左下角开始）
        int m = 0, n = matrix[0].length -1 ;
        while(m < matrix.length && n >= 0){
            if(matrix[m][n] > a){
                n--;
            }else if(matrix[m][n] < a){
                m++;
            }else {
                return true;
            }
        }

        return false;
    }

    @Test
    public void test(){
        //定义一个5行4列的二维数组
        int[][] matrix = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}, {17,18,19,20}};
        //Assert.assertTrue(contains(matrix, 1, 0, 4, 0, 3));
        //Assert.assertTrue(contains(matrix, 3, 0, 4, 0, 3));
        Assert.assertTrue(contains(matrix, 15, 0, 4, 0, 3));
        Assert.assertFalse(contains(matrix, 21, 0, 4, 0, 3));
        Assert.assertFalse(contains(matrix, 24, 0, 4, 0, 3));
        Assert.assertTrue(contains(matrix, 19, 0, 4, 0, 3));

        Assert.assertTrue(contains2(matrix, 1));
        Assert.assertTrue(contains2(matrix, 14));
        Assert.assertTrue(contains2(matrix, 12));
        Assert.assertTrue(contains2(matrix, 19));
        Assert.assertTrue(contains2(matrix, 7));
        Assert.assertFalse(contains2(matrix, 21));
        Assert.assertFalse(contains2(matrix, 24));


    }
}
