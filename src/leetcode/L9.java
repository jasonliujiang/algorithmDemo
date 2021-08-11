package leetcode;

public class L9 {
    public boolean isPalindrome(int x) {
        /*
         * 1.负数必不可能是回文数
         * 2.除0以外的所有个位数为0的必不可能是回文数
         */
        if (x < 0 || (x % 10 == 0 && x != 0)){
            return false;
        }
        int reserveNum = 0;
        //全翻转可能导致int 类型溢出，考虑只翻转一半
        //如何判断翻转了一半？原数在减少，翻转数在增大，当原数小于翻转数时，即翻转了一半
        while (x > reserveNum){
            int num = x % 10;
            reserveNum = reserveNum * 10 + num;
            x = x / 10;

        }
        //考虑奇偶数情况
        if (x == reserveNum || x == reserveNum / 10){
            return true;
        }

        return false;

    }
}
