package offer;

/**
 * 求1+2+……+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句(A?B:C)
 */
public class o64 {
    public static int sum(int n) {
        int re = n;

        // 用逻辑运算符结束递归
        // 当n>0不成立时，&&不会再继续后面的操作
        boolean flag = (n > 0) && (re = re + sum(n - 1)) > 0;
        return re;
    }

    // 用异常结束递归
    // 当n为0时，停止
    public static int sum1(int n) {
        int re = n;
        try {
            int i = 1 / n;
            re = re + sum1(n - 1);
            return re;
        } catch (Exception e) {
            return re;
        }
    }
}


