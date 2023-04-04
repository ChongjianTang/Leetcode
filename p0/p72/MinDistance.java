package leetcode.p0.p72;

public class MinDistance {
    /**
     * DP
     * Time complexity: O(mn)
     * Space complexity: O(mn)
     */
    public static int minDistance1(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        dp[0][0] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j < dp[0].length; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1] - 1)) + 1;
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }

    /**
     * DP
     * Time complexity: O(mn)
     * Space complexity: O(n)
     */
    public static int minDistance(String word1, String word2) {
        int[] dp = new int[word2.length() + 1];
        dp[0] = 0;
        for (int j = 1; j < dp.length; j++) {
            dp[j] = j;
        }

        for (int i = 1; i < word1.length() + 1; i++) {
            int prev = dp[0];
            dp[0] = i;
            for (int j = 1; j < dp.length; j++) {
                int temp = dp[j];
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[j] = Math.min(temp, Math.min(dp[j - 1], prev - 1)) + 1;
                } else {
                    dp[j] = Math.min(temp, Math.min(dp[j - 1], prev)) + 1;
                }
                prev = temp;
            }
        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        minDistance1("horse", "ros");
        minDistance("horse", "ros");
    }
}
