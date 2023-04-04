package leetcode.p3.p322;

import java.util.Arrays;

public class CoinChange {
    /**
     * My method
     * TLE
     * <p>
     * Two choices
     * Use it or not
     * which one is the first to use
     */
    public int coinChange1(int[] coins, int amount) {
        return backtracking1(coins, 0, amount);
    }

    public int backtracking1(int[] coins, int index, int amount) {
        if (index == coins.length) {
            if (amount == 0) {
                return 0;
            } else {
                return -1;
            }
        } else {
            int num1 = backtracking1(coins, index + 1, amount);
            if (amount >= coins[index]) {
                int num2 = backtracking1(coins, index, amount - coins[index]);
                if (num1 == -1 && num2 == -1) {
                    return -1;
                } else if (num1 == -1) {
                    return num2 + 1;
                } else if (num2 == -1) {
                    return num1;
                } else {
                    return Math.min(num1, num2 + 1);
                }
            } else {
                return num1;
            }
        }
    }

    /**
     * My method 2
     * Updated from method 1
     * pruning
     */
//    public int coinChange(int[] coins, int amount) {
//
//    }
//
//    static int min;
//
//    public boolean backtracking2(int[] coins, int index, int amount) {
//
//    }

    /**
     * DP
     * dp(i, j) the fewest number of coins within coins[0...i] to make up the j amount of money
     * Too slow
     * Around 1800ms
     * Time complexity: O(S*n)
     * Space complexity: O(S*n)
     */
    public static int coinChange3(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount + 1];
        for (int i = 0; i < coins.length; i++) {
            dp[i][0] = 0;
        }
        for (int j = 1; j < amount + 1; j++) {
            if (j % coins[0] == 0) {
                dp[0][j] = j / coins[0];
            } else {
                dp[0][j] = -1;
            }
        }
        for (int i = 1; i < coins.length; i++) {
            for (int j = 1; j < amount + 1; j++) {
                int result = -1;
                for (int k = 1; k <= j / coins[i]; k++) {
                    int temp = dp[i][j - k * coins[i]] + k;
                    if (temp - k != -1) {
                        if (result == -1) {
                            result = temp;
                        } else {
                            result = Math.min(result, temp);
                        }
                    }
                }
                if (dp[i - 1][j] != -1) {
                    if (result == -1) {
                        result = dp[i - 1][j];
                    } else {
                        result = Math.min(result, dp[i - 1][j]);
                    }
                }
                dp[i][j] = result;
            }
        }
        return dp[coins.length - 1][amount];
    }

    /**
     * DP
     * dp(i) the fewest number of coins to make up the j amount of money
     * Much faster than previous one
     * Time complexity: O(S*n)
     * Space complexity: O(S)
     */
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i < amount + 1; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i >= coin && dp[i - coin] != -1) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
            if (dp[i] == Integer.MAX_VALUE) {
                dp[i] = -1;
            }
        }
        return dp[amount];
    }
    public static void main(String[] args) {
        int[] coins = new int[]{2, 5, 10, 1};
        System.out.println(coinChange(coins, 27));
    }
}
