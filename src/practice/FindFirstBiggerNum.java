package practice;

import java.util.Stack;

/**
 * 给出一组数，找出数组中每个数的右边第一个比它大的数
 */
public class FindFirstBiggerNum {
    public  int[] findMax(int[] array) {
        int len =array.length;
        Stack<Integer> st = new Stack<Integer>();
        int res[]=new int[len];
        int i=0;
        while(i<len) {
            if(st.isEmpty()||array[i]<=array[st.peek()]) {
                st.push(i);
                i++;
            }else {
                res[st.pop()]=array[i];

            }
        }
        while(!st.isEmpty()) {
            res[st.pop()]=-1;
        }
        return res;
    }


}
