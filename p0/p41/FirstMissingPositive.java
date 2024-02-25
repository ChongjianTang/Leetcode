package leetcode.p0.p41;

import java.util.Arrays;
import java.util.HashSet;

public class FirstMissingPositive {

    /**
     * 08/30/2022 17:25
     * Sort
     * Time complexity: O(nlogn)
     * Space complexity: O(1)
     */
    public static int firstMissingPositive1(int[] nums) {
        Arrays.sort(nums);
        int result = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                result++;
                int j = i;
                while (j + 1 < nums.length && (nums[j] + 1 == nums[j + 1] || nums[j] == nums[j + 1])) {
                    if (nums[j] + 1 == nums[j + 1]) {
                        result++;
                    }
                    j++;
                }
                break;
            }
        }
        return result;
    }


    /**
     * 08/30/2022 17:33
     * Store values in an array
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public static int firstMissingPositive2(int[] nums) {
        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 && nums[i] <= nums.length) {
                temp[nums[i] - 1] = nums[i];
            }
        }
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] != i + 1) {
                return i + 1;
            }
        }
        return temp.length + 1;
    }


    /**
     * 08/30/2022 17:51
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public static int firstMissingPositive3(int[] nums) {
        int i = 0;
        int temp;
        while (i < nums.length) {
            if (nums[i] != i + 1) {
                if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                    temp = nums[i] - 1;
                    nums[i] = nums[temp];
                    nums[temp] = temp + 1;
                } else {
                    i++;
                }
            } else {
                i++;
            }
        }
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                return j + 1;
            }
        }
        return nums.length + 1;
    }

    /**
     * 08/30/2022 17:51
     * HashSet
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public static int firstMissingPositive4(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 && nums[i] <= nums.length) {
                set.add(nums[i]);
            }
        }
        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return nums.length + 1;
    }

    /**
     * 08/30/2022 18:03
     * An updated method from my method (the 3rd one).
     * Use negative numbers to store the information
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public static int firstMissingPositive5(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0 || nums[i] > nums.length) {
                nums[i] = 0;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (nums[Math.abs(nums[i]) - 1] == 0) {
                    nums[Math.abs(nums[i]) - 1] = -1 * Math.abs(nums[i]);
                } else if (nums[Math.abs(nums[i]) - 1] > 0) {
                    nums[Math.abs(nums[i]) - 1] *= -1;
                }
            }
        }
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] >= 0) {
                return j + 1;
            }
        }
        return nums.length + 1;
    }

    /**
     * Feb 19, 2024 23:23
     * My approach, two pass
     * Index as a hash key
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int index = i;
            while (nums[index] <= nums.length && nums[index] > 0 && nums[index] != index + 1 && nums[nums[index] - 1] != nums[index]) {
                int temp = nums[index];
                nums[index] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }


    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{3, 4, 0, 2}) == 1);
        System.out.println(firstMissingPositive(new int[]{1, 2, 3}) == 4);
        System.out.println(firstMissingPositive(new int[]{1, 1}) == 2);
        System.out.println(firstMissingPositive(new int[]{7, 8, 9, 11, 12}) == 1);
        System.out.println(firstMissingPositive(new int[]{0, 1, 2}) == 3);
        System.out.println(firstMissingPositive(new int[]{3, 4, -1, 1}) == 2);
    }
}
