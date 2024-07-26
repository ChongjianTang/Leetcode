package leetcode.p1.p136;

public class SingleNumber {
    /**
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result = result ^ num;
        }
        return result;
    }
}
