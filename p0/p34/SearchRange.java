package leetcode.p0.p34;

import java.util.Arrays;

public class SearchRange {
    /**
     * 12/17/2021 18:24
     * My approach
     */
    public static int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        return helper1(nums, 0, nums.length, target);
    }

    public static int[] helper1(int[] nums, int start, int end, int target) {
        boolean flag = false;
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        if (end - start <= 3) {
            for (int i = start; i < end; i++) {
                if (nums[i] == target) {
                    if (flag) {
                        result[1] = i;
                    } else {
                        result[0] = i;
                        result[1] = i;
                        flag = true;
                    }
                } else if (nums[i] > target) {
                    return result;
                }
            }
            return result;
        }
        int index = (end + start) / 2;
        if (nums[index] > target) {
            return helper1(nums, start, index, target);
        } else if (nums[index] < target) {
            return helper1(nums, index + 1, end, target);
        } else {
            if (nums[index + 1] != target) {
                result[1] = index;
            } else {
                result[1] = findRightEnd1(nums, index + 1, end, target);
            }
            if (nums[index - 1] != target) {
                result[0] = index;
            } else {
                result[0] = findLeftEnd1(nums, start, index, target);
            }
        }
        return result;
    }

    public static int findRightEnd1(int[] nums, int start, int end, int target) {
        if (start - end <= 4) {
            for (int i = start + 1; i < end; i++) {
                if (nums[i] != target) {
                    return i - 1;
                }
            }
            return end - 1;
        }
        int index = (end + start) / 2;
        if (nums[index] != target) {
            if (nums[index - 1] == target) {
                return index - 1;
            } else {
                return findRightEnd1(nums, start, index - 1, target);
            }
        } else {
            if (nums[index + 1] != target) {
                return index;
            } else {
                return findRightEnd1(nums, index + 1, end, target);
            }
        }
    }

    public static int findLeftEnd1(int[] nums, int start, int end, int target) {
        if (start - end <= 4) {
            for (int i = end - 2; i >= start; i--) {
                if (nums[i] != target) {
                    return i + 1;
                }
            }
            return start;
        }
        int index = (end + start) / 2;
        if (nums[index] != target) {
            if (nums[index + 1] == target) {
                return index + 1;
            } else {
                return findLeftEnd1(nums, index + 2, end, target);
            }
        } else {
            if (nums[index - 1] != target) {
                return index;
            } else {
                return findLeftEnd1(nums, start, index, target);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.equals(searchRange(new int[]{1}, 1), new int[]{0, 0}));
        System.out.println(Arrays.equals(searchRange(new int[]{1, 2, 3, 8, 8, 8, 8, 8, 8, 8, 8, 8, 9, 10, 11, 12, 13, 15}, 8), new int[]{3, 11}));
        System.out.println(Arrays.equals(searchRange(new int[]{8, 8, 8, 8, 8, 8}, 8), new int[]{0, 5}));
        System.out.println(Arrays.equals(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8), new int[]{3, 4}));
        System.out.println(Arrays.equals(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6), new int[]{-1, -1}));
        System.out.println(Arrays.equals(searchRange(new int[]{}, 0), new int[]{-1, -1}));
    }
}
