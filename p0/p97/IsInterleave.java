package leetcode.p0.p97;

public class IsInterleave {
    /**
     * 2D DP
     * Time complexity: O(mn)
     * Space complexity: O(mn)
     */
    public boolean isInterleave1(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = s1.substring(0, i).equals(s3.substring(0, i));
        }
        for (int j = 1; j < dp[0].length; j++) {
            dp[0][j] = s2.substring(0, j).equals(s3.substring(0, j));
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                boolean equalToS1 = s1.charAt(i - 1) == s3.charAt(i + j - 1);
                boolean equalToS2 = s2.charAt(j - 1) == s3.charAt(i + j - 1);
                if (equalToS1 && equalToS2) {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else if (equalToS1) {
                    dp[i][j] = dp[i - 1][j];
                } else if (equalToS2) {
                    dp[i][j] = dp[i][j - 1];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }

    /**
     * 1D DP
     * Time complexity: O(mn)
     * Space complexity: O(n)
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        boolean[] dp = new boolean[s2.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = s2.substring(0, i).equals(s3.substring(0, i));
        }

        for (int i = 1; i < s1.length(); i++) {
            if (s1.charAt(i - 1) != s3.charAt(i - 1)) {
                dp[0] = false;
            }
            for (int j = 1; j < s2.length() + 1; j++) {
                boolean equalToS1 = s1.charAt(i - 1) == s3.charAt(i + j - 1);
                boolean equalToS2 = s2.charAt(j - 1) == s3.charAt(i + j - 1);
                if (equalToS1 && equalToS2) {
                    dp[j] = dp[j] || dp[j - 1];
                } else if (equalToS1) {
                    dp[j] = dp[j];
                } else if (equalToS2) {
                    dp[j] = dp[j - 1];
                } else {
                    dp[j] = false;
                }
            }
        }
        return dp[s2.length()];
    }
}
