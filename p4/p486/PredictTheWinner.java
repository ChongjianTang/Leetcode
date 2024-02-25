package leetcode.p4.p486;

public class PredictTheWinner {
    /**
     * Nov 16, 2023 02:26
     * DP
     * Time complexity: O(n^2)
     * Space complexity: O(n^2)
     * TODO Space complexity can be optimized.
     */
    public boolean predictTheWinner(int[] nums) {
        boolean isPlayerOneLastPicker = nums.length % 2 == 1;
        int[][] dp = new int[nums.length + 1][nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            if (isPlayerOneLastPicker) {
                dp[i][i + 1] = nums[i];
            }
        }

        for (int i = dp.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < dp[0].length; j++) {
                if (((j - i) % 2 == 1 && isPlayerOneLastPicker) || ((j - i) % 2 == 0 && !isPlayerOneLastPicker)) {
                    dp[i][j] = Math.max(dp[i + 1][j] + nums[i], dp[i][j - 1] + nums[j - 1]);
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j] - nums[i], dp[i][j - 1] - nums[j - 1]);
                }
            }
        }
        return dp[0][nums.length] >= 0;
    }

    public static void main(String[] args) {
        PredictTheWinner predictTheWinner = new PredictTheWinner();
        System.out.println(!predictTheWinner.predictTheWinner(new int[]{1, 5, 2}));
    }
}
