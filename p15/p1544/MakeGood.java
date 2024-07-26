package leetcode.p15.p1544;

import java.util.Stack;

public class MakeGood {
    /**
     * Apr 05, 2024 00:33
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
            } else {
                if (Character.toLowerCase(stack.peek()) == Character.toLowerCase(s.charAt(i)) && stack.peek() != s.charAt(i)) {
                    stack.pop();
                } else {
                    stack.push(s.charAt(i));
                }
            }
        }
        String result = "";
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }
}
