package offer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 */
public class o41 {
    //可以通过AVL树来实现，可以用logN的时间添加一个节点，用O（1）的时间得到中位数；但代码直接实现AVL树比较困难。
    //可以把要排序的数组分成两个部分，左边的为最大堆，右边的为最小堆。最后求中位数的时候只要求两个堆堆顶数的平均值就可以了。
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Comparator.reverseOrder());
    private PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    private int count = 0;
    //每次插入小顶堆的是当前大顶堆中最大的数
    //每次插入大顶堆的是当前小顶堆中最小的数
    //这样保证小顶堆中的数永远大于等于大顶堆中的数
    //中位数就可以方便地从两者的根结点中获取了
    public void Insert(Integer num) {
        //个数为偶数的话，则先插入到大顶堆，然后将大顶堆中最大的数插入小顶堆中
        if(count % 2 == 0){
            maxHeap.offer(num);
            int max = maxHeap.poll();
            minHeap.offer(max);
        }else{
            //个数为奇数的话，则先插入到小顶堆，然后将小顶堆中最小的数插入大顶堆中
            minHeap.offer(num);
            int min = minHeap.poll();
            maxHeap.offer(min);
        }
        count++;
    }
    public Double GetMedian() {
        //当前为偶数个，则取小顶堆和大顶堆的堆顶元素求平均
        if(count % 2 == 0){
            return new Double(minHeap.peek() + maxHeap.peek())/2;
        }else{
            //当前为奇数个，则直接从小顶堆中取元素即可
            return new Double(minHeap.peek());
        }
    }
}
