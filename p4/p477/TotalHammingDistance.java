package leetcode.p4.p477;

public class TotalHammingDistance {
    /**
     * 08/31/2022 18:46
     */
    public static int totalHammingDistance(int[] nums) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int ones = 0;
            int zeros = 0;
            for (int j = 0; j < nums.length; j++) {
                if ((nums[j] & 1) == 1) {
                    ones++;
                } else {
                    zeros++;
                }
                nums[j] = nums[j] >> 1;
            }
            result += ones * zeros;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(totalHammingDistance(new int[]{4, 14, 2}));
    }
}
