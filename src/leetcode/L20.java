package leetcode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
//
// 有效字符串需满足：
//
//
// 左括号必须用相同类型的右括号闭合。
// 左括号必须以正确的顺序闭合。
//
//
//
//
// 示例 1：
//
//
//输入：s = "()"
//输出：true
//
//
// 示例 2：
//
//
//输入：s = "()[]{}"
//输出：true
//
//
// 示例 3：
//
//
//输入：s = "(]"
//输出：false
//
//
// 示例 4：
//
//
//输入：s = "([)]"
//输出：false
//
//
// 示例 5：
//
//
//输入：s = "{[]}"
//输出：true
//
//
//
// 提示：
//
//
// 1 <= s.length <= 104
// s 仅由括号 '()[]{}' 组成
//
// Related Topics 栈 字符串
// 👍 2560 👎 0

public class L20 {
        public boolean isValid(String s) {
            int length = s.length();
            if (length % 2 == 1){
                return false;
            }

            //定义括号结构
            Map<Character, Character> parentheses = new HashMap<Character, Character>(){
                {
                    put(')', '(');
                    put(']', '[');
                    put('}', '{');
                }
            };
            Deque<Character> stack = new LinkedList<Character>();
            for (int i = 0; i < length; i++){
                char charNow = s.charAt(i);
                //包含尾括号
                if (parentheses.containsKey(charNow)){
                    if (stack.isEmpty() || !stack.peek().equals(parentheses.get(charNow))){
                        return false;
                    }
                    stack.pop();
                }else {
                    stack.push(charNow);
                }
            }
            return stack.isEmpty();
        }



}
