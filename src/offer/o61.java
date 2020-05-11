package offer;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 5张扑克牌中的顺子
 * 大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13
 */
public class o61 {
    public boolean isContinuous(int [] numbers) {
        if (numbers == null || numbers.length<=0){
            return false;
        }

        //先排序
        Arrays.sort(numbers);

        int countZero = 0;

        //两数的差值和
        int countNum = 0;

        //判断大小王即0的个数
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0){
                countZero++;
            }

        }

        if (countZero>2){
            return false;
        }

        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == 0){
                continue;
            }
            int dif = compareNums(numbers[i],numbers[i+1]);
            //注意对子的情况
            if (dif == 0){
                return false;
            }
            countNum += dif-1;

        }

        return countZero >= countNum;





    }

    /**
     * 判断数组相邻数之间的差值
     * @param a
     * @param b
     * @return
     */
    public int compareNums(int a,int b){
        return b-a;
    }
}
