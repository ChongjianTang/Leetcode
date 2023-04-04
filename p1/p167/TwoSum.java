package leetcode.p1.p167;

import java.util.Arrays;

/**
 * Your solution must use only constant extra space.
 */
public class TwoSum {
    /**
     * Two pointer
     * Time complexity: O(n)
     * Space complexity: O(1)
     * Too easy
     */
    public static int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        int val = numbers[i] + numbers[j];
        while (i < j && val != target) {
            if (val > target) {
                j--;
            } else {
                i++;
            }
            val = numbers[i] + numbers[j];
        }
        return new int[]{i + 1, j + 1};
    }

    public static void main(String[] args) {
        int[] numbers;
        int target;
        int[] output;

        numbers = new int[]{2, 7, 11, 15};
        target = 9;
        output = new int[]{1, 2};
        System.out.println(Arrays.equals(twoSum(numbers, target), output));

        numbers = new int[]{2, 3, 4};
        target = 6;
        output = new int[]{1, 3};
        System.out.println(Arrays.equals(twoSum(numbers, target), output));

        numbers = new int[]{-1, 0};
        target = -1;
        output = new int[]{1, 2};
        System.out.println(Arrays.equals(twoSum(numbers, target), output));

        numbers = new int[]{5, 25, 75};
        target = 100;
        output = new int[]{2, 3};
        System.out.println(Arrays.equals(twoSum(numbers, target), output));
    }

}
