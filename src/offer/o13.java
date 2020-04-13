package offer;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class o13 {
    //参考快速排序，在
    public void reOrderArray(int [] array) {
        int len = array.length;
        if (array.length<=1){
            return;
        }
        int i = 0;
        while (i<len){
            int j = i+1;
            //如果i为偶数，j向前遍历直到遇到奇数
            if (array[i]%2 == 0){
                //如果j为偶数，一直前进
                while (array[j]%2 == 0){
                    if (j == len-1){
                        return;
                    }
                    j++;
                }
                //此时j为奇数
                int count = j-i;
                int tmp = array[i];
                array[i] = array[j];
                //对交换位置之间的元素整体后移
                while (count>1){
                    array[i+count] = array[i+count-1];
                    count--;
                }
                array[i+1] = tmp;
            }
            i++;
        }
    }
}
