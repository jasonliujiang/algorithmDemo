package leetcode.leetcode.editor.cn;//给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
//
// 进阶：不要 使用任何内置的库函数，如 sqrt 。 
//
// 
//
// 示例 1： 
//
// 
//输入：num = 16
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：num = 14
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= num <= 2^31 - 1 
// 
// Related Topics 数学 二分查找 👍 303 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution367 {
    public static boolean isPerfectSquare(int num) {
        //使用库函数,判断num的平方根是不是整数即可。
//        int x  = (int)Math.sqrt(num);
//        return x * x == num;
        //采用二分法实现
        int left = 0;
        int right = num;
        while (left <= right){
            //经典二分法的写法中可能存在溢出的情况，推荐这么写
            int mid = (right - left) / 2 + left;
            //int mid = (left + right) / 2;
            long square = (long) mid * mid;
            if (square == num){
                return true;
            }else if (square < num){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        long now = System.currentTimeMillis();
        System.out.println(isPerfectSquare(2147483647));
        System.out.println("花费时间为： "+ (System.currentTimeMillis() - now));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
