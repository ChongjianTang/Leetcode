package leetcode.p0.p45;

import java.util.Arrays;

public class Jump {
    /**
     * Jan 18, 2023 18:02
     * DP
     * Time complexity: O(n^2)
     * Space complexity: O(n)
     */
    public static int jump1(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                for (int j = Math.min(i + nums[i], nums.length - 1); j > i; j--) {
                    dp[j] = Math.min(dp[i] + 1, dp[j]);
                }
            }
        }
        return dp[dp.length - 1];
    }

    /**
     * Jan 20, 2023 18:53
     * My greedy algorithm
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public static int jump2(int[] nums) {
        int max = 0;
        int i = -1;
        int count = 0;
        while (max < nums.length - 1) {
            int newMax = max;
            for (int j = i + 1; j <= max; j++) {
                newMax = Math.max(newMax, nums[j] + j);
            }
            i = max;
            max = newMax;
            count++;
        }
        return count;
    }

    /**
     * Official solution
     * Greedy
     */
    public static int jump(int[] nums) {
        // The starting range of the first jump is [0, 0]
        int answer = 0, n = nums.length;
        int curEnd = 0, curFar = 0;

        for (int i = 0; i < n - 1; ++i) {
            // Update the farthest reachable index of this jump.
            curFar = Math.max(curFar, i + nums[i]);

            // If we finish the starting range of this jump,
            // Move on to the starting range of the next jump.
            if (i == curEnd) {
                answer++;
                curEnd = curFar;
            }
        }
        return answer;
    }


    public static void main(String[] args) {
        int[] nums;
        nums = new int[]{2, 3, 1, 1, 4};
        System.out.println(jump(nums) == 2);

        nums = new int[]{2, 1};
        System.out.println(jump(nums) == 1);

        nums = new int[]{7, 0, 9, 6, 11, 6, 1, 6, 9, 0, 1, 2, 9, 0, 3};
        System.out.println(jump(nums) == 2);
    }
}
