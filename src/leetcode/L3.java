package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class L3 {
    /**
     * 定义两个指针的滑动窗口实现
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        //记录元素是否出现过
        Set<Character> windows = new HashSet<>();

        //右指针
        int rk = 0;
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            if (i!=0){
                windows.remove(s.charAt(i-1));
            }

            while (rk<s.length() && !windows.contains(s.charAt(rk))){
                windows.add(s.charAt(rk));
                ++rk;
            }

            result = Math.max(result,rk-i);
        }

        return result;
    }
}
