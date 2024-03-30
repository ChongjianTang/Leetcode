package leetcode.p9.p930;

import java.util.HashMap;
import java.util.Map;

public class NumSubarraysWithSum {
    /**
     * Mar 13, 2024 18:24
     * Math
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
                map.put(count, i);
            }
        }
        map.put(count + 1, nums.length);
        int sum = 0;
        if (goal == 0) {
            for (int i = 0; i < count + 1; i++) {
                int length = map.get(i + 1) - map.get(i) - 1;
                sum += (1 + length) * length / 2;
            }
            return sum;
        } else {
            for (int i = 1; i < count + 2 - goal; i++) {
                int leftZero = map.get(i) - map.get(i - 1) - 1;
                int rightZero = map.get(i + goal) - map.get(i + goal - 1) - 1;
                sum += (leftZero + 1) * (rightZero + 1);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        NumSubarraysWithSum n = new NumSubarraysWithSum();
        int[] nums = new int[]{1, 0, 1, 0, 1};
        int goal = 2;
        int expected = 4;
        System.out.println(n.numSubarraysWithSum(nums, goal) == expected);
    }
}
