package leetcode.p1.p174;

public class CalculateMinimumHP {
    /**
     * DP
     * Incorrect approach
     * cur(i,j) = current cost from (0,0) to (i,j)
     * minimum(i,j) = minimum health (negative) from (0,0) to (i,j) in the same path
     * Easy to design some counterexamples (in main function)
     */
    public static int calculateMinimumHP1(int[][] dungeon) {
        int[][] minimum = new int[dungeon.length][dungeon[0].length];
        int[][] cur = new int[dungeon.length][dungeon[0].length];

        cur[0][0] = dungeon[0][0];
        minimum[0][0] = cur[0][0];
        for (int i = 1; i < minimum.length; i++) {
            cur[i][0] = cur[i - 1][0] + dungeon[i][0];
            minimum[i][0] = Math.min(cur[i][0], minimum[i - 1][0]);
        }

        for (int j = 1; j < minimum[0].length; j++) {
            cur[0][j] = cur[0][j - 1] + dungeon[0][j];
            minimum[0][j] = Math.min(cur[0][j], minimum[0][j - 1]);
        }

        for (int i = 1; i < minimum.length; i++) {
            for (int j = 1; j < minimum[0].length; j++) {
                int rightMin = Math.min(cur[i][j - 1] + dungeon[i][j], minimum[i][j - 1]);
                int bottomMin = Math.min(cur[i - 1][j] + dungeon[i][j], minimum[i - 1][j]);
                if (rightMin > bottomMin) {
                    minimum[i][j] = rightMin;
                    cur[i][j] = cur[i][j - 1] + dungeon[i][j];
                } else if (bottomMin > rightMin) {
                    minimum[i][j] = bottomMin;
                    cur[i][j] = cur[i - 1][j] + dungeon[i][j];
                } else {
                    cur[i][j] = Math.max(cur[i - 1][j], cur[i][j - 1]) + dungeon[i][j];
                }
            }
        }
        return Math.max(-minimum[dungeon.length - 1][dungeon[0].length - 1], 0) + 1;
    }


    /**
     * DP
     * dp(i,j) = minimum health (negative) from (i,j) to the end in the same path
     * Time complexity: O(mn)
     * Space complexity: O(mn)
     */
    public static int calculateMinimumHP2(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m][n];
        dp[m - 1][n - 1] = Math.max(-dungeon[m - 1][n - 1], 0) + 1;

        for (int i = m - 2; i >= 0; i--) {
            dp[i][n - 1] = Math.max(dp[i + 1][n - 1] - dungeon[i][n - 1], 1);
        }
        for (int j = n - 2; j >= 0; j--) {
            dp[m - 1][j] = Math.max(dp[m - 1][j + 1] - dungeon[m - 1][j], 1);
        }

        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j];
                dp[i][j] = Math.max(dp[i][j], 1);
            }
        }
        return dp[0][0];
    }

    /**
     * DP
     * dp(i,j) = minimum health (negative) from (i,j) to the end in the same path
     * Time complexity: O(mn)
     * Space complexity: O(n)
     */
    public static int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[] dp = new int[n];
        dp[n - 1] = Math.max(-dungeon[m - 1][n - 1], 0) + 1;

        for (int j = n - 2; j >= 0; j--) {
            dp[j] = Math.max(dp[j + 1] - dungeon[m - 1][j], 1);
        }

        for (int i = m - 2; i >= 0; i--) {
            dp[n - 1] = Math.max(dp[n - 1] - dungeon[i][n - 1], 1);
            for (int j = n - 2; j >= 0; j--) {
                dp[j] = Math.min(dp[j], dp[j + 1]) - dungeon[i][j];
                dp[j] = Math.max(dp[j], 1);
            }
        }
        return dp[0];
    }


    public static void main(String[] args) {


        int[][] dungeon;
        dungeon = new int[2][4];
        dungeon[0] = new int[]{1, -4, 5, -99};
        dungeon[1] = new int[]{2, -2, -2, -1};

        System.out.println(calculateMinimumHP(dungeon) == 4);

        dungeon = new int[3][3];
        dungeon[0] = new int[]{-2, -3, 3};
        dungeon[1] = new int[]{-5, -10, 1};
        dungeon[2] = new int[]{10, 30, -5};

        System.out.println(calculateMinimumHP(dungeon) == 7);
    }
}
