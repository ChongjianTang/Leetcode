package leetcode.p0.p87;

public class IsScramble {
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        boolean[][] dp = new boolean[s1.length()][s1.length()];
        for (int i = 0; i < s1.length(); i++) {
            dp[i][i] = s1.charAt(i) == s2.charAt(i);
        }

        for (int i = dp.length - 2; i >= 0; i++) {
            for (int j = i + 1; j < dp.length; j++) {
                dp[i][j] = false;
                boolean isScramble = false;
                for (int k = i; k < j; k++) {
                    isScramble = dp[i][k] && dp[k + 1][j];

                }
            }
        }
        return true;
        // TODO too hard
    }
}
