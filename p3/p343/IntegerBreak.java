package leetcode.p3.p343;

public class IntegerBreak {
    /**
     * Feb 18, 2024 00:36
     * DP
     * Time Complexity: O(n^2)
     * Space Complexity: O(n)
     */
    public int integerBreak1(int n) {
        if (n == 2) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[2] = 2;
        dp[1] = 1;
        if (n == 3) {
            return 2;
        } else {
            dp[3] = 3;
        }
        if (n > 3) {
            dp[4] = 4;
        }
        for (int i = 5; i < dp.length; i++) {
            int left = 1;
            int right = i - 1;
            int max = 0;
            while (left <= right) {
                max = Math.max(max, dp[left] * dp[right]);
                left += 1;
                right -= 1;
            }
            dp[i] = max;
        }
        return dp[n];
    }

    /**
     * Feb 18, 2024 00:44
     * Math
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int integerBreak2(int n) {
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        if (n == 4) {
            return 4;
        }
        int result = 1;
        while (n > 4) {
            n -= 3;
            result *= 3;
        }
        if (n != 0) {
            result *= n;
        }
        return result;
    }

    /**
     * Feb 18, 2024 00:53
     * A better Math approach
     * Time Complexity: O(logn)
     * Space Complexity: O(1)
     */
    public int integerBreak(int n) {
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        if (n == 4) {
            return 4;
        }

        int power = n / 3;
        int mod = n % 3;
        if (mod == 1) {
            return (int) Math.pow(3, power - 1) * 4;
        } else if (mod == 2) {
            return (int) Math.pow(3, power) * 2;
        } else {
            return (int) Math.pow(3, power);
        }
    }


    public static void main(String[] args) {
        IntegerBreak i = new IntegerBreak();
        int n = 10;
        System.out.println(i.integerBreak(n) == 36);
        n = 3;
        System.out.println(i.integerBreak(n) == 2);
    }
}
