package leetcode.p4.p474;

public class FindMaxForm {
    /**
     * My DP approach
     * Time complexity: O(lmn)
     * Space complexity: O(lmn)
     */
    public static int findMaxForm1(String[] strs, int m, int n) {
        int[][][] dp = new int[strs.length + 1][m + 1][n + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0][0] = 0;
        }

        for (int i = 1; i < dp.length; i++) {
            int[] digits = count1(strs[i - 1]);
            for (int j = 0; j < dp[0].length; j++) {
                for (int k = 0; k < dp[0][0].length; k++) {
                    if (j >= digits[0] && k >= digits[1]) {
                        dp[i][j][k] = Math.max(dp[i - 1][j - digits[0]][k - digits[1]] + 1, dp[i - 1][j][k]);
                    } else {
                        dp[i][j][k] = dp[i - 1][j][k];
                    }
                }
            }
        }
        return dp[strs.length][m][n];
    }

    public static int[] count1(String s) {
        int zeros = 0;
        int ones = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                zeros++;
            } else {
                ones++;
            }
        }
        return new int[]{zeros, ones};
    }

    /**
     * Space optimized DP
     * Time complexity: O(lmn)
     * Space complexity: O(mn)
     */
    public static int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < strs.length; i++) {
            dp[0][0] = 0;
            int[] digits = count2(strs[i]);
            for (int j = dp.length - 1; j >= 0; j--) {
                for (int k = dp[0].length - 1; k >= 0; k--) {
                    if (j >= digits[0] && k >= digits[1]) {
                        dp[j][k] = Math.max(dp[j - digits[0]][k - digits[1]] + 1, dp[j][k]);
                    }
                }
            }
        }
        return dp[m][n];
    }

    public static int[] count2(String s) {
        int zeros = 0;
        int ones = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                zeros++;
            } else {
                ones++;
            }
        }
        return new int[]{zeros, ones};
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"10", "0001", "111001", "1", "0"};
        System.out.println(findMaxForm(strs, 5, 3));
    }
}
