package offer;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 对于一个字符串,请设计一个高效算法，找到字符串的最长无重复字符的子串长度。
 *
 * 给定一个字符串A及它的长度n，请返回它的最长无重复字符子串长度。保证A中字符全部为小写英文字符，且长度小于等于500。
 */
public class o48 {
    public int longestSubstring(String s, int n) {
        //存放某字符上次出现的位置
        HashMap<Character, Integer> charIndex = new HashMap<>();
        //当前最长无重复字符串的起始位置
        int preIndex = 0;

        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!charIndex.containsKey(s.charAt(i))){
                charIndex.put(s.charAt(i),i);
                int StringLen = i-preIndex+1;

            }else {
                //若之前出现过该字符，则判断重复字符间的距离
                int sameCharLength = i-charIndex.get(s.charAt(i))+1;
                int StringLength = i-preIndex+1;

                if (StringLength<sameCharLength){
                    maxLength = Math.max(maxLength,StringLength);

                }else {
                    preIndex = charIndex.get(s.charAt(i))+1;

                    maxLength = Math.max(maxLength,sameCharLength-1);
                }
            }

            charIndex.put(s.charAt(i),i);


        }
        return maxLength;
    }
}
