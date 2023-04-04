package leetcode.p2.p213;

public class Rob {
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
        dp[1] = Math.max(nums[1], nums[0]);
        if (nums.length == 2) {
            return dp[1];
        }

        for (int i = 2; i < nums.length - 1; i++) {
            int temp = Math.max(dp[0] + nums[i], dp[1]);
            dp[0] = dp[1];
            dp[1] = temp;
        }
        int money = dp[1];

        dp[0] = nums[1];
        dp[1] = Math.max(nums[1], nums[2]);
        for (int i = 3; i < nums.length; i++) {
            int temp = Math.max(dp[0] + nums[i], dp[1]);
            dp[0] = dp[1];
            dp[1] = temp;
        }

        return Math.max(money, dp[1]);
    }
}
