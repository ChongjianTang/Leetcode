package leetcode.p33;

public class Search {

    /**
     * An updated binary search.
     */
    public static int search(int[] nums, int target) {
        return helper(nums, 0, nums.length, target);
    }

    public static int helper(int[] nums, int start, int end, int target) {
        if (end - start <= 3) {
            for (int i = start; i < end; i++) {
                if (nums[i] == target) {
                    return i;
                }
            }
            return -1;
        }
        int index = (end + start) / 2;
        if (target == nums[index]) {
            return index;
        }
        boolean greater = target > nums[index];
        if (nums[index] < nums[end - 1]) {
            if (greater && target <= nums[end - 1]) {
                return helper(nums, index + 1, end, target);
            } else {
                return helper(nums, start, index, target);
            }
        } else {
            if (!greater && target >= nums[start]) {
                return helper(nums, start, index, target);
            } else {
                return helper(nums, index + 1, end, target);
            }
        }
    }

    /**
     * Actually we don't need a special function to deal with the special condition.
     */
    public static int binarySearch(int[] nums, int start, int end, int target) {
        if (end - start <= 3) {
            for (int i = start; i < end; i++) {
                if (nums[i] == target) {
                    return i;
                }
            }
            return -1;
        }
        int index = (end + start) / 2;
        if (nums[index] == target) {
            return index;
        } else if (nums[index] < target) {
            return binarySearch(nums, index + 1, end, target);
        } else {
            return binarySearch(nums, start, index, target);
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
    }
}
