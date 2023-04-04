package leetcode.p5.p560;

import java.util.HashMap;

public class SubarraySum {
    /**
     * Brute Force
     * O(n^2)
     * Time Limit Exceeded but bSometimes 1225 ms
     * Really confusing
     */
    public static int subarraySum1(int[] nums, int k) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    result++;
                }
            }
        }
        return result;
    }

    /**
     * An updated method from brute force -- still O(n^2)
     * 2000+ ms
     */
    public static int subarraySum2(int[] nums, int k) {
        int[] sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        int result = 0;
        for (int i = 0; i < nums.length + 1; i++) {
            for (int j = i + 1; j < nums.length + 1; j++) {
                if (sum[j] - sum[i] == k) {
                    result++;
                }
            }
        }
        return result;
    }

    /**
     * Using HashMap
     */
    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0;
        int sum = 0;
        for (int num : nums) {
            sum = sum + num;
            if (map.get(sum - k) != null) {
                count += map.get(sum - k);
            }
            map.merge(sum, 1, Integer::sum);

        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums;

        nums = new int[]{1, -1, 0};
        System.out.println(subarraySum(nums, 0) == 3);

        nums = new int[]{1, 2, 3};
        System.out.println(subarraySum(nums, 3) == 2);

        nums = new int[]{1, 1, 1};
        System.out.println(subarraySum(nums, 2) == 2);
    }
}
