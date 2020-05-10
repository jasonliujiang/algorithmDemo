package offer;

import java.util.ArrayList;

/**
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 */
public class o57_2 {
    /**
     * 参考上题思路，创建两个游标，依次的扩大范围和缩小范围
     * @param sum
     * @return
     */
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> resultList = new ArrayList<>();

        int[] arr = new int[sum/2+1];

        int start = 1;
        int end = 2;
        while (start<(sum/2+1)){
            if (getSumFrom(start,end)<sum){
                end++;
            } else if (getSumFrom(start, end) > sum) {
                start++;
            }else {//判断相等
                resultList.add(addListSum(start,end));
                start++;

            }
        }
        return resultList;
    }

    private int getSumFrom(int start, int end) {
        int sum = 0;
        while (start<=end){
            sum = sum+start;
            start++;
        }
        return sum;
    }

    private ArrayList<Integer> addListSum(int start,int end){
        ArrayList<Integer> tmp = new ArrayList<>();
        while (start<=end){
            tmp.add(start);
            start++;
        }
        return tmp;
    }
}
