package leetcode.p3.p342;

public class IsPowerOfFour {
    /**
     * 08/31/2022 19:27
     */
    public static boolean isPowerOfFour(int n) {
        int count = 0;
        int zeros = 0;
        for (int i = 0; i < 31; i += 2) {
            count += n & 1;
            zeros += n & 2;
            n = n >> 2;
        }
        return count == 1 && zeros == 0 && (n & 1) != 1;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(-2147483647));
        System.out.println(isPowerOfFour(3));
    }
}
