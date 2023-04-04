package leetcode.p2.p231;

public class IsPowerOfTwo {
    /**
     * 08/31/2022 18:53
     */
    public static boolean isPowerOfTwo1(int n) {
        int count = 0;
        for (int i = 0; i < 31; i++) {
            count += n & 1;
            n = n >> 1;
        }
        return count == 1 && (n & 1) != 1;
    }

    /**
     * 08/31/2022 19:02
     */
    public static boolean isPowerOfTwo(int n) {
        if (n == 0) return false;
        long x = (long) n;
        return (x & (-x)) == x;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(-2147483646));
        System.out.println(Integer.toBinaryString(-2147483646));
    }
}
