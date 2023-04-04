package leetcode.p5.p509;

public class Fib {
    /**
     * DP
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public int fib1(int n) {
        if (n == 0) {
            return 0;
        }
        int prev = 0;
        int cur = 1;
        int result = cur;
        for (int i = 1; i < n; i++) {
            result = cur + prev;
            prev = cur;
            cur = result;
        }
        return result;
    }

    /**
     * Math
     * Time complexity: O(logn)
     * Space complexity: O(1)
     */
    public int fib(int n) {
        double goldenRatio = (1 + Math.sqrt(5)) / 2;
        return (int) Math.round(Math.pow(goldenRatio, n) / Math.sqrt(5));
    }

}
