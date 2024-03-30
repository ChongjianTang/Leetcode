package leetcode.p28.p2864;

public class MaximumOddBinaryNumber {
    /**
     * Feb 29, 2024 22:07
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public String maximumOddBinaryNumber(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
            }
        }
        return "1".repeat(count - 1) + "0".repeat(s.length() - count) + "1";
    }
}
