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
        int target = num[left];
        int i = left;
        int j = right;
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

        num[left] = num[i];
        num[i] = target;
        QuickSort(num,left,i-1);
        QuickSort(num,i+1,right);
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
