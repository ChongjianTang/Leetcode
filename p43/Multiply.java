package leetcode.p43;

/**
 * 1 <= num1.length, num2.length <= 200
 * num1 and num2 consist of digits only.
 * Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 */
public class Multiply {
    /**
     * Brute Force
     * Super slow -- 798 ms and 179.1 MB
     */
    public static String multiply(String num1, String num2) {
        if (num1.equals("0")) {
            return "0";
        }
        if (num2.equals("0")) {
            return "0";
        }
        String result = "0";
        for (int i = 0; i < num1.length(); i++) {
            for (int j = 0; j < num2.length(); j++) {
                int value = Integer.parseInt(String.valueOf(num1.charAt(i))) *
                        Integer.parseInt(String.valueOf(num2.charAt(j)));
                result = add(result, value + "0".repeat(num1.length() + num2.length() - 2 - i - j), 0);
            }
        }
        for (int i = 0; i < result.length(); i++) {
            if (result.charAt(i) != '0') {
                result = result.substring(i);
                break;
            }
        }
        return result;
    }

    /**
     * This add method is too slow
     */
    public static String add1(String num1, String num2, int carry) {
        if (num1.equals("") && num2.equals("")) {
            if (carry == 1) {
                return "1";
            } else {
                return "";
            }
        }
        if (num1.equals("")) {
            if (carry == 0) {
                return num2;
            }
            int value = Integer.parseInt(String.valueOf(num2.charAt(num2.length() - 1))) + carry;
            carry = value / 10;
            value = value % 10;
            return add1("", num2.substring(0, num2.length() - 1), carry) + value;
        } else if (num2.equals("")) {
            return add1("", num1, carry);
        } else {
            int value = Integer.parseInt(String.valueOf(num1.charAt(num1.length() - 1))) +
                    Integer.parseInt(String.valueOf(num2.charAt(num2.length() - 1))) + carry;
            carry = value / 10;
            value = value % 10;
            return add1(num1.substring(0, num1.length() - 1), num2.substring(0, num2.length() - 1), carry) + value;
        }
    }

    public static String add(String num1, String num2, int carry) {
        if (num1.length() < 9) {
            num1 = "0".repeat(9 - num1.length()) + num1;
        }
        if (num2.length() < 9) {
            num2 = "0".repeat(9 - num2.length()) + num2;
        }
        if (num1.equals("000000000")) {
            return num2;
        }
        if (num2.equals("000000000")) {
            return num1;
        }
        if (num1.length() > 9 && num2.length() <= 9) {
            String result = "";
            String valueString = add(num1.substring(num1.length() - 9), num2, carry);
            result = result + valueString;
            int i = 1;
            while (valueString.length() >= 10) {
                valueString = add(num1.substring(Math.max(num1.length() - 9 * (i + 1), 0), num1.length() - 9 * i), "1", 0);
                i++;
                result = valueString + result.substring(1);
            }
            return num1.substring(0, Math.max(num1.length() - 9 * (i), 0)) + result;
        } else if (num1.length() <= 9 && num2.length() > 9) {
            return add(num2, num1, carry);
        } else if (num1.length() <= 9) {
            int value = Integer.parseInt(num1) + Integer.parseInt(num2) + carry;
            String temp = String.valueOf(value);
            if (temp.length() < 9) {
                temp = "0".repeat(9 - temp.length()) + temp;
            }
            return temp;
        } else {
            String lastNum1 = num1.substring(num1.length() - 9);
            String firstNum1 = num1.substring(0, num1.length() - 9);
            String lastNum2 = num2.substring(num2.length() - 9);
            String firstNum2 = num2.substring(0, num2.length() - 9);
            String temp = add(lastNum1, lastNum2, carry);
            if (temp.length() == 10) {
                carry = 1;
                temp = temp.substring(1);
            } else {
                carry = 0;
            }
            return add(firstNum1, firstNum2, carry) + temp;
        }
    }

    public static void main(String[] args) {
        System.out.println(multiply("498828660196", "840477629533").equals("419254329864656431168468"));

        System.out.println(multiply("123456789", "987654321").equals("121932631112635269"));

        System.out.println(add("19999999999", "1", 0).equals("000000020000000000"));

        System.out.println(multiply("123", "456").equals("56088"));

        System.out.println(add("1230000000", "4560000000", 0).equals("000000005790000000"));
        System.out.println(add("1990000000", "10000000", 1).equals("000000002000000001"));

        System.out.println(add1("123", "123", 0).equals("246"));
        System.out.println(add1("123", "456", 1).equals("580"));
        System.out.println(add1("199", "1", 1).equals("201"));
    }
}
