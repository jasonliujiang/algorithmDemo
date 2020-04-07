package huawei;


import java.util.*;
import java.io.*;

public class H9 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = " ";
        while((str = br.readLine()) != null){
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.reverse();
            Set set = new HashSet();
            int n = sb.length();
            for(int i = 0;i<n;i++){
                if(set.add(sb.substring(i,i+1))){
                    System.out.print(sb.substring(i,i+1));
                }
            }
        }
    }
}
