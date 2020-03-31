package huawei;

/*
 * 功能:输入一个正整数，按照从小到大的顺序输出它的所有质因子（如180的质因子为2 2 3 3 5 ）
 * 最后一个数后面也要有空格
 * */

import java.io.*;
import java.util.*;

public class H6 {
    //就是让你把输入的整数因式分解，只不过因子必须都是质数
    //例如：180 = 2 * 2 * 3 * 3 * 5；90 = 2 * 3 * 3 * 5；
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str = "";
            while ((str = br.readLine()) != null) {
                long num = Long.parseLong(str);
                System.out.println(getResult(num));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getResult(long num) {
        StringBuffer sb = new StringBuffer();//返回的字符串
        if (isBrime(num)) {//本身是质数
            sb.append(num + " ");
            return sb.toString();
        }

        for (long i = 2; i <= num; i++) {
            if (isBrime(num)) {//num是质数
                sb.append(num + " ");
                return sb.toString();
            }

            boolean flag = isBrime(i);//判断是不是质数
            if (flag) {
                long ys = 1L;//余数
                while ((ys = num % i) == 0) {//是质因子
                    sb.append(i + " ");
                    num = num / i;
                }
            }
        }
        return sb.toString();
    }

    //判断是不是质数
    private static boolean isBrime(long i) {
        boolean flag = true; //默认是质数
        long sqrt = Math.round(Math.sqrt(i));//正平方根
        for (long j = 2; j < sqrt; j++) {
            if (i % j == 0) {
                flag = false; //不是质数
                break;
            }
        }
        return flag;
    }

}



