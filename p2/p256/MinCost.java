package leetcode.p2.p256;

public class MinCost {
    /**
     * DP
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public int minCost(int[][] costs) {
        if (costs.length == 0) {
            return 0;
        }
        for (int i = 1; i < costs.length; i++) {
            costs[i][0] = Math.min(costs[i - 1][1], costs[i - 1][2]) + costs[i][0];
            costs[i][1] = Math.min(costs[i - 1][0], costs[i - 1][2]) + costs[i][1];
            costs[i][2] = Math.min(costs[i - 1][1], costs[i - 1][0]) + costs[i][2];
        }
        return Math.min(costs[costs.length - 1][0], Math.min(costs[costs.length - 1][1], costs[costs.length - 1][2]));
    }
}
