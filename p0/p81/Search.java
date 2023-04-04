package leetcode.p0.p81;

public class Search {
    /**
     * 08/30/2022 11:32
     * My approach
     * Time complexity: O(n) worst case, O(logn) best case
     *
     * But there is a catch,
     * if arr[mid] equals arr[start],
     * then we know that arr[mid] might belong to both F and S
     * and hence we cannot find the relative position of target from it.
     */
    public static boolean search(int[] nums, int target) {
        if (nums[0] < nums[nums.length - 1]) {
            return binarySearch1(nums, 0, nums.length, target);
        } else {
            return helper1(nums, 0, nums.length, target);
        }
    }

    public static boolean helper1(int[] nums, int start, int end, int target) {
        if (start >= end) {
            return false;
        }
        int middle = start + (end - start) / 2;
        int val = nums[middle];
        if (val == target) {
            return true;
        }
        if (val > nums[start]) {
            if (target >= nums[start] && target < val) {
                return binarySearch1(nums, start, middle, target);
            } else {
                return helper1(nums, middle + 1, end, target);
            }
        } else if (val < nums[start]) {
            if (target <= nums[end - 1] && target > val) {
                return binarySearch1(nums, middle + 1, end, target);
            } else {
                return helper1(nums, start, middle, target);
            }
        } else {
            for (int i = start; i < end; i++) {
                if (nums[i] == target) {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * Actually we don't need a special function to deal with the special condition.
     */
    public static boolean binarySearch1(int[] nums, int start, int end, int target) {
        if (start >= end) {
            return false;
        }
        int index = (end + start) / 2;
        if (nums[index] == target) {
            return true;
        } else if (nums[index] < target) {
            return binarySearch1(nums, index + 1, end, target);
        } else {
            return binarySearch1(nums, start, index, target);
        }
    }

    public static void main(String[] args) {
        int[] nums;

        nums = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1};
        System.out.println(search(nums, 2));

        nums = new int[]{3, 5, 1};
        System.out.println(search(nums, 3));
    }
}
