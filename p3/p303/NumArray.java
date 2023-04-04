package leetcode.p3.p303;

/**
 * Caching and I would like to call it dp
 */
public class NumArray {

    int[] dp;

    public NumArray(int[] nums) {
        dp = new int[nums.length + 1];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        return dp[right + 1] - dp[left];
    }
}
