package leetcode.p0.p53;

public class MaxSubArray {
    /**
     * Brute Force -- O(n^2)
     * TLE
     */
    public static int maxSubArray1(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }

    /**
     * This idea is from p560 and p121
     * Really clever!
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public static int maxSubArray2(int[] nums) {
        int max = nums[0];
        int minSum = 0;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (sum - minSum > max) {
                max = sum - minSum;
            }
            if (sum < minSum) {
                minSum = sum;
            }
        }
        return max;
    }

    /**
     * DP
     * dp(i) = subarray end at index i => space optimized
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public static int maxSubArray3(int[] nums) {
        int[] OPT = new int[2];
        OPT[0] = nums[0];
        int max = OPT[0];
        for (int i = 1; i < nums.length; i++) {
            OPT[1] = Math.max(OPT[0] + nums[i], nums[i]);
            if (OPT[1] > max) {
                max = OPT[1];
            }
            OPT[0] = OPT[1];
        }
        return max;
    }

    /**
     * Kadane's Algorithm
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public static int maxSubArray5(int[] nums) {
        int cur = 0;
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            cur += nums[i];
            max = Math.max(cur, max);
            if (cur < 0) {
                cur = 0;
            }
        }
        return max;

    }


    /**
     * Divide and Conquer
     */
    public static int maxSubArray(int[] nums) {
        //FIXME
        return 0;
    }

    public static int helper(int[] nums, int start, int end) {
        //FIXME
        if (end - start == 1) {
            return nums[start];
        }
        return 0;
    }


    public static void main(String[] args) {
        int[] nums;

        nums = new int[]{-1};
        System.out.println(maxSubArray(nums) == -1);

        nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums) == 6);
    }
}
