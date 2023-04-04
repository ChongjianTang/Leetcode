package leetcode.p1.p152;

public class MaxProduct {
    /**
     * DP
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public int maxProduct1(int[] nums) {
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];

        max[0] = nums[0];
        min[0] = nums[0];

        int maxProduct = max[0];
        for (int i = 1; i < max.length; i++) {
            if (nums[i] > 0) {
                max[i] = Math.max(nums[i], max[i - 1] * nums[i]);
                min[i] = Math.min(nums[i], min[i - 1] * nums[i]);
            } else if (nums[i] < 0) {
                max[i] = Math.max(nums[i], min[i - 1] * nums[i]);
                min[i] = Math.min(nums[i], max[i - 1] * nums[i]);
            }
            if (max[i] > maxProduct) {
                maxProduct = max[i];
            }
        }
        return maxProduct;
    }

    /**
     * DP
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];

        int result = max;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                max = Math.max(nums[i], max * nums[i]);
                min = Math.min(nums[i], min * nums[i]);
            } else if (nums[i] < 0) {
                int temp = max;
                max = Math.max(nums[i], min * nums[i]);
                min = Math.min(nums[i], temp * nums[i]);
            } else {
                max = 0;
                min = 0;
            }
            if (max > result) {
                result = max;
            }
        }
        return result;
    }
}
