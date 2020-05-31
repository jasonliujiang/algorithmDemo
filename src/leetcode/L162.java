package leetcode;

/**
 * 峰值元素是指其值大于左右相邻值的元素。
 *
 * 给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
 *
 * 数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
 *
 */
public class L162 {
    /**
     * 既然一定存在峰值，则可以通过二分查找法递归或非递归的实现
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        return search(nums,0,nums.length-1);
    }

    private int search(int[] nums, int left, int right) {

        if (left == right) {
            return left;
        }
        int mid = (left+right)/2;
        if (nums[mid]>nums[mid+1]){
            return search(nums,left,mid);
        }else {
            return search(nums,mid+1,right);
        }
    }


    /**
     * 非递归实现，空间复杂度更小
     * @param nums
     * @return
     */
    public int findPeakElement2(int[] nums) {
        int start = 0;
        int end = nums.length-1;

        while (start<end){
            int mid = (start+end)/2;

            if (nums[mid]>nums[mid+1]){
                end = mid;
            }else {
                start = mid+1;
            }
        }

        return start;

    }
}
