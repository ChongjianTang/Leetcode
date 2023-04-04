package leetcode.p1.p131;

import java.util.ArrayList;
import java.util.List;

public class Partition {
    /**
     * Backtracking
     * Time complexity: O(n*2^n)
     * it takes O(n) time to generate substring and determine if it is a palindrome or not.
     * Space complexity: O(n)
     */
    public List<List<String>> partition1(String s) {
        List<List<String>> result = new ArrayList<>();
        backtracking1(s, 0, new ArrayList<>(), result);
        return result;
    }

    public void backtracking1(String s, int index, List<String> answer, List<List<String>> result) {
        if (index == 0) {
            answer.add(String.valueOf(s.charAt(index)));
            backtracking1(s, 1, answer, result);
        } else if (index == s.length()) {
            if (isPalindrome1(answer.get(answer.size() - 1))) {
                result.add(new ArrayList<>(answer));
            }
        } else {
            String temp = answer.get(answer.size() - 1);
            answer.set(answer.size() - 1, temp + s.charAt(index));
            backtracking1(s, index + 1, answer, result);
            answer.set(answer.size() - 1, temp);
            if (isPalindrome1(temp)) {
                answer.add(String.valueOf(s.charAt(index)));
                backtracking1(s, index + 1, answer, result);
                answer.remove(answer.size() - 1);
            }
        }
    }

    public boolean isPalindrome1(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Another way of recursion
     * See p78
     */
    public List<List<String>> partition2(String s) {
        List<List<String>> result = new ArrayList<>();
        backtracking2(s, 0, new ArrayList<>(), result);
        return result;
    }

    public void backtracking2(String s, int index, List<String> answer, List<List<String>> result) {
        if (index == s.length()) {
            result.add(new ArrayList<>(answer));
        } else {
            for (int i = index + 1; i <= s.length(); i++) {
                String temp = s.substring(index, i);
                if (isPalindrome2(temp)) {
                    answer.add(temp);
                    backtracking2(s, i, answer, result);
                    answer.remove(answer.size() - 1);
                }
            }
        }
    }

    public boolean isPalindrome2(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * DP
     * Time complexity: O(n*2^n)
     * Space complexity: O(n^2)
     */
    public List<List<String>> partition(String s) {
        boolean[][] OPT = new boolean[s.length()][s.length()];
        OPT[0][0] = true;
        for (int i = 1; i < OPT.length; i++) {
            OPT[i][i] = true;
            OPT[i - 1][i] = s.charAt(i - 1) == s.charAt(i);
        }
        for (int i = s.length() - 3; i >= 0; i--) {
            for (int j = s.length() - 1; j > i + 1; j--) {
                if (s.charAt(i) == s.charAt(j)) {
                    OPT[i][j] = OPT[i + 1][j - 1];
                } else {
                    OPT[i][j] = false;
                }
            }
        }

        List<List<String>> result = new ArrayList<>();
        backtracking3(s, 0, OPT, new ArrayList<>(), result);
        return result;
    }

    public void backtracking3(String s, int index, boolean[][] isPalindrome, List<String> answer, List<List<String>> result) {
        if (index == s.length()) {
            result.add(new ArrayList<>(answer));
        } else {
            for (int i = index; i < s.length(); i++) {
                if (isPalindrome[index][i]) {
                    answer.add(s.substring(index, i + 1));
                    backtracking3(s, i + 1, isPalindrome, answer, result);
                    answer.remove(answer.size() - 1);
                }
            }
        }
    }
}
