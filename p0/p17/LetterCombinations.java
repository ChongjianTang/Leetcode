package leetcode.p0.p17;

import java.util.*;

public class LetterCombinations {
    /**
     * My method
     * Iterative
     * Time complexity: O(n*4^n)
     * T(n) = T(n-1) + 3^2
     * T(n) = T(1) + 3^2+3^3+3^4+...+3^N
     * T(n) = O(4^n) The the maximum value length in the original hashMap
     * String object is immutable, so concatenating Strings result in O(n)
     * So the overall time complexity is O(n*4^n)
     * Space complexity: O(n+n-1) = O(n)
     */
    public static List<String> letterCombinations1(String digits) {
        HashMap<String, List<String>> map = new HashMap<>();
        List<String> temp = new ArrayList<>();
        if (digits.equals("")) {
            return temp;
        }
        temp.add("a");
        temp.add("b");
        temp.add("c");
        map.put("2", temp);
        temp = new ArrayList<>();
        temp.add("d");
        temp.add("e");
        temp.add("f");
        map.put("3", temp);
        temp = new ArrayList<>();
        temp.add("g");
        temp.add("h");
        temp.add("i");
        map.put("4", temp);
        temp = new ArrayList<>();
        temp.add("j");
        temp.add("k");
        temp.add("l");
        map.put("5", temp);
        temp = new ArrayList<>();
        temp.add("m");
        temp.add("n");
        temp.add("o");
        map.put("6", temp);
        temp = new ArrayList<>();
        temp.add("p");
        temp.add("q");
        temp.add("r");
        temp.add("s");
        map.put("7", temp);
        temp = new ArrayList<>();
        temp.add("t");
        temp.add("u");
        temp.add("v");
        map.put("8", temp);
        temp = new ArrayList<>();
        temp.add("w");
        temp.add("x");
        temp.add("y");
        temp.add("z");
        map.put("9", temp);
        Stack<String> stack = new Stack<>();
        for (int i = digits.length() - 1; i >= 0; i--) {
            stack.push(String.valueOf(digits.charAt(i)));
        }
        while (stack.size() > 1) {
            String prev = stack.pop();
            String next = stack.pop();
            temp = combine(map.get(prev), map.get(next));
            prev += next;
            map.put(prev, temp);
            stack.push(prev);
        }
        return map.get(stack.pop());
    }

    public static List<String> combine(List<String> l1, List<String> l2) {
        List<String> result = new ArrayList<>();
        for (String s1 : l1) {
            for (String s2 : l2) {
                result.add(s1 + s2);
            }
        }
        return result;
    }


    /**
     * Recursion
     * Time complexity: O(n*4^n)
     * This a tree whose height is n and max branch number is 4
     * Space complexity: O(n)
     * The extra space we use relative to input size is the space occupied by the recursion call stack.
     * It will only go as deep as the number of digits in the input since whenever we reach that depth, we backtrack.
     */
    public static List<String> letterCombinations(String digits) {
        if (digits.equals("")) {
            return new ArrayList<>();
        }
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        List<String> result = new ArrayList<>();
        backtracking1(digits, map, 0, "", result);
        return result;
    }

    public static void backtracking1(String digits, HashMap<Character, String> map, int start, String answer, List<String> result) {
        if (start == digits.length()) {
            result.add(answer);
        } else {
            String letters = map.get(digits.charAt(start));
            for (int i = 0; i < letters.length(); i++) {
                backtracking1(digits, map, start + 1, answer + letters.charAt(i), result);
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(letterCombinations(""));
    }
}
