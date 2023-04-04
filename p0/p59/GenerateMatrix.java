package leetcode.p0.p59;

import java.util.ArrayList;
import java.util.List;

public class GenerateMatrix {
    /**
     * Nov 23, 2022 02:03
     */
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int inward = 0;
        int num = 1;
        while (n - 2 * inward > 1) {
            for (int i = inward; i < matrix[0].length - inward - 1; i++) {
                matrix[inward][i] = num;
                num++;
            }

            for (int i = inward; i < matrix.length - inward - 1; i++) {
                matrix[i][matrix[0].length - inward - 1] = num;
                num++;
            }

            for (int i = inward; i < matrix[0].length - inward - 1; i++) {
                matrix[matrix.length - 1 - inward][matrix[0].length - 1 - i] = num;
                num++;
            }

            for (int i = inward; i < matrix.length - inward - 1; i++) {
                matrix[matrix.length - 1 - i][inward] = num;
                num++;
            }
            inward++;
        }
        if (n - 2 * inward == 1) {
            matrix[inward][inward] = num;
        }
        return matrix;
    }
}
