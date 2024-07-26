package leetcode.p16.p1614;

public class MaxDepth {
    /**
     * Apr 03, 2024 18:44
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public int maxDepth(String s) {
        int count = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
                max = Math.max(count, max);
            } else if (s.charAt(i) == ')') {
                count--;
            }
        }
        return max;
    }
}
