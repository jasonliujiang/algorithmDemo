package leetcode;

import java.util.HashMap;

/**
 * ，每个数字都出现了 3 次，只有一个数字出现了 1 次，找出这个数字。同样要求时间复杂度为 O（n），空间复杂度为 O（1）。
 */
public class L137 {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        for (Integer key : map.keySet()) {
            if (map.get(key) == 1) {
                return key;
            }

        }
        return -1; // 这句不会执行
    }


    /**
     * 考虑位运算
     */
    public int singleNumber2( int[] nums) {
        int ans = 0;
        //考虑每一位
        for (int i = 0; i < 32; i++) {
            int count = 0;
            //考虑每一个数
            for (int j = 0; j < nums.length; j++) {
                //当前位是否是 1
                if ((nums[j] >>> i & 1) == 1) {
                    count++;
                }
            }
            //1 的个数是否是 3 的倍数
            if (count % 3 != 0) {
                ans = ans | 1 << i;
            }
        }
        return ans;
    }
}
