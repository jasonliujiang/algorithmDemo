package offer;

import java.util.ArrayList;

/**
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class o49 {
    /**
     * 创建一个数组，依次*2，*3，*5.记录三个指针，判断
     * @param index
     * @return
     */
    public int GetUglyNumber_Solution(int index) {
        if (index == 0){
            return 0;
        }
        ArrayList<Integer> resultList = new ArrayList<>();
        resultList.add(1);
        int count = 0;

        //记录要相乘的因子指针。
        int index2 = 0,index3 = 0,index5 = 0;



        while (count<=index){
            int minVal = getMin(resultList.get(index2)*2,resultList.get(index3)*3,resultList.get(index5)*5);
            resultList.add(minVal);

            while (resultList.get(index2)*2<=minVal){
                index2++;
            }

            while (resultList.get(index3)*3<=minVal){
                index3++;
            }

            while (resultList.get(index5)*5<=minVal){
                index5++;
            }

            count++;

        }

        return resultList.get(index);


    }

    public int getMin(int A,int B,int C){

        return Math.min(Math.min(A,B),C);
    }
}
