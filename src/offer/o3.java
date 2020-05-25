package offer;

/**
 * 数组中重复的数字
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 */
public class o3 {

    /**
     * 可以直接采用哈希的额外空间计算
     * 下面实现不需要额外空间的算法
     * @param array
     * @param length
     * @param duplication
     * @return
     */
    public boolean duplicate(int array[],int length,int [] duplication) {



        if ( array==null ) {
            return false;
        }

        // 判断数组是否合法（每个数都在0~n-1之间）
        for ( int i=0; i<length; i++ ) {
            if ( array[i]<0 || array[i]>length-1 ) {
                return false;
            }
        }

        for (int i = 0;i<length;i++){
            //判断当前位置的值和下标是否相等
            while (i!=array[i]){
                //相等即为有相同值，直接返回
                if (array[i]==array[array[i]]){
                    duplication[0] = array[i];
                    return true;
                }

                //不相等交换位置继续比较
                int temp = array[i];
                array[i] = array[array[i]];
                array[array[i]] = temp;
            }
        }

        return false;
    }
}
