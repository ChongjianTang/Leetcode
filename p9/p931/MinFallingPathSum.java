package leetcode.p9.p931;

public class MinFallingPathSum {
    /**
     * DP
     * Time complexity: O(n^2)
     * Space complexity: O(1)
     */
    public int minFallingPathSum(int[][] matrix) {
        if (matrix[0].length == 1) {
            for (int i = 1; i < matrix.length; i++) {
                matrix[i][0] += matrix[i - 1][0];
            }
            return matrix[matrix.length - 1][0];
        }
        for (int i = 1; i < matrix.length; i++) {
            matrix[i][0] += Math.min(matrix[i - 1][0], matrix[i - 1][1]);
            for (int j = 1; j < matrix[0].length - 1; j++) {
                matrix[i][j] += Math.min(matrix[i - 1][j - 1], Math.min(matrix[i - 1][j], matrix[i - 1][j + 1]));
            }
            matrix[i][matrix[0].length - 1] += Math.min(matrix[i - 1][matrix[0].length - 1], matrix[i - 1][matrix[0].length - 2]);
        }
        int min = matrix[matrix.length - 1][0];
        for (int i = 1; i < matrix[0].length; i++) {
            if (matrix[matrix.length - 1][i] < min) {
                min = matrix[matrix.length - 1][i];
            }
        }
        return min;
    }
}
