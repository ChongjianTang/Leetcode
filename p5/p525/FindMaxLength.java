package leetcode.p5.p525;

import java.util.HashMap;
import java.util.Map;

public class FindMaxLength {
    /**
     * HashMap
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int max = 0;
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                count--;
            }
            if (map.containsKey(count)) {
                max = Math.max(i - map.get(count), max);
            } else {
                map.put(count, i);
            }
        }
        return max;
    }
}
