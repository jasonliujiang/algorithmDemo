package offer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class o40 {
    /**
     * 构建最大堆，只保留最小的k个数，适合处理海量数据
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int length = input.length;
        if(k > length || k == 0){
            return result;
        }
        //用优先级队列来实现堆    需要设置比较器为逆序来实现最大堆。默认为最小堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, Comparator.reverseOrder());
        for (int i = 0; i < length; i++) {
            if (maxHeap.size() != k) {
                maxHeap.offer(input[i]);
            } else if (maxHeap.peek() > input[i]) {
                Integer temp = maxHeap.poll();
                temp = null;
                maxHeap.offer(input[i]);
            }
        }
        for (Integer integer : maxHeap) {
            result.add(integer);
        }
        return result;
    }
}
