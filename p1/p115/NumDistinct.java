package leetcode.p1.p115;

public class NumDistinct {
    /**
     * DP
     * Time complexity: O(nm)
     * Space complexity: O(nm)
     */
    public int numDistinct1(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        dp[0][0] = 1;
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        for (int j = 1; j < dp[0].length; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[s.length()][t.length()];
    }

    /**
     * Space optimized DP
     * Time complexity: O(mn)
     * Space complexity: O(n)
     */
    public int numDistinct(String s, String t) {
        int[] dp = new int[t.length() + 1];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = 0;
        }

        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = dp.length - 1; j > 0; j--) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[j] += dp[j - 1];
                }
            }
        }
        return dp[t.length()];
    }
}
