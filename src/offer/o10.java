package offer;

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 *
 * 比如n=3时，2*3的矩形块有3种覆盖方法
 */
public class o10 {
    //同理跳台阶的斐波那契
    public int RectCover(int target) {
        if (target ==0){
            return 0;
        }
        if (target ==1){
            return 1;
        }
        int first = 0;
        int  second = 1;
        int result = 0;
        for (int i = 2;i<=target+1;i++){
            //int temp = first+second;7
            result = first+second;
            first = second;
            second = result;

        }
        return result;

    }
}
