package leetcode.p0.p29;

public class Divide {
    /**
     * Brute force
     */
    public static int divide1(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean sign;
        sign = (dividend < 0 && divisor < 0) || (dividend > 0 && divisor > 0);
        int quotient = 0;
        if (dividend > 0) {
            dividend = -dividend;
        }
        if (divisor > 0) {
            divisor = -divisor;
        }
        while (dividend < 0) {
            dividend -= divisor;
            quotient++;
        }
        if (dividend != 0) {
            quotient -= 1;
        }
        if (!sign) {
            quotient = -quotient;
        }
        return quotient;
    }

    /**
     * Bit manipulation.
     */
    public static int divide(int dividend, int divisor) {
        long temp1 = dividend, temp2 = divisor;
        boolean sign;
        sign = (dividend ^ divisor) < 0;
        long quotient = 0;
        if (temp1 < 0) {
            temp1 = ~temp1 + 1;
        }
        if (temp2 < 0) {
            temp2 = ~temp2 + 1;
        }
        int bitLengthOfDividend = bitLength(temp1);
        int bitLengthOfDivisor = bitLength(temp2);
        int diff = bitLengthOfDividend - bitLengthOfDivisor;
        for (int i = diff; i >= 0; i--) {
            long temp = temp2 << i;
            if (temp <= temp1) {
                quotient |= (1L << i);
                temp1 -= temp;
            }
        }
        if (sign) {
            quotient = ~quotient + 1;
        }
        if (quotient > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int) quotient;
    }

    static int bitLength(long num) {
        int length = 0;
        while (num > 0) {
            length += 1;
            num = num >> 1;
        }
        return length;
    }

    public static void main(String[] args) {
        System.out.println(divide(Integer.MIN_VALUE, -1));
        System.out.println(divide(Integer.MIN_VALUE + 1, -1));
        System.out.println(divide(10, 3));
        System.out.println(divide(7, -3));
        System.out.println(divide(0, 1));
        System.out.println(divide(1, 1));
        System.out.println(divide(-1, -1));
    }
}
