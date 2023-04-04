package leetcode.p2.p280;

import java.util.Arrays;

public class WiggleSort {
    /**
     * 08/30/2022 18:37
     * Greedy
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public static void wiggleSort(int[] nums) {
        for (int i = 0; i < nums.length; i += 2) {
            if (i > 0) {
                if (nums[i] > nums[i - 1]) {
                    int temp = nums[i];
                    nums[i] = nums[i - 1];
                    nums[i - 1] = temp;
                }
            }
            if (i + 1 < nums.length) {
                if (nums[i] > nums[i + 1]) {
                    int temp = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums;
        nums = new int[]{3, 5, 2, 1, 6, 4};
        wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
