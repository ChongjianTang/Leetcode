package leetcode.p35;

public class SearchInsert {
    public static int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        return helper(nums, 0, nums.length, target);
    }

    public static int helper(int[] nums, int start, int end, int target) {
        if (end - start <= 3) {
            for (int i = start; i < end; i++) {
                if (nums[i] == target) {
                    return i;
                } else if (nums[i] > target) {
                    return i;
                }
            }
            return end;
        }
        int index = (end + start) / 2;
        if (nums[index] == target) {
            return index;
        } else if (nums[index] > target) {
            return helper(nums, start, index, target);
        } else {
            return helper(nums, index + 1, end, target);
        }
    }

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 10) == 9);
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 5) == 2);
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 2) == 1);
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 7) == 4);

        System.out.println(searchInsert(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 0) == 0);
        System.out.println(searchInsert(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 1) == 0);
    }
}
