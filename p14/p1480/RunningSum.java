package leetcode.p14.p1480;

public class RunningSum {
    /**
     * Mar 11, 2023 17:42
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public int[] runningSum(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            nums[i] = sum;
        }
        return nums;
    }
}
