package algorithm.quickSort;

public class quickSort {
    public static void main(String[] args) {

        int[] num = {3,45,78,64,52,11,64,55,99,11,18};
        System.out.println(arrayToString(num,"未排序"));
        quickSort(num,0,num.length-1);
        System.out.println(arrayToString(num,"排序"));
        System.out.println("数组个数："+num.length);

    }

    public static int partition(int[] arr, int start, int end){

        //默认以开始的值为基准值
        int target = arr[start];
        int x = start;
        int y = end;
        while (x < y){
            while (arr[y] > target && x < y){
                --y;
            }

            if (x < y){
                arr[x] = arr[y];
                x++;
            }

            while (arr[x] < target && x < y){
                ++x;
            }

            if (x < y){
                arr[y] = arr[x];
                y--;
            }

        }

        arr[x] = target;
        return x;
    }

    private static void quickSort(int[] arr, int start, int end){
        //从小到大排序
        if (start >= end){
            return;
        }

        int index = partition(arr, start, end);
        quickSort(arr,start,index-1);
        quickSort(arr,index+1,end);
    }

    /**
     * 交换数组下标AB的位置
     * @param arr
     * @param a
     * @param b
     * @return
     */
    public static int[] changeElecment(int[] arr,int a, int b){

        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;

        return arr;
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
