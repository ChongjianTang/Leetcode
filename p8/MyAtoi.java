package leetcode.p8;

public class MyAtoi {
    public static int myAtoi(String s) {
        s = s.trim();
        if (s.length() == 0) {
            return 0;
        }
        int index = 0;
        int signal = 1;
        if (s.charAt(0) == '-') {
            index += 1;
            signal = -1;
        } else if (s.charAt(0) == '+') {
            index += 1;
        }
        long result = 0;
        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            result = result * 10 + Integer.parseInt(String.valueOf(s.charAt(index)));
            index++;
            if (result * signal < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            } else if (result * signal > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
        }
        return (int) result * signal;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("9223372036854775808"));
    }
}
