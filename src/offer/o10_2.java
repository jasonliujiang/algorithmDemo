package offer;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class o10_2 {

    /*
     * 根据上题的递归思想，思路，f(n) = f(n-1)+f(n-2)+f(n-3)+....+f(n-n)
     *                       f(n-1) = f(n-2)+f(n-3)+f(n-4)+....+f(0)
     *
     * 即f(n) = 2*f(n-1)
     * 即  2^（n-1）
     * */
    public int JumpFloorII(int target) {
        if (target == 0) {
            return 1;
        }
        if (target == 1) {
            return 1;
        }
        int preResult = 1;
        int result = 0;
        for (int i = 2; i <= target; i++) {
            result = 2 * preResult;
            preResult = result;
        }
        return result;

        //return (int) Math.pow(2,target);

    }


    public int JumpFloorII2(int target) {
        int[] arr = new int[target + 1];
        boolean[] ar = new boolean[3];
        if (target == 0) {
            return 1;
        }
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i <= target; i++) {
            for (int j = 0; j < i; j++) {
                arr[i] += arr[j];
            }
        }

        return arr[target];

    }
}
