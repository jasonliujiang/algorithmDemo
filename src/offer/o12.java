package offer;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 *
 * 保证base和exponent不同时为0
 */
public class o12 {
    /**
     * 注意判断指数的正负0，底数是否为0等情况
     * @param base
     * @param exponent
     * @return
     */
    public double Power(double base, int exponent) {
        //判断底数为0的情况
        if (base == 0){
            return 0;
        }
        if (exponent == 0){
            return 1;
        }

        int absExponent = exponent>0?exponent:-exponent;

        //double result = PowOfExponent(base,absExponent);
        double result = PowOfExponentRecursive(base,absExponent);
        //根据指数正负判断返回值
        return exponent>0?result:1/result;

        //return Math.pow(base,exponent);
    }

    /**
     * 常规思路：循环累乘
     * @param base
     * @param absExponent
     * @return
     */
    public double PowOfExponent(double base,int absExponent){
        double result = 1.0d;
        for (int i = 0; i < absExponent; i++) {
            result = base*result;
        }
        return result;
    }

    /**
     *
     * @param base
     * @param absExponent
     * @return
     */
    public double PowOfExponentRecursive(double base,int absExponent){
        if (absExponent == 0){
            return 1;
        }

        if (absExponent == 1){
            return base;
        }

        //用右移运算符代替除以2
        double result = PowOfExponentRecursive(base,absExponent >> 1);


        result *= result;

        //判断奇偶 &1=0偶数  &1=1奇数
        if ((absExponent&1) == 1){
            result *=base;
        }

        return result;
    }
}
