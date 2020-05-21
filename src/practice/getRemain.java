package practice;

/**
 * 一个n位数，现在可以删除其中任意k位，使得剩下的数最小(前导零忽略)
 */
public class getRemain {
    //从前往后找，每次访问一位，比较前边的数，如果比该位大，直接干掉
    public int getRemain2(int[] arr,int n,int k){
        int tmp = n-k;
        int index = 0;
        int pre = 0;

        while (index<n){
            pre = index-1;

            while (pre>=0){
                if (arr[pre]>=arr[index]){
                    for (int i = pre; i < n; i++) {
                        arr[i] = arr[i+1];
                    }
                    --index;
                    --k;
                    --n;
                }
                --pre;
            }
            ++index;
        }
        int result = 0;

        for (int i = 0; i < n-k; i++) {
            result = result*10+arr[i];
        }
        return result;
    }
}
