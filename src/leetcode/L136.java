package leetcode;

import java.util.HashSet;

/**
 * 所有数字都是成对出现的，只有一个数字是落单的，找出这个落单的数字。
 */
public class L136 {
    //利用hashset的结构，空间复杂度o(n)
    public int singleNumber1(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
            } else {
                set.remove(nums[i]);
            }
        }
        return set.iterator().next();
    }

    /**
     * 利用数学公式推导，将所有出现的数字*2的和减去数组的所有和
     * @param nums
     * @return
     */
    public int singleNumber2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int sum = 0;//之前的数字和
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
            sum += nums[i];
        }
        int sumMul = 0;//出现过的数字和
        for (int n : set) {
            sumMul += n;
        }
        sumMul = sumMul * 2;
        return sumMul - sum;
    }


    /**
     * 通过异或操作
     * 相同的数 异或 = 0
     * 0^x = x
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans ^= nums[i];
        }
        return ans;
    }
}
