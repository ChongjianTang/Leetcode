package leetcode.p2.p287;

public class FindDuplicate {
    /**
     * Feb 20, 2024 01:09
     * Cycle detection. A genius approach!
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int findDuplicate(int[] nums) {
        int fast = 0;
        int slow = 0;
        fast = nums[nums[fast]];
        slow = nums[slow];
        while (fast != slow) {
            fast = nums[nums[fast]];
            slow = nums[slow];
        }

        fast = 0;
        while (fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }
        return fast;
    }
}