package offer;

import java.util.ArrayList;

/**
 * 输入一个递增排序的数组和一个数字S，
 * 在数组中查找两个数，使得他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 */
public class o57 {
    /**
     *
     * @param array
     * @param sum
     * @return
     */
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> resultList = new ArrayList<>();
        int start = 0;
        int end = array.length-1;
        while (start<end){

            if (array[start]+array[end]>sum){
                end--;
            }else if (array[start]+array[end]<sum){
                start++;
            }else {
                resultList.add(array[start]);
                resultList.add(array[end]);
                return resultList;
                //start++;
                //end--;
            }

        }
        return resultList;

    }
}
