package leetcode.p3.p324;

import java.util.Arrays;

public class WiggleSort {
    public static void wiggleSort(int[] nums) {
        for (int i = 0; i < nums.length; i += 2) {
            if (i > 0) {
                if (nums[i] == nums[i - 1]) {
                    for (int j = i + 1; j < nums.length; j++) {
                        if (nums[j] != nums[i]) {
                            int temp = nums[i - 1];
                            nums[i - 1] = nums[j];
                            nums[j] = temp;
                            break;
                        }
                    }
                }
                if (nums[i] > nums[i - 1]) {
                    int temp = nums[i];
                    nums[i] = nums[i - 1];
                    nums[i - 1] = temp;
                }
            }
            if (i + 1 < nums.length) {
                if (nums[i] == nums[i + 1]) {
                    for (int j = i + 2; j < nums.length; j++) {
                        if (nums[j] != nums[i]) {
                            int temp = nums[i];
                            nums[i] = nums[j];
                            nums[j] = temp;
                            break;
                        }
                    }
                }
                if (nums[i] > nums[i + 1]) {
                    int temp = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = temp;
                }
            }
        }
        //TODO unsolved
    }


    public static void main(String[] args) {
        int[] nums;

        nums = new int[]{5, 5, 5, 4, 4, 4, 4};
        wiggleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
