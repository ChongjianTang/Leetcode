package leetcode.p0.p16;

import java.util.Arrays;

public class ThreeSumClosest {
    /**
     * Two pointers
     * Time complexity: O(n^2)
     * Space complexity:  from O(logn) to O(n), depending on the implementation of the sorting algorithm.
     */
    public static int threeSumClosest(int[] nums, int target) {
        assert nums.length >= 3;
        Arrays.sort(nums);
        int closestNum = nums[0] + nums[1] + nums[nums.length - 1];
        int i = 0;
        while (i < nums.length - 2) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int value = nums[i] + nums[j] + nums[k];
                if (value < target) {
                    j++;
                } else if (value > target) {
                    k--;
                } else {
                    return target;
                }
                if (Math.abs(value - target) < Math.abs(closestNum - target)) {
                    closestNum = value;
                }
            }
            while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                i++;
            }
            i++;
        }
        return closestNum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 2, 1, -4};
        System.out.println(threeSumClosest(nums, 1));
    }
}
