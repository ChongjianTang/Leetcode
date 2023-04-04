package leetcode.p0.p70;

public class ClimbStairs {
    /**
     * Recursion
     * TLE
     */
    public int climbStairs1(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    /**
     * DP
     * Time complexity: O(n)
     * Space complexity: O(1)
     * <p>
     * Math part see p509 fib num
     */
    public int climbStairs(int n) {
        int[] dp = new int[2];
        dp[0] = 1;
        dp[1] = 2;
        if (n == 1) {
            return dp[0];
        }
        for (int i = 2; i < n; i++) {
            int temp = dp[0] + dp[1];
            dp[0] = dp[1];
            dp[1] = temp;
        }
        return dp[1];
    }
}
