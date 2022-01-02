package leetcode.p6;

public class Convert {
    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int length = s.length() / (numRows - 1) + 1;
        char[][] chars = new char[numRows][length];
        int index = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < numRows; j++) {
                if (i % 2 == 0) {
                    chars[j][i] = s.charAt(index);
                    index++;
                } else {
                    if (j != 0 && j != numRows - 1) {
                        chars[numRows - 1 - j][i] = s.charAt(index);
                        index++;
                    }
                }
                if (index >= s.length()) {
                    break;
                }
            }
            if (index >= s.length()) {
                break;
            }
        }
        String result = "";
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < length; j++) {
                if (chars[i][j] != Character.MIN_VALUE) {
                    result += chars[i][j];
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
        System.out.println(convert("PAYPALISHIRING", 4));
    }
}
