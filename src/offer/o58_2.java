package offer;

/**
 * 汇编语言中有一种移位指令叫做循环左移（ROL），
 * 现在有个简单的任务，就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
 * 是不是很简单？OK，搞定它！
 */
public class o58_2 {
    /**
     * 同上道题的思路，先分成两部分翻转，然后再整体翻转
     * @param str
     * @param n
     * @return
     */
    public String LeftRotateString(String str,int n) {
        if (n>str.length()){
            return "";
        }

        char[] chars = str.toCharArray();

        reversAll(chars,0,n-1);
        reversAll(chars,n,chars.length-1);

        reversAll(chars,0,chars.length-1);

        return new String(chars);


    }

    private void reversAll(char[] charArray, int start, int end) {

        while (start<end){
            char tmp = charArray[start];
            charArray[start] = charArray[end];
            charArray[end] = tmp;
            start++;
            end--;
        }
    }
}
