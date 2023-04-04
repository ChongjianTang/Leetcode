package leetcode.p4.p473;

import java.util.Arrays;

public class Makesquare {
    /**
     * My approach 1
     * Recursion
     * Backtracking
     * TLE
     */
    public boolean makesquare1(int[] matchsticks) {
        int sides = 4;
        int sum = 0;
        for (int matchstick : matchsticks) {
            sum += matchstick;
        }
        if (sum % sides != 0) {
            return false;
        }
        int[] edges = new int[sides];
        Arrays.fill(edges, sum / sides);
        return backtracking1(matchsticks, 0, edges);
    }

    public boolean backtracking1(int[] matchstick, int index, int[] edges) {
        if (index == matchstick.length) {
            return true;
        }
        for (int i = 0; i < edges.length; i++) {
            if (edges[i] - matchstick[index] >= 0) {
                edges[i] -= matchstick[index];
                if (backtracking1(matchstick, index + 1, edges)) {
                    return true;
                }
                edges[i] += matchstick[index];
            }
        }
        return false;
    }
}
