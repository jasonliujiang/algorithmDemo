package huawei;


/*
将一个英文语句以单词为单位逆序排放。例如“I am a boy”，逆序排放后为“boy a am I”
所有单词之间用一个空格隔开，语句中除了英文字母外，不再包含其他字符
接口说明
/**
 * 反转句子
 *
 * @param sentence 原句子
 * @return 反转后的句子

public String reverse(String sentence);
 * */


import java.util.*;
import java.io.*;
public class H13 {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        while ((str = reader.readLine()) != null) {
            System.out.println(reverseSentence(str));
        }
    }

    public static void swap(char[] arr, int start, int end) {
        char temp;
        for (; start < end; start++, end--) {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
        }
    }

    public static String reverseWords(char[] arr) {
        // 首先整体旋转数组
        swap(arr, 0, arr.length - 1);
        int n = arr.length,
                i = 0,
                j;
        while (i < arr.length) {
            j = i;
            while (j < n) {
                if (arr[j] == ' ') {
                    break;
                } else {
                    j++;
                }
            }
            //后局部翻转
            swap(arr, i, j - 1);
            while (j < n && arr[j] == ' ') {
                j++;
            }
            i = j;
        }
        return String.valueOf(arr);
    }

    public static String reverseSentence(String A) {
        if (A == null || A == "") {
            return A;
        }
        char[] arr = A.toCharArray();
        return reverseWords(arr);
    }

}
