package offer;

/**
 * 股票的最大利润
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可获得的最大利润是多少？
 * 例如，一只股票在某些时间节点的价格为{9,11,8,5,7,12,16,14}。
 */
public class o63 {
    public int MaxDiff(int[] array){
        //记录扫描过的数组中的最小值
        int minVal = array[0];

        int maxResult = array[1]-minVal;
        for (int i = 1; i < array.length; i++) {
            if (minVal>array[i]){
                minVal = array[i];
                continue;
            }

            maxResult = Math.max(maxResult,array[i]-minVal);

        }

        return maxResult;


    }
}
