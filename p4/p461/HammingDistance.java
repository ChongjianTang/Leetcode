package leetcode.p4.p461;

public class HammingDistance {
    /**
     * 09/04/2022 19:29
     * Brian Kernighan's Algorithm
     * Time complexity: O(1)
     * Space complexity: O(1)
     */
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int count = 0;
        while (xor != 0) {
            xor = xor & xor - 1;
            count++;
        }
        return count;
    }
}
