package huawei;
/*
* 描述：

输入一个整数，将这个整数以字符串的形式逆序输出

程序不考虑负数的情况，若数字含有0，则逆序形式也含有0，如输入为100，则输出为001
* */

import java.util.*;
import java.io.*;
public class H11 {
    public static void main(String[] args) throws IOException {
        BufferedReader buff=new BufferedReader(new InputStreamReader(System.in));
        String  str=null;
        while((str=buff.readLine())!=null){
            StringBuffer sb = new StringBuffer();
            sb.append(str);
            System.out.println(sb.reverse());
        }
    }
}
