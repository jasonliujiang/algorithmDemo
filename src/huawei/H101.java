package huawei;


/*
* 输入整型数组和排序标识，对其元素按照升序或降序进行排序（一组测试用例可能会有多组数据）
接口说明
原型：
void sortIntegerArray(Integer[] pIntegerArray, int iSortFlag);
输入参数：
Integer[] pIntegerArray：整型数组
int  iSortFlag：排序标识：0表示按升序，1表示按降序
输出参数：
无
返回值：
void
* */
import java.util.*;
import java.io.*;

public class H101 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String message = null;
        while (null != (message = bf.readLine())) {
            //数组大小
            int n = Integer.parseInt(message);
            //获取数组
            String[] str = bf.readLine().split(" ");
            //升序降序标识
            int falg = Integer.parseInt(bf.readLine());
            int[] array = new int[n];
            for (int i = 0; i < str.length; i++) {
                array[i] = Integer.parseInt(str[i]);
            }
            if (0 == falg) {
                //默认升序
                Arrays.sort(array);
            } else {
                Arrays.sort(array);
                //先升序后重排为降序
                for (int i = 0; i < (array.length) / 2; i++) {
                    int a = array[i];
                    array[i] = array[array.length - 1 - i];
                    array[array.length - 1 - i] = a;
                }
            }
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; i++) {
                sb.append(array[i]).append(" ");
            }
            System.out.println(sb.toString().trim());

        }
    }
}


//    static void sortIntegerArray(Integer[] pIntegerArray, int iSortFlag) {
//        if (iSortFlag == 0) {
//            //默认升序
//            Arrays.sort(pIntegerArray);
//        } else if (iSortFlag == 1) {
//            Arrays.sort(pIntegerArray, new MyComparator());
//        }
//
//        for (int i = 0; i < pIntegerArray.length - 1; i++) {
//            if (i == pIntegerArray.length-1){
//                System.out.println(pIntegerArray[i]);
//            }else {
//                System.out.print(pIntegerArray[i] + " ");
//            }
//        }
//        System.out.println();
//    }
//
//    //Comparator是一个接口，所以这里我们自己定义的类MyComparator要implents该接口
//    //而不是extends Comparator
//    static class MyComparator implements Comparator<Integer> {
//        @Override
//        public int compare(Integer o1, Integer o2) {
//            //如果n1小于n2，我们就返回正值，如果n1大于n2我们就返回负值，
//            if (o1 < o2) {
//                return 1;
//            } else if (o1 > o2) {
//                return -1;
//            } else {
//                return 0;
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNext()){
//            int N = in.nextInt();
//            Integer[] array = new Integer[N];
//            for (int i=0;i<N;i++){
//                array[i] = in.nextInt();
//            }
//            int flag = in.nextInt();
//            sortIntegerArray(array,flag);
//        }
//        in.close();
//
//    }






