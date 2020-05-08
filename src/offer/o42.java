package offer;

/**
 * 连续子数组的最大和
 */
public class o42 {
    public static int FindGreatestSumOfSubArray(int[] array) {
        //如果前几个数的和小于当前数，则放弃前面的和，从当前位置开始。
        if (array.length<=0&&array == null){
            return 0;
        }
        //当前子数组的和
        int count = 0;
        //最优和
        int maxSum = 0x80000000;
        for (int i = 0; i < array.length; i++) {
            if (count<=0){
                count = array[i];
            }else {
                count += array[i];
            }

            if (count>maxSum){
                maxSum = count;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,8,1,5,9};
        //System.out.println(FindGreatestSumOfSubArray(arr));
        System.out.println("123891".compareTo("111111"));
    }
}
