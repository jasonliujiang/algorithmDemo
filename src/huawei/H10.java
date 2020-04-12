package huawei;

/*
* 题目描述
编写一个函数，计算字符串中含有的不同字符的个数。字符在ACSII码范围内(0~127)，换行表示结束符，不算在字符里。不在范围内的不作统计。
* */

import java.io.*;
public class H10 {
    public static void main(String[] args) throws Exception{
        BufferedReader buff=new BufferedReader(new InputStreamReader(System.in));
        String  str=null;
        while((str=buff.readLine())!=null){
            int count=0;
            for(int i=0;i<str.length();i++){
                if(str.indexOf(str.charAt(i))==i){
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
