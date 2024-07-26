package leetcode.p5.p523;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CheckSubarraySum {
    /**
     * Jun 07, 2024 22:46
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sum %= k;
            nums[i] = sum;
            if (map.containsKey(sum) && map.get(sum) != i - 1) {
                return true;
            } else {
                if (!map.containsKey(sum)) {
                    map.put(sum, i);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CheckSubarraySum c = new CheckSubarraySum();
        int[] nums;
        int k;

        nums = new int[]{23, 2, 4, 6, 6};
        k = 7;
        System.out.println(!c.checkSubarraySum(nums, k));
    }
}
