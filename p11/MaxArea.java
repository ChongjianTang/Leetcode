package leetcode.p11;


public class MaxArea {
    /**
     * Brute Force -- O(n2)
     * Time Limit Exceeded
     */
    public static int maxArea1(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = (j - i) * Math.min(height[i], height[j]);
                if (area > max) {
                    max = area;
                }
            }
        }
        return max;
    }


    /**
     * A DP try.
     * This is a wrong method.
     */
    public static int maxArea2(int[] height) {
        int[][] maxPositions = new int[height.length][3];
        maxPositions[1][0] = 0;
        maxPositions[1][1] = 1;
        maxPositions[1][2] = Math.min(height[0], height[1]);
        for (int i = 2; i < height.length; i++) {
            int origin = maxPositions[i - 1][2];
            int xArea = (i - maxPositions[i - 1][0]) * Math.min(height[i], height[maxPositions[i - 1][0]]);
            int yArea = (i - maxPositions[i - 1][1]) * Math.min(height[i], height[maxPositions[i - 1][1]]);
            int max = Math.max(origin, Math.max(xArea, yArea));
            if (max == origin) {
                maxPositions[i][0] = maxPositions[i - 1][0];
                maxPositions[i][1] = maxPositions[i - 1][1];
                maxPositions[i][2] = maxPositions[i - 1][2];
            } else if (max == yArea) {
                maxPositions[i][0] = maxPositions[i - 1][1];
                maxPositions[i][1] = i;
                maxPositions[i][2] = yArea;
            } else {
                maxPositions[i][0] = maxPositions[i - 1][0];
                maxPositions[i][1] = i;
                maxPositions[i][2] = xArea;
            }
        }
        return maxPositions[height.length - 1][2];
    }

    /**
     * Two Pointers
     */
    public static int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int max = (j - i) * Math.min(height[0], height[height.length - 1]);
        while (i < j) {
            int iHeight = height[i];
            int jHeight = height[j];
            if (iHeight < jHeight) {
                i++;
                while (height[i] <= iHeight && i < j) {
                    i++;
                }
            } else {
                j--;
                while (height[j] <= jHeight && i < j) {
                    j--;
                }
            }
            int area = (j - i) * Math.min(height[i], height[j]);
            if (area > max) {
                max = area;
            }
        }
        return max;
    }


    public static void main(String[] args) {
        int[] a = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea1(a) == 49);
    }
}
