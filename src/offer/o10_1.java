package offer;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）
 */
public class o10_1 {
    /*
    * 如果有两种跳法，1次1阶，1次2阶。
    * 假设第一次跳了1阶，剩下的的跳法是f(n-1)
    * 假设第一次跳了2阶，剩下的跳法是f(n-2)
    * 综上f(n) = f(n-1)+f(n-2)
    * 所以可以理解为一种斐波那契的应用
    * */
    public int JumpFloor(int target) {
        if (target == 0){
            return 0;
        }
        if (target == 1){
            return 1;
        }
        int first = 0;
        int second = 1;
        int result = 0;
        for (int i =0;i<=target+1;i++){
            result = first+second;
            first = second;
            second = result;
        }
        return result;

    }



}
