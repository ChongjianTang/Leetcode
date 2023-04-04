package leetcode.p1.p198;

public class Rob {
    /**
     * 1D DP
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public int rob1(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1], dp[0]);
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[dp.length - 1];
    }


    /**
     * DP
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[2];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1], dp[0]);
        for (int i = 2; i < nums.length; i++) {
            int temp = Math.max(dp[1], dp[0] + nums[i]);
            dp[0] = dp[1];
            dp[1] = temp;
        }
        return dp[1];
    }
}
