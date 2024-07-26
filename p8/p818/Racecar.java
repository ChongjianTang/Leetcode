package leetcode.p8.p818;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Racecar {
    /**
     * Apr 23, 2024 12:55
     * BSF+pruning
     * Time Complexity: O(2^n) (Before pruning)
     * Space Complexity: O(2^n)
     */
    public int racecar1(int target) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 1});
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add(Arrays.toString(new int[]{0, 1}));
        int count = 0;
        while (!queue.isEmpty()) {
            count++;
            Queue<int[]> nextQueue = new LinkedList<>();
            while (!queue.isEmpty()) {
                int[] curr = queue.poll();
                int[] a = new int[]{curr[0] + curr[1], curr[1] * 2};
                if (a[0] == target) {
                    return count;
                }
                if (!hashSet.contains(Arrays.toString(a)) && Math.abs(target - a[0]) < target) {
                    nextQueue.offer(a);
                    hashSet.add(Arrays.toString(a));
                }
                int[] r = new int[]{curr[0], 0};
                if (curr[1] > 0) {
                    r[1] = -1;
                } else {
                    r[1] = 1;
                }
                if (!hashSet.contains(Arrays.toString(r))) {
                    nextQueue.offer(r);
                    hashSet.add(Arrays.toString(r));
                }
            }
            queue = nextQueue;
        }
        return -1;
    }

    /**
     * Apr 23, 2024 15:50
     * DP, a very good dp example
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public int racecar(int target) {
        int[] dp = new int[target + 1];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
            int step = 1;
            int distance = (1 << step) - 1;
            while (distance < i) {
                for (int j = 0; j < step; j++) {
                    int newDistance = distance - (1 << j) + 1;
                    dp[i] = Math.min(dp[i], step + 1 + j + 1 + dp[i - newDistance]);
                }
                step++;
                distance = (1 << step) - 1;
            }
            if (distance == i) {
                dp[i] = Math.min(step, dp[i]);
            } else {
                dp[i] = Math.min(dp[i], step + 1 + dp[distance - i]);
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        Racecar r = new Racecar();
        for(int i = 1 ;i <= 50;i++) {
            System.out.println(r.racecar(i));
        }

//        System.out.println(r.racecar(5478));
    }
}
