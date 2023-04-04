package leetcode.p0.p64;

public class MinPathSum {
    /**
     * DP 2D
     * Time complexity: O(mn)
     * Space complexity: O(mn)
     */
    public int minPathSum1(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < grid.length; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < grid[0].length; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }

    /**
     * DP 1D
     * Time complexity: O(mn)
     * Space complexity: O(1)
     */
    public int minPathSum2(int[][] grid) {
        int[] dp = new int[grid.length];
        dp[0] = grid[0][0];
        for (int i = 1; i < grid.length; i++) {
            dp[i] = dp[i - 1] + grid[i][0];
        }
        for (int i = 1; i < grid[0].length; i++) {
            dp[0] = dp[0] + grid[0][i];
            for (int j = 1; j < grid.length; j++) {
                dp[j] = Math.min(dp[j - 1], dp[j]) + grid[j][i];
            }
        }
        return dp[grid.length - 1];
    }

    public int minPathSum (int[][] grid) {
        return 0;
        //TODO
    }
}
