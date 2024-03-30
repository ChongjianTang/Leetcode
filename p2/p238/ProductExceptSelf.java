package leetcode.p2.p238;

public class ProductExceptSelf {
    /**
     * Mar 14, 2024 22:31
     * DP and no division operations
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public int[] productExceptSelf1(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        left[0] = nums[0];
        right[nums.length - 1] = nums[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i];
            right[nums.length - 1 - i] = right[nums.length - i] * nums[nums.length - 1 - i];
        }
        int[] result = new int[nums.length];
        result[0] = right[1];
        result[nums.length - 1] = left[nums.length - 2];
        for (int i = 1; i < nums.length - 1; i++) {
            result[i] = right[i + 1] * left[i - 1];
        }
        return result;
    }

    /**
     * Mar 14, 2024 22:51
     * Update from solution 1 and now O(1) space complexity
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] = result[i] * right;
            right *= nums[i];
        }
        return result;
    }
}
