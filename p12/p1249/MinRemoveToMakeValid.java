package leetcode.p12.p1249;

import java.util.Arrays;

public class MinRemoveToMakeValid {
    /**
     * Two pass
     * The idea is from the hint
     * 01/13/2022
     */
    public static String minRemoveToMakeValid(String s) {
        boolean[] remove = new boolean[s.length()];
        Arrays.fill(remove, false);
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else if (s.charAt(i) == ')') {
                if (left > right) {
                    right++;
                } else {
                    remove[i] = true;
                }
            }
        }
        left = 0;
        right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ')') {
                right++;
            } else if (s.charAt(i) == '(') {
                if (right > left) {
                    left++;
                } else {
                    remove[i] = true;
                }
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < remove.length; i++) {
            if (!remove[i]) {
                result.append(s.charAt(i));
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s;
        String result;
        s= "lee(t(c)o)de)";
        result = minRemoveToMakeValid(s);
        System.out.println(result.equals("lee(t(c)o)de") || result.equals("lee(t(co)de)")|| result.equals("lee(t(c)ode)"));
    }
}
