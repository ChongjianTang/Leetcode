package leetcode.p1.p166;

import java.util.HashSet;

public class FractionToDecimal {
    /**
     * 09/05/2022 21:10
     * My approach
     * TODO Need to be improved about the repeating part
     */
    public static String fractionToDecimal(int numerator, int denominator) {
        boolean isNegative = (numerator > 0 && denominator < 0) || (numerator < 0 && denominator > 0);
        long numeratorLong = numerator;
        numeratorLong = Math.abs(numeratorLong);
        long denominatorLong = denominator;
        denominatorLong = Math.abs(denominatorLong);
        long resultInt = numeratorLong / denominatorLong;
        numeratorLong = numeratorLong % denominatorLong;
        StringBuilder digits = new StringBuilder();
        if (isNegative) {
            digits.append("-");
        }
        digits.append(resultInt);
        if (numeratorLong == 0) {
            return digits.toString();
        }
        digits.append(".");
        HashSet<Long> visited = new HashSet<>();
        long val = numeratorLong * 10L;
        while (val < denominatorLong) {
            visited.add(val);
            val *= 10;
            digits.append(0);
        }

        long quotient, remainder;
        while (!visited.contains(val)) {
            visited.add(val);
            remainder = val % denominatorLong;
            quotient = val / denominatorLong;
            digits.append(quotient);
            val = remainder * 10;
        }

        StringBuilder repeat = new StringBuilder();
        while (visited.contains(val)) {
            visited.remove(val);
            remainder = val % denominatorLong;
            quotient = val / denominatorLong;
            val = remainder * 10;
            repeat.append(quotient);
        }


        if (!repeat.toString().equals("0")) {
            digits.append(')');
            digits.insert(digits.length() - repeat.length() - 1, '(');
        } else {
            digits.deleteCharAt(digits.length() - 1);
        }
        return digits.toString();
    }

    public static void main(String[] args) {
        System.out.println(fractionToDecimal(1, 2));
        System.out.println(fractionToDecimal(1, 3));
        System.out.println(fractionToDecimal(4, 333));
        System.out.println(fractionToDecimal(-50, 8));
        System.out.println(fractionToDecimal(-1, -2147483648));
        System.out.println(fractionToDecimal(-2147483648, 1));
    }
}
