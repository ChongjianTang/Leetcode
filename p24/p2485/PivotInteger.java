package leetcode.p24.p2485;

public class PivotInteger {
    /**
     * Mar 12, 2024 18:26
     * Math
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     */
    public int pivotInteger(int n) {
        double result = Math.sqrt((n * (n + 1)) / 2.0);
        if (result - (int) result == 0) {
            return (int) result;
        } else {
            return -1;
        }
    }
}
