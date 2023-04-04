package leetcode.p2.p268;

import java.util.HashSet;

public class MissingNumber {
    /**
     * Brute Force
     * Time complexity: O(n^2)
     * Space complexity: O(1)
     * 237ms
     */
    public static int missingNumber1(int[] nums) {
        boolean flag;
        for (int i = 0; i < nums.length; i++) {
            flag = false;
            for (int num : nums) {
                if (num == i) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                return i;
            }
        }
        return nums.length;
    }

    /**
     * HashSet
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public static int missingNumber2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return nums.length;
    }

    /**
     * Bit Manipulation
     * Time complexity: O(n)
     * Space complexity: O(1)
     * AND &
     * OR |
     * NOT ~
     * XOR ^
     * Left shift <<
     * Arithmetic/signed right shift >>
     * Logical/unsigned right shift >>>
     */
    public static int missingNumber3(int[] nums) {
        int result = nums.length;
        for (int i = 0; i < nums.length; i++) {
            result = result ^ i ^ nums[i];
        }
        return result;
    }

    /**
     * Gauss' Formula
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public static int missingNumber(int[] nums) {
        int sum = (1 + nums.length) * nums.length / 2;
        for (int i = 0; i < nums.length; i++) {
            sum -= nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums;
        int output;

        nums = new int[]{3, 0, 1};
        output = 2;
        System.out.println(missingNumber(nums) == output);

        nums = new int[]{0, 1};
        output = 2;
        System.out.println(missingNumber(nums) == output);

        nums = new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1};
        output = 8;
        System.out.println(missingNumber(nums) == output);
    }
}
