package leetcode.p17.p1750;

public class MinimumLength {
    /**
     * Mar 05, 2024 08:52
     * Two Pointer
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int minimumLength(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right && s.charAt(left) == s.charAt(right)) {
            while (left + 1 < right && s.charAt(left + 1) == s.charAt(left)) {
                left++;
            }
            while (right - 1 > left && s.charAt(right - 1) == s.charAt(right)) {
                right--;
            }
            left++;
            right--;
        }
        if (left > right) {
            return 0;
        } else {
            return right -left +1;
        }
    }
}
