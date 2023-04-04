package leetcode.p2.p283;

import java.util.Arrays;

public class MoveZeroes {
    /**
     * My approach
     */
    public static void moveZeroes1(int[] nums) {
        int indexOfZero = 0;
        int indexOfNonZero;

        while (nums[indexOfZero] != 0) {
            indexOfZero++;
            if (indexOfZero == nums.length) {
                return;
            }
        }

        indexOfNonZero = indexOfZero;
        while (nums[indexOfNonZero] == 0) {
            indexOfNonZero++;
            if (indexOfNonZero == nums.length) {
                return;
            }
        }

        while (indexOfNonZero < nums.length) {
            nums[indexOfZero] = nums[indexOfNonZero];
            nums[indexOfNonZero] = 0;
            indexOfZero++;
            while (indexOfNonZero < nums.length && nums[indexOfNonZero] == 0) {
                indexOfNonZero++;
            }
        }
    }

    public static void moveZeroes(int[] nums) {
        int indexOfNonZero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[indexOfNonZero];
                nums[indexOfNonZero] = temp;
                indexOfNonZero++;
            }
        }
    }


    public static void main(String[] args) {
        int[] nums;
        int[] output;

        nums = new int[]{0, 1, 0, 3, 12};
        output = new int[]{1, 3, 12, 0, 0};

        moveZeroes(nums);
        System.out.println(Arrays.equals(nums, output));

        nums = new int[]{0};
        output = new int[]{0};

        moveZeroes(nums);
        System.out.println(Arrays.equals(nums, output));

        nums = new int[]{1, 0};
        output = new int[]{1, 0};

        moveZeroes(nums);
        System.out.println(Arrays.equals(nums, output));
    }
}
