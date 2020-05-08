package offer;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class o39 {
    //简单解法是先排序后查找。如果超过数组长度的一半，则一定是排序后的数组中位数
    public int MoreThanHalfNum_Solution(int[] array) {
        if (CheckInvalidArray(array)) {
            return 0;
        }
        int len = array.length;
        int middle = len / 2;
        int start = 0;
        int end = len - 1;
        int index = partition(array, start, end);
        while (index != middle) {
            if (index < middle) {
                start = index + 1;
                index = partition(array, start, end);
            }else {
                end = index-1;
                index = partition(array,start,end);
            }
        }
        int result = array[middle];
        if (!CheckMoreThanHalf(array,result)){
            result = 0;
        }
        return result;

    }

    /**
     * 判断最长的是否超过数组的半数
     * @param array
     * @param result
     * @return
     */
    private boolean CheckMoreThanHalf(int[] array, int result) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == result){
                count++;
            }
        }
        if (count*2<=array.length){
            return false;
        }else {
            return true;
        }
    }

    /**
     * 判断无效输入
     * @param array
     * @return
     */
    private boolean CheckInvalidArray(int[] array) {
        if (array == null || array.length<=0){
            return true;
        }

        return false;

    }

    private int partition(int[] num, int start, int end) {

        int target = num[start];
        int i = start;
        int j = end;
        while (i < j) {
            while (num[j] >= target && i < j) {
                j--;
            }

            while (num[i] <= target && i < j) {
                i++;
            }

            if (i < j) {
                int temp = num[i];
                num[i] = num[j];
                num[j] = temp;
            }
        }

        num[start] = num[i];
        num[i] = target;


        return i;
    }

    /**
     * 因为超过半数，所有目标数比所有的数加起来还要多
     * @param array
     * @return
     */
    public int MoreThanHalfNum_Solution2(int[] array) {

        if (CheckInvalidArray(array)) {
            return 0;
        }
        //一个记录数组中的数，一个记录次数；遇到不相同的次数减一，遇到相同的次数加一；
        int result = array[0];
        int times = 1;
        for (int i = 0; i < array.length; ++i) {
            if (times == 0){
                result = array[i];
                times = 1;
            }

            if (array[i] == result){
                times++;
            }
            else {
                times--;
            }

        }
        if (!CheckMoreThanHalf(array,result)){
            result = 0;
        }
        return result;

    }
}
