package offer;
import java.util.*;
/*
* 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
* */
public class o11 {
    //采用2分查找法的变种
    public int minNumberInRotateArray(int [] array) {
        if (array.length == 0){
            return 0;
        }
        int left = 0;
        int right = array.length-1;

        while (left<right){
            //采用非递归的形式，数组下标，求偏移量来获取中间值
            int mid = (right-left)/2+left;
            //如果大于右边，则一定在右边的递增数组中
            if (array[mid]>array[right]){
                left = mid+1;
                //出现相同数字，可能是0 1 1 1 1数组，只能递归判断
            }else if (array[mid]==array[right]){
                right = right-1;
            }else {
                right = mid;
            }
        }
        return array[left];


    }
}
