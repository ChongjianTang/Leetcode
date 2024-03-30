package leetcode.p29.p2958;

import java.util.HashMap;
import java.util.Map;

public class MaxSubarrayLength {
    /**
     * Mar 27, 2024 17:23
     * Sliding window + HashMap
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public int maxSubarrayLength(int[] nums, int k) {
        int left = -1;
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!frequencyMap.containsKey(nums[i])) {
                frequencyMap.put(nums[i], 0);
            }
            while (frequencyMap.get(nums[i]) == k) {
                left++;
                frequencyMap.put(nums[left], frequencyMap.get(nums[left]) - 1);
            }
            frequencyMap.put(nums[i], frequencyMap.get(nums[i]) + 1);
            max = Math.max(i - left, max);
        }
        return max;
    }

    //TODO: Check Approach 2: Counting and Sliding Window without Nested Loops
}
