package datastructure.find;

public class commonBinarySearch {
    private static int commonBinarySearch(int[] arr , int key){

        int low = 0;
        int high = arr.length-1;
        int mid = 0;
        if (key<arr[low] || key>arr[high] || low>high){
            return -1;
        }
        while (low<high){
            mid = (low+high)/2;

            if (arr[mid] == key){
                return mid;
            }else if (arr[mid]>key){
                high = mid-1;
            }else {
                low = mid+1;
            }
        }
        return -1;


    }

    /**
     * 标准求平均值公式，防溢出
     * @param x
     * @param y
     * @return
     */
    public static int mean(int x, int y){
        return (x & y) + ((x ^ y) >> 1);
    }
}
