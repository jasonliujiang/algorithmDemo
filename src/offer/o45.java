package offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class o45 {

    public String PrintMinNumber(int [] numbers) {
        //可能隐含大数问题，且比较数字可以先将数字转换为字符串

        String s = "";
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            list.add(numbers[i]);

        }

        //重新定义一种新的排序规则：任意两数拼接的字符串，如果AB<BA  则A排前面
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = o1+""+o2;
                String s2  = o2+""+o1;

                return s1.compareTo(s2);
            }
        });


        for (int j : list){
            s+=j;
        }

        return s;


    }
}
