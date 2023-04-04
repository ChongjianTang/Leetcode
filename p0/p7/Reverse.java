package leetcode.p0.p7;

public class Reverse {
    public static int reverse(int x) {
        String s = String.valueOf(x);
        if (x < 0) {
            s = s.substring(1);
        }
        s = new StringBuilder(s).reverse().toString();
        long result = 0;
        int temp = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            result += (long) Integer.parseInt(String.valueOf(s.charAt(i))) * temp;
            temp *= 10;
        }
        if (x < 0) {
            result = -1 * result;
        }
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) result;
    }

    public static void main(String[] args) {
        System.out.println(reverse(
                -2147483648));

    }
}
