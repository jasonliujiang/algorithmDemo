package datastructure.sort;

/**
 * 快速排序
 *
 * @author Jason
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] num = {3,45,78,64,52,11,64,55,99,11,18};
        System.out.println(arrayToString(num,"未排序"));
        QuickSort(num,0,num.length-1);
        System.out.println(arrayToString(num,"排序"));
        System.out.println("数组个数："+num.length);

    }

    private static void QuickSort(int[] num, int left, int right) {

        if (left>=right){
            return;
        }
        int index = partition(num,left,right);
        QuickSort(num,left,index-1);
        QuickSort(num,index+1,right);
    }

    private static int partition(int[] num, int start, int end) {

        int target = num[start];
        int i = start;
        int j = end;
        while (i<j){
            while (num[j]>=target&&i<j){
                j--;
            }

            while (num[i]<=target&&i<j){
                i++;
            }

            if (i<j){
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
     * 将一个int类型数组转化为字符串
     * @param arr
     * @param flag
     * @return
     */
    private static String arrayToString(int[] arr,String flag) {
        String str = "数组为("+flag+")：";
        for(int a : arr) {
            str += a + "\t";
        }
        return str;
    }

}
