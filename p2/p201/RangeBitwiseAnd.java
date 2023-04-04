package leetcode.p2.p201;

public class RangeBitwiseAnd {
    /**
     * 09/04/2022 18:57
     * My approach
     * TLE - 8260 / 8268
     */
    public static int rangeBitwiseAnd1(int left, int right) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            boolean isOne = true;
            for (int j = left; j <= right; j++) {
                if ((j >> i & 1) == 0) {
                    isOne = false;
                    break;
                }
            }
            if (isOne) {
                result = result | (1 << i);
            }
        }
        return result;
    }

    /**
     * 09/04/2022 19:01
     * Bit Shift
     * Time complexity: O(1)
     * Space complexity: O(1)
     */
    public static int rangeBitwiseAnd2(int left, int right) {
        int count = 0;
        while (left != right) {
            left = left >> 1;
            right = right >> 1;
            count++;
        }

        return left << count;
    }

    /**
     * 09/04/2022 19:11
     * Brian Kernighan's Algorithm
     * remove the rightmost bit of '1' one by one
     * Time complexity: O(1)
     * Space complexity: O(1)
     */
    public static int rangeBitwiseAnd(int left, int right) {
        while (left < right) {
            right = right & (right - 1);
        }
        return left & right;
    }

    public static void main(String[] args) {
        System.out.println(rangeBitwiseAnd(5, 7));
    }
}
