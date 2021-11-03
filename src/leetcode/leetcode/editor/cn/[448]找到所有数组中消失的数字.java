package leetcode.leetcode.editor.cn;//给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数
//字，并以数组的形式返回结果。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,3,2,7,8,2,3,1]
//输出：[5,6]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,1]
//输出：[2]
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 10⁵ 
// 1 <= nums[i] <= n 
// 
//
// 进阶：你能在不使用额外空间且时间复杂度为 O(n) 的情况下解决这个问题吗? 你可以假定返回的数组不算在额外空间内。 
// Related Topics 数组 哈希表 👍 840 👎 0


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //鸽笼问题，可以让当前数组充当哈希表的结构。因为每个数如果存在于数组中，则使数组中的对应下标+n。这样，将<n的值写入下标中。
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> resultArray = new ArrayList<>(nums.length);
        for (int num : nums) {
            int index = (num-1)% n;
            //都在数组范围内，无需考虑数据越界的情况；
            nums[index] = nums[index] + n;
        }
        for (int i = 0; i < nums.length; i++){
            if (nums[i] <= n){
                resultArray.add(i+1);
            }
        }
        return resultArray;
    }

    public static void main(String[] args) {
        int[] queryNums = new int[]{4,3,2,7,8,2,3,1};
        List<Integer> disappearedNumbers = findDisappearedNumbers(queryNums);
        System.out.println(disappearedNumbers);
    }
}


//leetcode submit region end(Prohibit modification and deletion)
