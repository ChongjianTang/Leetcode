package leetcode.p4.p493;

public class ReversePairs {
    /**
     * 08/31/2022 01:30
     * Brute force
     * TLE - 32/140
     * Time complexity: O(n^2)
     * Space complexity: O(1)
     */
    public int reversePairs(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                long temp = 2L * nums[j];
                if (nums[i] > temp) {
                    count++;
                }
            }
        }
        return count;
    }
}
