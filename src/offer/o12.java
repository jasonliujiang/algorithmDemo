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
        double result = 1.0d;
        int e = exponent>0?exponent:-exponent;
        for (int i = 0; i < e; i++) {
            result = base*result;
        }
        //根据指数正负判断返回值
        return exponent>0?result:1/result;

        //return Math.pow(base,exponent);
    }
}
