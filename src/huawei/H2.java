package huawei;
/*
 * 写出一个程序，接受一个由字母和数字组成的字符串，和一个字符，然后输出输入字符串中含有该字符的个数。不区分大小写
 * 输入：第一行输入一个有字母和数字以及空格组成的字符串，第二行输入一个字符。
 * 输出：输出输入字符串中含有该字符的个数。
 * */


import java.util.*;
import java.io.*;

public class H2 {
    public static void main(String[] args) throws IOException {
        int count = 0;

        BufferedReader bf1 = new BufferedReader(new InputStreamReader(System.in));

        //全部转化为小写
        String r1 = bf1.readLine().toLowerCase();
        char r2 = bf1.readLine().toLowerCase().toCharArray()[0];
        //转化为char类型数组
        char[] ca = r1.toCharArray();
        for (int i = 0; i < ca.length; i++) {
            if (ca[i] == r2) {
                count++;
            }
        }
        System.out.println(count);

    }

}
