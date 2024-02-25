package leetcode.p2.p276;

public class NumWays {
    /**
     * Feb 17, 2024 01:50
     * DP
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public int numWays(int n, int k) {
        if (k == 1 && n >= 3) {
            return 0;
        }
        int[] same = new int[n];
        int[] diff = new int[n];
        same[0] = 0;
        diff[0] = k;
        if (n > 1) {
            same[1] = k;
            diff[1] = k * (k - 1);
        } else {
            return k;
        }
        for (int i = 2; i < n; i++) {
            same[i] = diff[i - 1];
            diff[i] = (same[i - 1] + diff[i - 1]) * (k - 1);
        }
        return same[n - 1] + diff[n - 1];
    }

    public static void main(String[] args) {
        NumWays numWays = new NumWays();
        int n = 3;
        int k = 2;
        System.out.println(numWays.numWays(n, k) == 6);
        n = 1;
        k = 1;
        System.out.println(numWays.numWays(n, k) == 1);
        n = 7;
        k = 2;
        System.out.println(numWays.numWays(n, k) == 42);
    }
}
