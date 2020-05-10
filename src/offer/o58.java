package offer;

/**
 * 翻转顺序字符串
 */
public class o58 {
    public String ReverseSentence(String str) {
        char[] charArray = str.toCharArray();
        int start = 0;
        int end = charArray.length;
        //先翻转句子
        reversAll(charArray,start,end-1);

        //再翻转局部
        int index = -1;
        for (int i = 0; i < charArray.length - 1; i++) {
            if (charArray[i] == ' '){
                int nextIndex = i;
                reversAll(charArray,index+1,nextIndex-1);
                index = nextIndex;
            }
        }

        reversAll(charArray,index+1,charArray.length-1);
        return new String(charArray);
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
