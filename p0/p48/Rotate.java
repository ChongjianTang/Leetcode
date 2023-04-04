package leetcode.p0.p48;

public class Rotate {
    /**
     * Oct 06, 2022 23:51
     */
    public static void rotate(int[][] matrix) {
        int len = matrix.length;
        for (int i = 0; i < len / 2; i++) {
            for (int j = i; j < len - 1 - i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[len - j - 1][i];
                matrix[len - j - 1][i] = matrix[len - i - 1][len - j - 1];
                matrix[len - i - 1][len - j - 1] = matrix[j][len - i - 1];
                matrix[j][len - i - 1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[4][4];
        matrix[0] = new int[]{5, 1, 9, 11};
        matrix[1] = new int[]{2, 4, 8, 10};
        matrix[2] = new int[]{13, 3, 6, 7};
        matrix[3] = new int[]{15, 14, 12, 16};

        rotate(matrix);
    }
}
