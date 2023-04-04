package leetcode.p2.p209;

public class MinSubArrayLen {
    /**
     *
     */
    public static int minSubArrayLen(int target, int[] nums) {
        int min = 0;
        int sum = nums[0];
        int i = 0, j = 0;
        while (sum >= target || i != nums.length - 1) {
            if (sum >= target) {
                if (min == 0) {
                    min = i - j + 1;
                } else {
                    min = Math.min(min, i - j + 1);
                }
                sum -= nums[j];
                j++;
            } else {
                i++;
                sum += nums[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] nums;

        nums = new int[]{2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen(7, nums) == 2);
    }
}
