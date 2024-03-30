package leetcode.p30.p3005;

import java.util.HashMap;
import java.util.Map;

public class MaxFrequencyElements {
    /**
     * Mar 08, 2024 00:48
     * Too easy
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> frequencies = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!frequencies.containsKey(nums[i])) {
                frequencies.put(nums[i], 1);
            } else {
                frequencies.put(nums[i], frequencies.get(nums[i]) + 1);
            }
        }
        int max = 0;
        int count = 0;
        for (int key : frequencies.keySet()) {
            if (frequencies.get(key) > max) {
                max = frequencies.get(key);
                count = 1;
            } else if (frequencies.get(key) == max) {
                count++;
            }
        }
        return count * max;
    }
}
