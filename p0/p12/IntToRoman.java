package leetcode.p0.p12;

public class IntToRoman {
    public static String intToRoman(int num) {
        int[] alphabet = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String s = "";
        for (int j : alphabet) {
            while (num >= j) {
                num -= j;
                s += parse(j);
            }
        }
        return s;
    }

    private static String parse(int i) {
        switch (i) {
            case 1000:
                return "M";
            case 900:
                return "CM";
            case 500:
                return "D";
            case 400:
                return "CD";
            case 100:
                return "C";
            case 90:
                return "XC";
            case 50:
                return "L";
            case 40:
                return "XL";
            case 10:
                return "X";
            case 9:
                return "IX";
            case 5:
                return "V";
            case 4:
                return "IV";
            case 1:
                return "I";
            default:
                return "";
        }
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(58));
    }
}
