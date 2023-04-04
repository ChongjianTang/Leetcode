package leetcode.p3.p316;

import java.util.*;

/**
 * This problem is pretty classic.
 * It needs to be reviewed!
 */
public class RemoveDuplicateLetters {
    /**
     * Recursion
     */
    public static String removeDuplicateLetters1(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1);
            } else {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
        }

        int pos = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < s.charAt(pos)) {
                pos = i;
            }
            int freq = map.get(s.charAt(i));
            map.put(s.charAt(i), freq - 1);
            if (freq == 1) {
                break;
            }
        }
        return s.charAt(pos) + removeDuplicateLetters1(s.substring(pos + 1).replace("" + s.charAt(pos), ""));
    }

    /**
     * Monotone Stack
     * Time complexity: O(n)
     * Space complexity: O(1) both stack and visited are bounded by constant, giving us O(1) space complexity.
     */
    public static String removeDuplicateLetters(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1);
            } else {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
        }
        Stack<Character> stack = new Stack<>();

        Set<Character> visited = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            int freq = map.get(s.charAt(i));
            map.put(s.charAt(i), freq - 1);
            if (!visited.contains(s.charAt(i))) {
                while (!stack.isEmpty() && stack.peek() > s.charAt(i) && map.get(stack.peek()) > 0) {
                    visited.remove(stack.pop());
                }
                stack.push(s.charAt(i));
                visited.add(s.charAt(i));
            }
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters("bcabc"));
    }
}
