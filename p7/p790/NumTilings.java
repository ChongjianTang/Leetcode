package leetcode.p7.p790;

public class NumTilings {
    public static int numTilings(int n) {
        if (n == 1) {
            return 1;
        }
        int MOD = 1000000007;
        long[][] dp = new long[n + 1][3];
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[0][2] = 0;
        dp[1][0] = 1;
        dp[1][1] = 1;
        dp[1][2] = 1;
        for (int i = 2; i < n + 1; i++) {
            dp[i][0] = (dp[i - 2][2] + dp[i - 2][1] + dp[i - 1][0] + dp[i - 2][0]) % MOD;
            dp[i][1] = (dp[i - 1][2] + dp[i - 1][0]) % MOD;
            dp[i][2] = (dp[i - 1][1] + dp[i - 1][0]) % MOD;
        }
        return (int) dp[n][0];
    }

    public static void main(String[] args) {
        System.out.println(numTilings(1) == 1);
        System.out.println(numTilings(2) == 2);
        System.out.println(numTilings(3) == 5);
        System.out.println(numTilings(4) == 11);
        System.out.println(numTilings(5) == 24);
        System.out.println(numTilings(6) == 53);
        System.out.println(numTilings(7) == 117);
        System.out.println(numTilings(8) == 258);
        System.out.println(numTilings(9) == 569);
        System.out.println(numTilings(10) == 1255);
        System.out.println(numTilings(20) == 3418626);
        System.out.println(numTilings(30) == 312342182);
    }
}
