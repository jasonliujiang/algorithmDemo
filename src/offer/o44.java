package offer;

/**
 * 数字序列中某一位的数字
 * 数字以0123456789101112131415.。。。。的格式序列化到一个字符序列中。请写一个函数求任意第n位对应的数字
 */
public class o44 {
    public int digitAtIndex(int index) {

        if (index < 0) {
            return -1;
        }

        int digits = 1;

        while (true) {
            int numbers = countOfIntrgers(digits);
            if (index < numbers * digits) {
                return digitAtindexHelper(index, digits);
            }

            index -= numbers * digits;

            digits++;
        }

    }

    /**
     * 已经确定是哪一位的了，继续判断是第几个数字
     *
     * @param index
     * @param digits
     * @return
     */
    private int digitAtindexHelper(int index, int digits) {

        //计算出是第几个数字：如数字是370
        int number = beginNumber(digits) + index / digits;

        //计算是这个数字的右数第几位
        int indexFromRight = digits - index % digits;

        for (int i = 1; i < indexFromRight; i++) {
            number /= 10;
        }

        return number%10;

    }

    /**
     * 返回n位数总共有多少个数字
     *
     * @param digits
     * @return
     */
    public int countOfIntrgers(int digits) {
        if (digits == 1) {
            return 10;
        }
        int count = (int) Math.pow(10, digits - 1);
        return 9 * count;
    }


    /**
     * 返回第一个m位数
     *
     * @param digits
     * @return
     */
    public int beginNumber(int digits) {
        if (digits == 1) {
            return 0;
        }

        return (int) Math.pow(10, digits - 1);
    }

}
