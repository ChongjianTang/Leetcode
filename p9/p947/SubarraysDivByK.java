package leetcode.p9.p947;

import java.util.HashMap;
import java.util.Map;

public class SubarraysDivByK {
    /**
     * Jun 09, 2024 00:53
     * Prefix Sums
     */
    public int subarraysDivByK(int[] nums, int k) {
        int sum = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sum %= k;
            if (sum < 0) {
                sum += k;
            }
            if (map.containsKey(sum)) {
                count += map.get(sum);
                map.put(sum, map.get(sum) + 1);
            } else {
                map.put(sum, 1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        SubarraysDivByK s = new SubarraysDivByK();
        int[] nums;
        int k;

        nums = new int[]{4, 5, 0, -2, -3, 1};
        k = 5;
        System.out.println(s.subarraysDivByK(nums, k) == 7);
    }
}
