package huawei;
/*
* 计算字符串最后一个单词的长度，单词以空格隔开。
* hello world
* 返回 5
* */

import java.util.*;
import java.io.*;
public class H1 {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        String s="";
        while (input.hasNextLine()){
            s = input.nextLine();
            String[] Arrayss = s.split(" ");
            int n = Arrayss[Arrayss.length-1].length();
            System.out.println(n);
        }
    }
}
