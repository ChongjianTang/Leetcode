package leetcode.p10;

public class IsMatch {
    public static boolean isMatch1(String s, String p) {
        boolean[][] isMatchArray = new boolean[s.length() + 1][p.length() + 1];
        for (int j = 0; j <= p.length(); j++) {
            if (j + 1 <= p.length() && p.charAt(j) == '*') {
                continue;
            }
            for (int i = 0; i <= s.length(); i++) {
                if (j == 0) {
                    isMatchArray[i][j] = i == 0;
                } else if (j == 1) {
                    if (i == 1) {
                        isMatchArray[i][j] = charMatch(s.charAt(0), p.charAt(0));
                    } else {
                        isMatchArray[i][j] = false;
                    }
                } else {
                    if (i == 0) {
                        if (p.charAt(j - 1) == '*') {
                            isMatchArray[i][j] = isMatchArray[i][j - 2];
                        } else {
                            isMatchArray[i][j] = false;
                        }
                    } else if (p.charAt(j - 1) == '*') {
                        if (charMatch(s.charAt(i - 1), p.charAt(j - 2))) {
                            isMatchArray[i][j] = isMatchArray[i][j - 2] || isMatchArray[i - 1][j];
                        } else {
                            isMatchArray[i][j] = isMatchArray[i][j - 2];
                        }
                    } else if (charMatch(s.charAt(i - 1), p.charAt(j - 1))) {
                        isMatchArray[i][j] = isMatchArray[i - 1][j - 1];
                    } else {
                        isMatchArray[i][j] = false;
                    }
                }
            }
        }
        return isMatchArray[s.length()][p.length()];
    }

    public static boolean isMatch(String s, String p) {
        boolean[] isMatchArray = new boolean[p.length() + 1];
        boolean prev, temp;
        for (int i = 0; i < p.length() + 1; i++) {
            if (i == 0) {
                isMatchArray[i] = true;
            } else if (i == 1) {
                isMatchArray[i] = false;
            } else {
                if (p.charAt(i - 1) == '*') {
                    isMatchArray[i] = isMatchArray[i - 2];
                } else {
                    isMatchArray[i] = false;
                }
            }
        }

        for (int i = 1; i < s.length() + 1; i++) {
            prev = isMatchArray[1];
            for (int j = 0; j < p.length() + 1; j++) {
                temp = isMatchArray[j];
                if (j == 0) {
                    isMatchArray[j] = false;
                } else if (j == 1) {
                    if (i == 1) {
                        isMatchArray[j] = charMatch(s.charAt(0), p.charAt(0));
                    } else {
                        isMatchArray[j] = false;
                    }
                } else {
                    if (p.charAt(j - 1) == '*') {
                        if (charMatch(s.charAt(i - 1), p.charAt(j - 2))) {
                            isMatchArray[j] = isMatchArray[j - 2] || isMatchArray[j];
                        } else {
                            isMatchArray[j] = isMatchArray[j - 2];
                        }
                    } else if (charMatch(s.charAt(i - 1), p.charAt(j - 1))) {
                        isMatchArray[j] = prev;
                    } else {
                        isMatchArray[j] = false;
                    }
                }
                prev = temp;
            }
        }
        return isMatchArray[p.length()];
    }

    public static boolean charMatch(char s, char p) {
        return s == p || p == '.';
    }

    public static void main(String[] args) {
        System.out.println(isMatch1("aba", "c*.*"));
    }
}
