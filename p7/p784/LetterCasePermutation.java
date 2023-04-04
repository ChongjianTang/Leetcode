package leetcode.p7.p784;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        backtracking1(s, 0, "", result);
        return result;
    }

    public void backtracking1(String s, int index, String answer, List<String> result) {
        if (index == s.length()) {
            result.add(answer);
        } else {
            if (Character.isDigit(s.charAt(index))) {
                backtracking1(s, index + 1, answer + s.charAt(index), result);
            } else {
                backtracking1(s, index + 1, answer + Character.toLowerCase(s.charAt(index)), result);
                backtracking1(s, index + 1, answer + Character.toUpperCase(s.charAt(index)), result);
            }
        }
    }
}
