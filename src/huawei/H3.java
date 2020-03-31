package huawei;

/*
*请你协助明明完成“去重”与“排序”的工作(同一个测试用例里可能会有多组数据，希望大家能正确处理)。

 * 测试用例保证输入参数的正确性，答题者无需验证。测试用例不止一组。
样例输入解释：
样例有两组测试
第一组是3个数字，分别是：2，2，1。
第二组是11个数字，分别是：10，20，40，32，67，40，20，89，300，400，15。
* */

import java.io.*;
import java.util.*;

public class H3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            //treeSet  默认进行正序排序
            TreeSet<Integer> set = new TreeSet<Integer>();
            int n = sc.nextInt();
            if (n > 0) {
                for (int i = 0; i < n; i++) {
                    set.add(sc.nextInt());
                }
            }
            for (Integer i : set) {
                System.out.println(i);
            }
        }
    }


}

