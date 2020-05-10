package offer;

/**
 * 统计一个数字在排序数组中出现的次数。
 */
public class o53 {
    /**
     * 可以采用二分查找的方法来实现
     * 但是数字可能重复，无法确定找到的数字是否是第一个数字
     * 下面对二分查找进行优化
     * @param array
     * @param k
     * @return
     */
    public int GetNumberOfK(int [] array , int k) {
        if (array == null||array.length<=0){
            return -1;
        }

        int start = 0;
        int end = array.length-1;
        int count = 0;
        if (array[start]>k || array[end]<k){
            return -1;
        }
        int indexFirst = getNumberFirst(array,start,end,k);
        for (int i = indexFirst; i < end; i++) {
            if (array[i] == k) {

                count++;
            }
        }
        return count;


    }

    /**
     * 查询k元素在排序数组中第一次的位置
     * @param array
     * @param start
     * @param end
     * @param k
     * @return
     */
    private int getNumberFirst(int[] array, int start, int end, int k) {
        int midle = (start+end)/2;

        if (array[midle] > k){
            return getNumberFirst(array,start,midle-1,k);
        }else if (array[midle] < k){
            return getNumberFirst(array,midle+1,end,k);
        }else {//相等的情况

            //如果前一位也等于k ,说明第一次出现在midle的前面
            if (midle-1>=0&&array[midle-1] == k){
                return getNumberFirst(array,start,midle-1,k);
            }else {
                return midle;
            }
        }

    }


}
