package leetcode.p7.p713;

public class NumSubarrayProductLessThanK {
    /**
     * Mar 27, 2024 00:38
     * Sliding window
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = -1;
        int product = 1;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            product *= nums[i];
            while (left < i && product >= k) {
                left++;
                product /= nums[left];
            }
            result += i - left;
        }
        return result;
    }
}
