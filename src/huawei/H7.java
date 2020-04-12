package huawei;

/*
* 实现小数的四舍五入
* 强制类型转换不是四舍五入
* */

import java.io.*;
import java.util.*;
public class H7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double d = sc.nextDouble();
        System.out.println(getresult(d));
    }

    private static int getresult(double d) {
        int i = (int)d;
        return (d-i)>=0.5?i+1:i;
    }
}
