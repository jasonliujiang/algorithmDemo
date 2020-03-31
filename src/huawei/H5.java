package huawei;
/*
* 接受一个十六进制的数，输出该数值的十进制表示。（多组同时输入 ）
* */
import java.io.*;
import java.util.*;
public class H5 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        String s;
        while((s=bufferedReader.readLine())!=null){
            s =s.substring(2);
            System.out.println(Integer.parseInt(s,16));
        }
    }
}
