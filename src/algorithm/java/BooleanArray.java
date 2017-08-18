package algorithm.java;

/************************************************************************************
 * 功能描述：高效布尔数组的实现
 * 创建人：
 * 创建时间： 2017年08月18日 --  下午7:19 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class BooleanArray {

    //数组的大小
    private int size;

    //内部维护布尔数组的字节数组
    private byte[] array;

    //字节数组的大小
    private int length;

    /**
     * 私有化构造器
     */
    private BooleanArray() {
    }

    /**
     * 构造器
     * <p>
     * 由于每个byte有8位，可以保存8个状态（true或false）
     * 所以内部array只需要size / 8 + 1的大小即可
     *
     * @param size
     */
    public BooleanArray(int size) {
        this.size = size;
        length = (size >> 3) + 1;
        array = new byte[length];
    }

    /**
     * 获取某位置的值
     * <p>
     * 首先，计算index的元素在byte数组的位置： i = index / 8，然后再计算位于byte[i]的哪一位上：mod = index % 8
     * <p>
     * 如，index = 13的时候，i = 13 / 8 = 1，即位于byte[1]上；
     * 再看byte[1]（假设为 0 1 0 0 1 1 1 0 ）的从右边起的下标为mod = 13 % 8 = 5 的位上是1还是0：
     * 用1进行左移5位，即0 0 0 0 0 0 0 1 变为 0 0 1 0 0 0 0 0
     * 将0 0 1 0 0 0 0 0
     * 与0 1 0 0 1 1 1 0
     * 进行&运算：只有同时为1，结果才为1，所以0 0 1 0 0 0 0 0 & 0 1 0 0 1 1 1 0  = 0 0 0 0 0 0 0 0
     * 即mod位上是0，即false
     *
     * @param index 布尔数组的下标
     * @return 值，true或false
     */
    public boolean get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        int i = index >> 3;
        int mod = index & ((1 << 3) -1);//余数
        return (array[i] & (1 << mod)) != 0;
    }

    /**
     * 设置index位置的元素值
     * 与get时相同，计算处该元素位于byte[]的哪个下标，哪个位
     *
     * @param index
     * @param value
     */
    public void set(int index, boolean value) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        int i = index >> 3;
        int mod = index & ((1 << 3) -1);//余数，mod取值范围为0~7

        if (value) {//将mod位设为1
            array[i] = (byte) (1 << mod | array[i]);
        } else {//将mod位设为0
            array[i] = (byte) (~(1 << mod) & array[i]);
        }
    }

    public int size() {
        return size;
    }


}
