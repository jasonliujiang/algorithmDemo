package huawei;


/*
*
* 字符串翻转
* */
import java.util.*;
import java.io.*;
public class H12 {
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
