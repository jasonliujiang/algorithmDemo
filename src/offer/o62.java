package offer;

import java.util.LinkedList;
import java.util.List;

/**
 * 圆圈中最后剩下的数字
 * 他随机指定一个数m,让编号为0的小朋友开始报数。
 * 每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,
 * 并且不再回到圈中,从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,
 */
public class o62 {
    /**
     * 创建环形链表模拟圆圈
     * @param n
     * @param m
     * @return
     */
    public int LastRemaining_Solution1(int n, int m) {
        //用链表模拟约瑟夫环问题
        if (n == 0 || m <= 0){
            return -1;
        }
        List<Integer> linklist = new LinkedList<>();

        int index = 0;
         for (int i = 0;i<n;i++){
             linklist.add(i);
         }

         while (linklist.size()>1){
             index = (index+m-1)%n;
             linklist.remove(index);
         }
         return linklist.get(0);
    }


    public int LastRemaining_Solution2(int n, int m) {
        //动态规划，数学公式推导得
        if (n == 0 || m <= 0) {

            return -1;
        }

        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last+m)%n;
        }

        return last;

    }
}
