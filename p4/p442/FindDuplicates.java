package leetcode.p4.p442;

import java.util.ArrayList;
import java.util.List;

public class FindDuplicates {
    /**
     * Mar 25, 2024 21:26
     * Index as hash key
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[Math.abs(nums[i]) - 1] > 0) {
                nums[Math.abs(nums[i]) - 1] *= -1;
            } else {
                result.add(Math.abs(nums[i]));
            }
        }
        return result;
    }
}
