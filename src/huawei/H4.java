package huawei;

/*
* 连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组；
•长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
* */

import java.io.*;
import java.util.*;

public class H4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringBuffer s1 = new StringBuffer(bf.readLine());
        StringBuffer s2 = new StringBuffer(bf.readLine());
        while (s1.length()% 8 != 0){
            s1.append("0");
        }
        s1.append(s2);
        while (s1.length()%8 != 0){
            s1.append("0");
        }
        for (int i = 0;i<s1.length();i+=8){
            System.out.println(s1.substring(i,i+8));
        }

    }
}
