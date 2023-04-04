package leetcode.p0.p33;

public class Search {

    /**
     * 08/29/2022 19:05
     * An updated binary search.
     * Recursion
     */
    public static int search(int[] nums, int target) {
        if (nums[0] <= nums[nums.length - 1]) {
            return binarySearch1(nums, 0, nums.length, target);
        } else {
            return helper1(nums, 0, nums.length, target);
        }
    }

    public static int helper1(int[] nums, int start, int end, int target) {
        if (start >= end) {
            return -1;
        }
        int middle = start + (end - start) / 2;
        int val = nums[middle];
        if (val == target) {
            return middle;
        }
        if (val >= nums[start]) {
            if (target >= nums[start] && target < val) {
                return binarySearch1(nums, start, middle, target);
            } else {
                return helper1(nums, middle + 1, end, target);
            }
        } else {
            if (target <= nums[end - 1] && target > val) {
                return binarySearch1(nums, middle + 1, end, target);
            } else {
                return helper1(nums, start, middle, target);
            }
        }
    }

    /**
     * Actually we don't need a special function to deal with the special condition.
     */
    public static int binarySearch1(int[] nums, int start, int end, int target) {
        if (start >= end) {
            return -1;
        }
        int index = (end + start) / 2;
        if (nums[index] == target) {
            return index;
        } else if (nums[index] < target) {
            return binarySearch1(nums, index + 1, end, target);
        } else {
            return binarySearch1(nums, start, index, target);
        }
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{3, 1}, 3) == 0);
        System.out.println(search(new int[]{1, 3}, 4) == -1);
        System.out.println(search(new int[]{3, 1}, 4) == -1);
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        System.out.println(search(nums, 0) == 4);
        System.out.println(search(nums, 3) == -1);
        System.out.println(search(new int[]{1}, 0) == -1);
        System.out.println(search(new int[]{10, 11, 12, 13, 14, 15, 16, 17, 1, 2, 3, 4, 5, 6, 7, 8}, 9) == -1);
        System.out.println(search(new int[]{10, 11, 12, 13, 14, 15, 16, 17, 1, 2, 3, 4, 5, 6, 7, 8}, 10) == 0);
        System.out.println(search(new int[]{10, 11, 12, 13, 14, 15, 16, 17, 1, 2, 3, 4, 5, 6, 7, 8}, 1) == 8);

//        nums = new int[]{1};
//        System.out.println(binarySearch1(nums, 0, nums.length, 0) == -1);
//        System.out.println(binarySearch1(nums, 0, nums.length, 1) == 0);
//        System.out.println(binarySearch1(nums, 0, nums.length, 2) == -1);
//
//
//        nums = new int[]{1, 2};
//        System.out.println(binarySearch1(nums, 0, nums.length, 0) == -1);
//        System.out.println(binarySearch1(nums, 0, nums.length, 1) == 0);
//        System.out.println(binarySearch1(nums, 0, nums.length, 2) == 1);
//        System.out.println(binarySearch1(nums, 0, nums.length, 3) == -1);
//
//        nums = new int[]{1, 2, 3};
//        System.out.println(binarySearch1(nums, 0, nums.length, 0) == -1);
//        System.out.println(binarySearch1(nums, 0, nums.length, 1) == 0);
//        System.out.println(binarySearch1(nums, 0, nums.length, 2) == 1);
//        System.out.println(binarySearch1(nums, 0, nums.length, 3) == 2);
//        System.out.println(binarySearch1(nums, 0, nums.length, 4) == -1);

    }
}
