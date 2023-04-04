package leetcode.p5.p516;

public class LongestPalindromeSubseq {
    /**
     * DP
     * Time complexity: O(n^2)
     * Space complexity: O(n^2) (Space optimized: O(n))
     */
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        dp[0][0] = 1;
        for (int i = 1; i < s.length(); i++) {
            dp[i][i] = 1;
            if (s.charAt(i) == s.charAt(i - 1)) {
                dp[i - 1][i] = 2;
            } else {
                dp[i - 1][i] = 1;
            }
        }

        for (int i = s.length() - 3; i >= 0; i--) {
            for (int j = i + 2; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][s.length() - 1];
    }
}
