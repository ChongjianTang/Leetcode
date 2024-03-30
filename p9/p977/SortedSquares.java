package leetcode.p9.p977;

public class SortedSquares {
    /**
     * Mar 02, 2024 00:20
     * Two Pointer, too many traversal, not good enough. Because I choose to start with the smallest one.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int[] sortedSquares1(int[] nums) {
        if (nums.length == 1) {
            nums[0] *= nums[0];
            return nums;
        }
        int[] result = new int[nums.length];
        int left = 0, right = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < 0 && nums[i] >= 0) {
                left = i - 1;
                right = i;
                int index = 0;
                if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                    result[index] = nums[right] * nums[right];
                    right++;
                    index++;
                } else if (Math.abs(nums[right]) > Math.abs(nums[left])) {
                    result[index] = nums[left] * nums[left];
                    left--;
                    index++;
                }
                while (left >= 0 || right < nums.length) {
                    if (right >= nums.length) {
                        result[index] = nums[left] * nums[left];
                        left--;
                    } else if (left < 0) {
                        result[index] = nums[right] * nums[right];
                        right++;
                    } else if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                        result[index] = nums[right] * nums[right];
                        right++;
                    } else {
                        result[index] = nums[left] * nums[left];
                        left--;
                    }
                    index++;
                }
                return result;
            }
        }
        int index = 0;
        if (nums[0] < 0) {
            for (int i = nums.length - 1; i >= 0; i--) {
                result[index] = nums[i] * nums[i];
                index++;
            }
        } else {
            for (int i = 0; i < nums.length; i++) {
                result[index] = nums[i] * nums[i];
                index++;
            }
        }
        return result;
    }

    /**
     * Mar 02, 2024 00:40
     * Only one pass
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        int index = nums.length - 1;
        while (left < right) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                result[index] = nums[left] * nums[left];
                left++;
            } else {
                result[index] = nums[right] * nums[right];
                right--;
            }
            index--;
        }
        result[index] = nums[left] * nums[left];
        return result;
    }
}
