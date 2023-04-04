package leetcode.p0.p91;

public class NumDecodings {
    /**
     * Jul 19, 2022 12:56
     * DP
     * Time complexity: O(n)
     * Space complexity: O(n) (Space optimized: O(1))
     */
    public static int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        if (s.charAt(0) == '0') {
            return 0;
        } else {
            dp[1] = 1;
        }
        if (s.length() == 1) {
            return dp[1];
        }
        for (int i = 2; i < s.length() + 1; i++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] = dp[i - 1];
            }
            int num = Integer.parseInt(s.substring(i - 2, i));
            if (num >= 10 && num <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("230"));
    }
}
