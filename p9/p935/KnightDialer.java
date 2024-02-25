package leetcode.p9.p935;

import java.util.HashMap;

public class KnightDialer {
    /**
     * Feb 13, 2024 23:07
     * DP
     * Time Complexity: O(n)
     * Space Complexity: O(n) (can be optimized to O(1))
     */
    public int knightDialer(int n) {
        int mod = 1000000007;
        int[][] dp = new int[10][n];
        for (int i = 0; i < 10; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = (dp[4][i - 1] + dp[6][i - 1]) % mod;
            dp[1][i] = (dp[8][i - 1] + dp[6][i - 1]) % mod;
            dp[2][i] = (dp[7][i - 1] + dp[9][i - 1]) % mod;
            dp[3][i] = (dp[4][i - 1] + dp[8][i - 1]) % mod;
            dp[4][i] = ((dp[3][i - 1] + dp[9][i - 1]) % mod + dp[0][i - 1]) % mod;
            dp[5][i] = 0;
            dp[6][i] = ((dp[1][i - 1] + dp[7][i - 1]) % mod + dp[0][i - 1]) % mod;
            dp[7][i] = (dp[2][i - 1] + dp[6][i - 1]) % mod;
            dp[8][i] = (dp[1][i - 1] + dp[3][i - 1]) % mod;
            dp[9][i] = (dp[2][i - 1] + dp[4][i - 1]) % mod;
        }

        long result = 0;
        for (int i = 0; i < dp.length; i++) {
            result += dp[i][n - 1];
        }
        return (int) (result % mod);
    }
}
