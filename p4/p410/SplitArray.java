package leetcode.p4.p410;

public class SplitArray {
    /**
     * My approach
     * DP
     * TLE - 23 / 30
     */
    public static int splitArray(int[] nums, int m) {
        int[][][] dp = new int[nums.length][nums.length][m];
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                dp[i][j][0] = sum;
            }
        }
        for (int k = 1; k < m; k++) {
            for (int i = 0; i < nums.length; i++) {
                for (int j = i; j < nums.length; j++) {
                    if (j - i >= k) {
                        dp[i][j][k] = getDP1(nums, dp, i, j, k);
                    } else {
                        dp[i][j][k] = -1;
                    }
                }
            }
        }
        return dp[0][nums.length - 1][m - 1];
    }

    private static int getDP1(int[] nums, int[][][] dp, int start, int end, int k) {
        int max = Integer.MAX_VALUE;
        for (int i = start; i < end; i++) {
            for (int j = 0; j < k; j++) {
                if (dp[start][i][j] != -1 && dp[i + 1][end][k - 1 - j] != -1) {
                    int temp = Math.max(dp[start][i][j], dp[i + 1][end][k - 1 - j]);
                    max = Math.min(max, temp);
                }
            }
        }
        return max;
    }

    //TODO

    public static void main(String[] args) {
        System.out.println(splitArray(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6, 7, 7, 8, 2, 3, 1, 1, 1, 10, 11, 5, 6, 2, 4, 7, 8, 5, 6}, 20));

        System.out.println(splitArray(new int[]{7, 2, 5, 10, 8}, 2));
        System.out.println(splitArray(new int[]{2, 3, 1, 2, 4, 3}, 5));
    }
}
