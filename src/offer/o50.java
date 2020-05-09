package offer;

import java.util.HashMap;

/**
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置,
 * 如果没有则返回 -1（需要区分大小写）.（从0开始计数）
 */
public class o50 {
    public int FirstNotRepeatingChar(String str) {

        if (str == null){
            return -1;
        }
        //存放字符串中出现的所有次数
        HashMap<Character,Integer>  resultMap = new HashMap<>();

        //遍历将字符的出现次数映射好
        for (int i = 0; i < str.length(); i++) {
            if (!resultMap.containsKey(str.charAt(i))){
                resultMap.put(str.charAt(i),1);
            }else {
                int val = resultMap.get(str.charAt(i));
                resultMap.put(str.charAt(i),val+1);
            }
        }

        //再次遍历找到第一次出现的唯一字符
        for (int i = 0; i < str.length(); i++) {
            if (resultMap.get(str.charAt(i)) == 1){
                return i;
            }
        }

        return -1;

    }
}
