package practice;

import java.util.Scanner;

/*
* 输入一个无序整数数组，调整数组中数字的顺序， 所有偶数位于数组的前半部分，使得所有奇数位于数组的后半部分。
   要求时间复杂度为O(n)。
* */
public class ArrayPractice {

    public static void Solution(int[] array){
        //非空判断
        if (array == null || array.length == 0){
            return;
        }
        //采用快排的思想
        int low = 0;
        int high = array.length-1;
        //判断奇偶 &1=0偶数  &1=1奇数
        while(low<high){
            while(low<high&&(array[low]&1) == 0){
                low++;
            }
            while(low<high&&(array[high]&1) == 1){
                high--;
            }
            int temp = array[low];
            array[low] = array[high];
            array[high] = temp;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strArray = str.split(" ");
        int[] intArray = new int[strArray.length];
        for (int i =0;i<strArray.length;i++){
            intArray[i] = Integer.parseInt(strArray[i]);
        }
        Solution(intArray);
        for (int i =0;i<strArray.length;i++){
            System.out.print(intArray[i] + " ");
        }
    }

}
