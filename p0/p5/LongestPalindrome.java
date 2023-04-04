package leetcode.p0.p5;

public class LongestPalindrome {
    public static String longestPalindrome1(String s) {
        int[] length = new int[2 * s.length() - 1];
        int maxLength = 1;
        int maxLengthIndex = 0;
        for (int i = 0; i <= 2 * s.length() - 2; i++) {
            if (i % 2 == 0) {
                int index = i / 2;
                length[i] = 1;
                for (int j = 1; index + j < s.length() && index - j >= 0; j++) {
                    if (s.charAt(index - j) == s.charAt(index + j)) {
                        length[i] += 2;
                    } else {
                        break;
                    }
                }
            } else {
                length[i] = 0;
                for (int j = 1; (i - 1) / 2 + j < s.length() && (i + 1) / 2 - j >= 0; j++) {
                    if (s.charAt((i - 1) / 2 + j) == s.charAt((i + 1) / 2 - j)) {
                        length[i] += 2;
                    } else {
                        break;
                    }
                }
            }
            if (length[i] > maxLength) {
                maxLength = length[i];
                maxLengthIndex = i;
            }
        }
        String result = "";
        if (maxLengthIndex % 2 == 0) {
            for (int i = maxLengthIndex / 2 - maxLength / 2; i <= maxLengthIndex / 2 + maxLength / 2; i++) {
                result += s.charAt(i);
            }
        } else {
            for (int i = (maxLengthIndex + 1) / 2 - maxLength / 2; i <= (maxLengthIndex - 1) / 2 + maxLength / 2; i++) {
                result += s.charAt(i);
            }
        }
        return result;
    }

    public static String longestPalindrome(String s) {
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        int start = 0, end = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            isPalindrome[i][i] = true;
            if (s.charAt(i) == s.charAt(i + 1)) {
                isPalindrome[i][i + 1] = true;
                start = i;
                end = i + 1;
            } else {
                isPalindrome[i][i + 1] = false;
            }
        }
        isPalindrome[s.length() - 1][s.length() - 1] = true;
        for (int i = 0; i < s.length() - 2; i++) {
            for (int j = 0; j < s.length() - 2 - i; j++) {
                isPalindrome[j][i + j + 2] = isPalindrome[j + 1][i + j + 1] && s.charAt(j) == s.charAt(i + j + 2);
                if (isPalindrome[j][i + j + 2]) {
                    start = j;
                    end = i + j + 2;
                }
            }
        }
        return s.substring(start, end + 1);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("ababd"));
    }
}
