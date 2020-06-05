package leetcode;

/**
 * 除自身数组以外数组的乘积
 * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积
 *  不能使用除法
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/product-of-array-except-self
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L238 {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] left = new int[length];
        int[] right = new int[length];
        int [] result = new int[length];

        left[0] = 1;
        for (int i = 1; i < length; i++) {
            left[i] = nums[i-1]*left[i-1];
        }

        right[length-1] = 1;
        for (int i = length-1; i >=0 ; i--) {
            right[i] = right[i+1]*nums[i+1];
        }

        for (int i = 0; i < length; i++) {
            result[i] = left[i]*right[i];
        }
        return result;
    }


    /**
     *  空间复杂度为O(1)的解法
     * @param nums
     * @return
     */
    public int[] productExceptSelf2(int[] nums) {
        int length = nums.length;
        int [] result = new int[length];

        //先用result数组代替左数乘积的数组
        result[0] = 1;
        for (int i = 1; i < length; i++) {
            result[i] = nums[i-1]*result[i-1];
        }

        //再用标识位递归存储右数乘积的数组
        int R = 1;
        for (int i = length-1; i >=0 ; i--) {
            result[i] = result[i]*R;
            R *= nums[i];
        }

        return result;

    }
}
