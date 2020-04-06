package datastructure.find;

public class recursionBinarySearch {
    public static int recursionBinarySearch(int[] arr,int key,int low,int high){
        if (key<arr[low] || key>arr[high] || low>high){
            return -1;
        }
        while (low<high){
            int mid = (low+high)/2;
            if (key==arr[mid]){
                return mid;
            }else if (arr[mid]>key){
                return recursionBinarySearch(arr,key,low,mid-1);
            }else {
                recursionBinarySearch(arr,key,mid+1,high);
            }
        }
        return -1;
    }
}
