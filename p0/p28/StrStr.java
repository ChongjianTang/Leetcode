package leetcode.p0.p28;


import java.util.ArrayList;

/**
 * String Matching Problem.
 * There are some useful information in Chapter 32, Introduction to Algorithm, 3rd.
 */
public class StrStr {
    /**
     * Brute force
     */
    public static int strStr1(String haystack, String needle) {
        if (needle.equals("")) {
            return 0;
        }
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                boolean flag = true;
                for (int j = 1; j < needle.length(); j++) {
                    if (needle.charAt(j) != haystack.charAt(i + j)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * Finite automata
     * Can't pass the AG because of time complexity in worse cases.
     */
    public static int strStr2(String haystack, String needle) {
        if (needle.equals("")) {
            return 0;
        }

        ArrayList<Character> alphabet = new ArrayList<>();
        for (int i = 0; i < needle.length(); i++) {
            if (!alphabet.contains(needle.charAt(i))) {
                alphabet.add(needle.charAt(i));
            }
        }

        int[][] delta = new int[needle.length() + 1][alphabet.size()];
        for (int i = 0; i < needle.length() + 1; i++) {
            for (int j = 0; j < alphabet.size(); j++) {
                int k = Math.min(needle.length(), i + 1);
                char a = alphabet.get(j);
                String temp = needle.substring(0, i) + a;
                while (!needle.substring(0, k).equals(temp.substring(temp.length() - k))) {
                    k--;
                }
                delta[i][j] = k;
            }
        }

        int state = 0;
        for (int i = 0; i < haystack.length(); i++) {
            if (alphabet.contains(haystack.charAt(i))) {
                state = delta[state][alphabet.indexOf(haystack.charAt(i))];
            } else {
                state = 0;
            }
            if (state == needle.length()) {
                return i - needle.length() + 1;
            }
        }
        return -1;
    }

    /**
     * KMP
     */
    public static int strStr(String haystack, String needle) {
        if (needle.equals("")) {
            return 0;
        }
        int[] pi = new int[needle.length()];
        pi[0] = 0;
        int k = 0;
        for (int q = 1; q < needle.length(); q++) {
            while (k > 0 && needle.charAt(k) != needle.charAt(q)) {
                k = pi[k - 1];
            }
            if (needle.charAt(k) == needle.charAt(q)) {
                k++;
            }
            pi[q] = k;
        }
        int q = 0;
        for (int i = 0; i < haystack.length(); i++) {
            while (q > 0 && needle.charAt(q) != haystack.charAt(i)) {
                q = pi[q - 1];
            }
            if (needle.charAt(q) == haystack.charAt(i)) {
                q++;
            }
            if (q == needle.length()) {
                return i - needle.length() + 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
//        System.out.println(strStr("abc","abaabcac"));
        System.out.println(strStr("abababacaba", "ababaca"));
        System.out.println(strStr("hello", "ll"));
        System.out.println(strStr("aaaaa", "bba"));
        System.out.println(strStr("aaaa", "aaaa"));
    }
}
