package offer;
import java.util.*;
/**
 *Fibonacci
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 * @author liujiang02
 */
public class o10 {
    public static void main(String[] args) {
        System.out.println(Fibonacci(4));
    }

    public static int Fibonacci(int n) {
        if (n ==0){
            return 0;
        }
        if (n ==1){
            return 1;
        }
        if (n>1){
            int first = 0;
            int  second = 1;
            int result = 0;
            for (int i = 2;i<=n;i++){
                //int temp = first+second;7
                result = first+second;
                first = second;
                second = result;

            }
            return result;
        }
        return -1;
    }
}
