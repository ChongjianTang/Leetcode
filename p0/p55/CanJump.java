package leetcode.p0.p55;

import java.util.Arrays;

public class CanJump {
    /**
     * Jun 17, 2022 19:11
     * My method and DP
     * Time complexity: O(n^2)
     * Space complexity: O(n)
     */
    public static boolean canJump1(int[] nums) {
        boolean[] OPT = new boolean[nums.length];
        Arrays.fill(OPT, false);
        OPT[nums.length - 1] = true;
        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = Math.min(i + nums[i], nums.length - 1); j > i; j--) {
                if (OPT[j]) {
                    OPT[i] = true;
                    break;
                }
            }
        }
        return OPT[0];
    }

    /**
     * Jan 18, 2023 17:42
     * My method 2
     * This is a kind of greedy algorithm I think
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public static boolean canJump2(int[] nums) {
        int max = nums[0];
        int i = 0;
        while (max < nums.length - 1 && i <= max) {
            if (i + nums[i] > max) {
                max = i + nums[i];
            }
            i++;
        }
        return max >= nums.length - 1;
    }

    public static boolean canJump(int[] nums) {
        // TODO check the solution
        return true;
    }

    public static void main(String[] args) {
        int[] nums;
        boolean output;

        nums = new int[]{2, 3, 1, 1, 4};
        output = true;

        System.out.println(canJump(nums) == output);

        nums = new int[]{3, 2, 1, 0, 4};
        output = false;
        System.out.println(canJump(nums) == output);
    }
}
