package offer;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 */
public class o51 {
    /**
     * 采用归并排序的思想，由小到大的依次进行比较
     *
     * @param array
     * @return
     */
    public int InversePairs(int[] array) {
        /*
        *
            合并时，出现前面的数组值array[i]大于后面数组值array[j]时；则前面
            数组array[i]~array[mid]都是大于array[j]的，count += mid+1 - i
            参考剑指Offer，但是感觉剑指Offer归并过程少了一步拷贝过程。
            还有就是测试用例输出结果比较大，对每次返回的count mod(1000000007)求余
        * */


        if (array == null || array.length == 0) {
            return 0;
        }
        int[] copy = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            copy[i] = array[i];
        }
        int count = InversePairsCore(array, copy, 0, array.length - 1);//数值过大求余
        return count;

    }

    private int InversePairsCore(int[] array, int[] copy, int start, int end) {
        if (start == end) {
            return 0;
        }

        int mid = (start + end) / 2;

        int leftCount = InversePairsCore(array, copy, start, mid) % 1000000007;
        int rightCount = InversePairsCore(array, copy, mid + 1, end) % 1000000007;

        int count = 0;
        int i = mid;
        int j = end;
        int locCopy = end;

        while (i >= start && j > mid) {


            if (array[i] > array[j]) {
                count += j - mid;
                copy[locCopy--] = array[i--];
                if (count >= 1000000007)//数值过大求余
                {
                    count %= 1000000007;
                }
            } else {
                copy[locCopy--] = array[j--];
            }
        }

        for(;i>=start;i--)
        {
            copy[locCopy--]=array[i];
        }
        for(;j>mid;j--)
        {
            copy[locCopy--]=array[j];
        }
        for(int s=start;s<=end;s++)
        {
            array[s] = copy[s];
        }
        return (leftCount+rightCount+count)%1000000007;

    }
}

