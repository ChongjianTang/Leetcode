package leetcode.p29.p2962;

import java.util.*;

public class CountSubarrays {
    //    public long countSubarrays(int[] nums, int k) {
//        List<Integer> maxIndex = new ArrayList<>();
//        maxIndex.add(-1);
//        int max = 0;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] > max) {
//                maxIndex.clear();
//                maxIndex.add(-1);
//                maxIndex.add(i);
//                max = nums[i];
//            } else if (nums[i] == max) {
//                maxIndex.add(i);
//            }
//        }
//        maxIndex.add(nums.length);
//        long count = 0;
//        for (int i = 1; i + k < maxIndex.size(); i++) {
//            count += (long) (maxIndex.get(i) - maxIndex.get(i - 1)) * (maxIndex.get(i + k) - maxIndex.get(i + k - 1));
//        }
//        return count;
//    }

    /**
     * Mar 29, 2024 00:31
     * Sliding window
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public long countSubarrays(int[] nums, int k) {
        int left = -1;
        int frequency = 0;
        int max = 0;
        long result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                left = i;
                frequency = 1;
                result = 0;
                max = nums[i];
            } else if (nums[i] == max) {
                frequency += 1;
            }
            if (frequency > k) {
                left++;
                while (nums[left] != max) {
                    left++;
                }
                frequency--;
            }
            if (frequency == k) {
                result += left + 1;
            }
        }
        return result;
    }
    //TODO: 1. Correct the initial commented approach.
    //      2. Consider this: what if the maximum is from a subarray, not from the entire 'nums' array?

    public static void main(String[] args) {
        CountSubarrays c = new CountSubarrays();
        int[] nums;
        int k;

        nums = new int[]{28, 5, 58, 91, 24, 91, 53, 9, 48, 85, 16, 70, 91, 91, 47, 91, 61, 4, 54, 61, 49};
        k = 1;
        System.out.println(c.countSubarrays(nums, k) == 187);

        nums = new int[]{1, 3, 2, 3, 3};
        k = 2;
        System.out.println(c.countSubarrays(nums, k) == 6);
    }
}
