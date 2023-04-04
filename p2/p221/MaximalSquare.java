package leetcode.p2.p221;

public class MaximalSquare {
    /**
     * My approach
     * Convolution
     * Time complexity: mn + (n-1)(m-1) + ... + 1 = O(mn)
     * Space complexity: O(mn)
     */
    public int maximalSquare1(char[][] matrix) {
        int[][] nums = new int[matrix.length][matrix[0].length];
        boolean existSquare = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                nums[i][j] = Character.getNumericValue(matrix[i][j]);
                if (nums[i][j] == 1) {
                    existSquare = true;
                }
            }
        }
        if (!existSquare) {
            return 0;
        }
        int result = 1;
        int[][] temp;
        while (existSquare && nums.length > 1 && nums[0].length > 1) {
            existSquare = false;
            temp = new int[nums.length - 1][nums[0].length - 1];
            for (int i = 0; i < temp.length; i++) {
                for (int j = 0; j < temp[0].length; j++) {
                    if (nums[i][j] + nums[i + 1][j] + nums[i][j + 1] + nums[i + 1][j + 1] == 4) {
                        temp[i][j] = 1;
                        existSquare = true;
                    } else {
                        temp[i][j] = 0;
                    }
                }
            }
            nums = temp;
            if (existSquare) {
                result++;
            }
        }
        return result * result;
    }

    /**
     * DP
     * Time complexity: O(mn)
     * Space complexity: O(mn)
     */
    public int maximalSquare(char[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        int max = 0;
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = Character.getNumericValue(matrix[i][0]);
            if (dp[i][0] == 1) {
                max = 1;
            }
        }

        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = Character.getNumericValue(matrix[0][j]);
            if (dp[0][j] == 1) {
                max = 1;
            }
        }


        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                } else {
                    dp[i][j] = 0;
                }
                if (dp[i][j] > max) {
                    max = dp[i][j];
                }
            }
        }
        return max * max;
    }
}
