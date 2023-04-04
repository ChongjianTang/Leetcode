package leetcode.p3.p304;

public class NumMatrix {
    int[][] dp;

    public NumMatrix(int[][] matrix) {
        dp = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 0; i < matrix.length + 1; i++) {
            dp[i][0] = 0;
        }
        for (int j = 1; j < matrix[0].length + 1; j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] + matrix[i - 1][j - 1] - dp[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return dp[row2 + 1][col2 + 1] + dp[row1][col1] - dp[row2 + 1][col1] - dp[row1][col2 + 1];
    }

    public static void main(String[] args) {
        int[][] matrix = new int[5][];
        matrix[0] = new int[]{3, 0, 1, 4, 2};
        matrix[1] = new int[]{5, 6, 3, 2, 1};
        matrix[2] = new int[]{1, 2, 0, 1, 5};
        matrix[3] = new int[]{4, 1, 0, 1, 7};
        matrix[4] = new int[]{1, 0, 3, 0, 5};
        NumMatrix n = new NumMatrix(matrix);
        System.out.println(n.sumRegion(1, 1, 2, 2));
    }
}
