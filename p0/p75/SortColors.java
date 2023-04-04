package leetcode.p0.p75;

import java.util.Arrays;

public class SortColors {
    /**
     * Bucket Sort
     * 2 pass alg
     */
    public static void sortColors1(int[] nums) {
        int red = 0, white = 0, blue = 0;
        for (int num : nums) {
            switch (num) {
                case 0:
                    red++;
                    break;
                case 1:
                    white++;
                    break;
                case 2:
                    blue++;
            }
        }
        for (int i = 0; i < red; i++) {
            nums[i] = 0;
        }
        for (int i = red; i < red + white; i++) {
            nums[i] = 1;
        }
        for (int i = red + white; i < nums.length; i++) {
            nums[i] = 2;
        }
    }


    /**
     * Bucket Sort
     * one-pass algorithm using only constant extra space
     * From solution
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public static void sortColors(int[] nums) {
        int p0 = 0;
        int p2 = nums.length - 1;
        int temp;
        int curr = 0;
        while (curr <= p2) {
            if (nums[curr] == 0) {
                temp = nums[curr];
                nums[curr] = nums[p0];
                nums[p0] = temp;
                p0++;
                curr++;
            } else if (nums[curr] == 2) {
                temp = nums[curr];
                nums[curr] = nums[p2];
                nums[p2] = temp;
                p2--;
            } else {
                curr++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums;
        int[] output;

        nums = new int[]{2, 0, 2, 1, 1, 0};
        output = new int[]{0, 0, 1, 1, 2, 2};

        sortColors(nums);
        System.out.println(Arrays.equals(nums, output));


        nums = new int[]{2, 0, 1};
        output = new int[]{0, 1, 2};

        sortColors(nums);
        System.out.println(Arrays.equals(nums, output));
    }
}
