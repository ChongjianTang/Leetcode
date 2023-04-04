package leetcode.p3.p338;

import java.util.Arrays;

public class CountBits {
    /**
     * 09/05/2022 20:11
     * My approach
     * DP and change the leftmost 1 bit to 0
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public static int[] countBits(int n) {
        int[] result = new int[n + 1];
        result[0] = 0;
        if (n == 0) {
            return result;
        }
        result[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 32; j++) {
                if (((1 << 31 - j) & i) == 1 << 31 - j) {
                    result[i] = result[i & ~(1 << 31 - j)] + 1;
                    break;
                }
            }
        }
        return result;
    }

    // TODO

    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(5)));
    }
}
