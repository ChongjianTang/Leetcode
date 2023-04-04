package leetcode.p0.p14;

public class LongestCommonPrefix {
    public static String longestCommonPrefix1(String[] strs) {
        String commonPrefix = "";
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (String str : strs) {
                if (i >= str.length() || c != str.charAt(i)) {
                    return commonPrefix;
                }
            }
            commonPrefix += c;
        }
        return commonPrefix;
    }

    public static String longestCommonPrefix(String[] strs) {
        String s = "";
        if (strs.length == 1) {
            return strs[0];
        }
        for (int i = 0; i < strs.length - 1; i++) {
            if (i == 0) {
                s = commonPrefix(strs[0], strs[1]);
            } else {
                s = commonPrefix(s, strs[i + 1]);
            }
        }
        return s;
    }

    private static String commonPrefix(String s1, String s2) {
        String prefix = "";
        for (int i = 0; i < Math.min(s1.length(), s2.length()); i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                prefix += s1.charAt(i);
            } else {
                return prefix;
            }
        }
        return prefix;
    }


    public static void main(String[] args) {
        String[] strs = new String[]{"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs));
    }
}
