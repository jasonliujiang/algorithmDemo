package huawei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();
        //以#切分数字模式和字母，模式
        String[] arr = s.split("#");
        for (int i = 0; i < arr.length; i++) {
            //偶数为数字模式，奇数为字母模式
            if ((i&1)==1){
                word(arr[i]);
            }else {

                numModel(arr[i]);
            }

        }


    }

    private static void word(String s) {
        //获取切分后的字符串
        List<String> result = getSubs(s, 0);
        for (String re : result) {
            int length = re.length();
            char c = re.charAt(0);
            switch (c)
            {
                case '0':
                    System.out.println(" ");
//                    if(length%2==1) {System.out.print("0");}
//                    if(length%2==0) {System.out.print(" ");}
                    break;
                case '1':
                    if(length%2==1) {System.out.print(",");}
                    if(length%2==0) {System.out.print(".");}
                    break;
                case '2':
                    if(length%3==1) {System.out.print("a");}
                    if(length%3==2) {System.out.print("b");}
                    if(length%3==0) {System.out.print("c");}
                    break;
                case '3':
                    if(length%3==1) {System.out.print("d");}
                    if(length%3==2) {System.out.print("e");}
                    if(length%3==0) {System.out.print("f");}
                    break;
                case '4':
                    if(length%3==1) {System.out.print("g");}
                    if(length%3==2) {System.out.print("h");}
                    if(length%3==0) {System.out.print("i");}
                    break;
                case '5':
                    if(length%3==1) {System.out.print("j");}
                    if(length%3==2) {System.out.print("k");}
                    if(length%3==0) {System.out.print("l");}
                    break;
                case '6':
                    if(length%3==1) {System.out.print("m");}
                    if(length%3==2) {System.out.print("n");}
                    if(length%3==0) {System.out.print("o");}
                    break;
                case '7':
                    if(length%4==1) {System.out.print("p");}
                    if(length%4==2) {System.out.print("q");}
                    if(length%4==3) {System.out.print("r");}
                    if(length%4==0) {System.out.print("s");}
                    break;
                case '8':
                    if(length%3==1) {System.out.print("t");}
                    if(length%3==2) {System.out.print("u");}
                    if(length%3==0) {System.out.print("v");}
                    break;
                case '9':
                    if(length%4==1) {System.out.print("w");}
                    if(length%4==2) {System.out.print("x");}
                    if(length%4==3) {System.out.print("y");}
                    if(length%4==0) {System.out.print("z");}
                    break;
                default:
                    break;
            }
        }

    }

    /**
     * 数字模式
     * @param s
     */
    private static void numModel(String s) {
        System.out.print(s);
    }


    /**
     * 统计连续相同字符的子串
     * @param str
     * @param idx
     * @return
     */
    public static List<String> getSubs(String str, int idx) {
        List<String> result = new ArrayList<>();
        if(str != null) {
            int len = str.length();
            if(len > 0) {
                String sub = subStr(str, idx);
                int tLen = sub.length();

                result.add(sub);

                if(idx < len) {
                    int endIdx = idx + tLen;
                    if(endIdx < len) {
                        result.addAll(getSubs(str, endIdx));
                    }
                }
            }
        }
        result.removeAll(Collections.singleton("/"));

        return result;
    }


    /**
     * 取出连续相同的字符子串(单个)
     * @param str
     * @param idx
     * @return
     */
    public static String subStr(String str, int idx) {
        char c = str.charAt(idx);
        //char c = str.charAt(0);
        StringBuffer result = new StringBuffer();
        result.append(c);
        if(idx < str.length() -1) {
            if(c == str.charAt(idx + 1)) {
                result.append(subStr(str, idx + 1));
            }
        }
        return result.toString();
    }

}
