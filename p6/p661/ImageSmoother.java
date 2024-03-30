package leetcode.p6.p661;

public class ImageSmoother {
    /**
     * Mar 05, 2024 09:21
     * Brute Force
     * Time Complexity: O(m*n)
     * Space Complexity: O(1)
     */
    public int[][] imageSmoother(int[][] img) {
        int[][] result = new int[img.length][img[0].length];
        int[] di = new int[]{1, 1, 1, -1, -1, -1, 0, 0};
        int[] dj = new int[]{1, -1, 0, 1, -1, 0, 1, -1};
        for (int i = 0; i < img.length; i++) {
            for (int j = 0; j < img[0].length; j++) {
                int count = 1;
                int val = img[i][j];
                for (int k = 0; k < di.length; k++) {
                    int newI = i + di[k];
                    int newJ = j + dj[k];
                    if (newI >= 0 && newI < img.length && newJ >= 0 && newJ < img[0].length) {
                        count++;
                        val += img[newI][newJ];
                    }
                    result[i][j] = val / count;
                }
            }
        }
        return result;
    }
}
