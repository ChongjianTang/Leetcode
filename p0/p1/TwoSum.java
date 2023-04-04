package leetcode.p0.p1;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    /**
     * Brute-Force
     * Time complexity: O(n^2)
     * Space complexity: O(1)
     */
    public static int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * Sorting
     * Wrong!
     * Sorting will change all indexes.
     * We need to compare the two result numbers with the original array one by one which I think it is so silly.
     * <p>
     * I used to think it is correct, but it is not!
     * I got this counterexample from p167
     * [5, 25, 75] with target 100
     * we want 25 and 75, but we will get 30.
     */
    public static int[] twoSum2(int[] nums, int target) {
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        while (i < j && nums[i] + nums[j] != target) {
            if (nums[i + 1] + nums[j] < nums[i] + nums[j - 1]) {
                i++;
            } else {
                j--;
            }
        }
        /*
          the correct one!
         */
//        int val = numbers[i] + numbers[j];
//        while (i < j && val != target) {
//            if (val > target) {
//                j--;
//            } else {
//                i++;
//            }
//            val = numbers[i] + numbers[j];
//        }

        return new int[]{i, j};
    }

    /**
     * One-pass Hash-Map
     */
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }


    public static void main(String[] args) {
        int[] nums;
        int[] output;
        int[] result;

        nums = new int[]{2, 7, 11, 15};
        output = new int[]{0, 1};
        result = twoSum(nums, 9);
        Arrays.sort(result);
        System.out.println(Arrays.equals(result, output));

        nums = new int[]{3, 2, 4};
        output = new int[]{1, 2};
        result = twoSum(nums, 6);
        Arrays.sort(result);
        System.out.println(Arrays.equals(result, output));
    }
}
