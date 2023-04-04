package leetcode.p0.p54;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {
    /**
     * 11/23/2022 01:37
     */
    public static List<Integer> spiralOrder(int[][] matrix) {
        int inward = 0;
        int limit = Math.min(matrix.length, matrix[0].length);
        List<Integer> result = new ArrayList<>();
        while (limit - 2 * inward > 1) {
            for (int i = inward; i < matrix[0].length - inward - 1; i++) {
                result.add(matrix[inward][i]);
            }

            for (int i = inward; i < matrix.length - inward - 1; i++) {
                result.add(matrix[i][matrix[0].length - inward - 1]);
            }

            for (int i = inward; i < matrix[0].length - inward - 1; i++) {
                result.add(matrix[matrix.length - 1 - inward][matrix[0].length - 1 - i]);
            }

            for (int i = inward; i < matrix.length - inward - 1; i++) {
                result.add(matrix[matrix.length - 1 - i][inward]);
            }
            inward++;
        }
        if (limit - 2 * inward == 1) {
            if (limit == matrix.length) {
                for (int i = inward; i < matrix[0].length - inward; i++) {
                    result.add(matrix[inward][i]);
                }
            } else {
                for (int i = inward; i < matrix.length - inward; i++) {
                    result.add(matrix[i][inward]);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        spiralOrder(matrix);
    }
}
