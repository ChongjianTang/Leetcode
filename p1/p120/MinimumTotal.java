package leetcode.p1.p120;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class MinimumTotal {
    /**
     * My approach
     * DP
     * Time complexity: O(n^2)
     * Space complexity: O(n^2)
     */
    public int minimumTotal1(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);
            }
            dp[i][i] = dp[i - 1][i - 1] + triangle.get(i).get(i);
        }
        int min = dp[dp.length - 1][0];
        for (int i = 1; i < dp.length; i++) {
            min = Math.min(dp[dp.length - 1][i], min);
        }
        return min;
    }

    /**
     * DP in-place
     * Time complexity: O(n^2)
     * Space complexity: O(1)
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int length = triangle.size();
        for (int i = 1; i < length; i++) {
            triangle.get(i).set(0, triangle.get(i - 1).get(0) + triangle.get(i).get(0));
            for (int j = 1; j < i; j++) {
                triangle.get(i).set(j, Math.min(triangle.get(i - 1).get(j), triangle.get(i - 1).get(j - 1)) + triangle.get(i).get(j));
            }
            triangle.get(i).set(i, triangle.get(i - 1).get(i - 1) + triangle.get(i).get(i));
        }
        return Collections.min(triangle.get(length - 1));
    }
}
