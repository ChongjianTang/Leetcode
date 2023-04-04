package leetcode.p2055;

import java.util.Arrays;

public class PlatesBetweenCandles {
    /**
     * Brute Force
     * TLE
     * O(n^2)
     */
    public static int[] platesBetweenCandles1(String s, int[][] queries) {
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = helper1(s.substring(queries[i][0], queries[i][1] + 1));
        }
        return result;
    }

    public static int helper1(String s) {
        s = s.replace("*", " ");
        s = s.trim();
        s = s.replace("|", "");
        return s.length();
    }

    public static int[] platesBetweenCandles(String s, int[][] queries) {
        int[] preSum = new int[s.length()];
        if (s.charAt(0) == '|') {
            preSum[0] = 0;
        } else {
            preSum[0] = 1;
        }
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '|') {
                preSum[i] = preSum[i - 1];
            } else {
                preSum[i] = preSum[i - 1] + 1;
            }
        }

        int[] left = new int[s.length()];
        int[] right = new int[s.length()];

        int candle = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '*') {
                candle = i;
            }
            right[i] = candle;
        }

        candle = -1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != '*') {
                candle = i;
            }
            left[i] = candle;
        }

        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            if (left[queries[i][0]] == -1 || right[queries[i][1]] == -1) {
                result[i] = 0;
            } else {
                result[i] = Math.max(0, preSum[right[queries[i][1]]] - preSum[left[queries[i][0]]]);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        String s;
        int[][] queries;

        s = "***|**|*****|**||**|*";
        queries = new int[][]{
                {1, 17},
                {4, 5},
                {14, 17},
                {5, 11},
                {15, 16}
        };
        System.out.println(Arrays.equals(platesBetweenCandles(s, queries), new int[]{9, 0, 0, 0, 0}));

        s = "**|**|***|";
        queries = new int[][]{
                {2, 5},
                {5, 9}
        };
        System.out.println(Arrays.equals(platesBetweenCandles(s, queries), new int[]{2, 3}));
    }
}
