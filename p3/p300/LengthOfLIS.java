package leetcode.p3.p300;

public class LengthOfLIS {
    /**
     * DP
     * dp(i) is the longest increasing subsequence end at nums[i]
     * Time complexity: O(n^2)
     * Space complexity: O(n)
     */
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int result = 1;
        for (int i = 1; i < dp.length; i++) {
            int max = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
            result = Math.max(dp[i], result);
        }
        return result;
    }
}
