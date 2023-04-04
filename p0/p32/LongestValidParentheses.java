package leetcode.p0.p32;

import java.util.Stack;

public class LongestValidParentheses {
    /**
     * My approach
     * Time complexity: O(n^2)
     * Around 1400ms
     * Space complexity: O(n)
     */
    public static int longestValidParentheses(String s) {
        int[] nunsOfNetParentheses = new int[s.length()];
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else {
                count--;
            }
            nunsOfNetParentheses[i] = count;
        }
        int max = 0;
        for (int i = 0; i < nunsOfNetParentheses.length - 1; i++) {
            if (s.charAt(i) == '(') {
                for (int j = i + 1; j < nunsOfNetParentheses.length; j++) {
                    if (s.charAt(j) == ')') {
                        if (nunsOfNetParentheses[i] - 1 == nunsOfNetParentheses[j]) {
                            if (j - i > max) {
                                max = j - i + 1;
                            }
                        } else if (nunsOfNetParentheses[j] == nunsOfNetParentheses[i] - 2) {
                            break;
                        }
                    }
                }
            }
        }
        return max;
    }


    /**
     * DP
     * dp(i) = the longest valid substring ending at index i.
     * if s[i] == '(':
     * dp(i) = 0
     * if s[i] == ')':
     * if s[i-1] == '(':
     * dp(i) = dp(i-2) + 2
     * if s[i-1] == ')':
     * if s[i - dp(i-1) - 1] = '(':
     * dp(i) = dp(i-1) + dp(i - dp(i-1) - 2) + 2
     * else:
     * dp(i) = 0
     * <p>
     * Time complexity: O(n)
     * Space complexity: O(n)
     * A really smart DP example.
     */
    public static int longestValidParentheses2(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return 0;
        }
        int[] OPT = new int[s.length()];
        OPT[0] = 0;
        if (s.charAt(0) == '(' && s.charAt(1) == ')') {
            OPT[1] = 2;
        } else {
            OPT[1] = 0;
        }
        int max = OPT[1];
        for (int i = 2; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                OPT[i] = 0;
            } else {
                if (s.charAt(i - 1) == '(') {
                    OPT[i] = OPT[i - 2] + 2;
                    if (OPT[i] > max) {
                        max = OPT[i];
                    }
                } else {
                    if (i - OPT[i - 1] - 1 >= 0 && s.charAt(i - OPT[i - 1] - 1) == '(') {
                        if (i - OPT[i - 1] - 2 < 0) {
                            OPT[i] = OPT[i - 1] + 2;
                        } else {
                            OPT[i] = OPT[i - 1] + OPT[i - OPT[i - 1] - 2] + 2;
                        }
                        if (OPT[i] > max) {
                            max = OPT[i];
                        }
                    } else {
                        OPT[i] = 0;
                    }
                }
            }
        }
        return max;
    }

    /**
     * Stack
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public static int longestValidParentheses3(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.size() == 0) {
                    stack.push(i);
                } else {
                    int length = i - stack.peek();
                    if (length > max) {
                        max = length;
                    }
                }
            }
        }
        return max;
    }

    /**
     * Two counters without extra space.
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public static int longestValidParentheses4(String s) {
        int right = 0;
        int left = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                right++;
            } else {
                left++;
            }
            if (right == left) {
                if (right > max) {
                    max = right;
                }
            } else if (right < left) {
                right = 0;
                left = 0;
            }
        }
        right = 0;
        left = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                right++;
            } else {
                left++;
            }
            if (right == left) {
                if (right > max) {
                    max = right;
                }
            } else if (right > left) {
                right = 0;
                left = 0;
            }
        }

        return 2 * max;
    }


    public static void main(String[] args) {
        System.out.println(longestValidParentheses("(()") == 2);
        System.out.println(longestValidParentheses("()(()") == 2);
        System.out.println(longestValidParentheses(")(((((()())()()))()(()))(") == 22);
        System.out.println(longestValidParentheses("(()(((()") == 2);
        System.out.println(longestValidParentheses(")()())") == 4);
        System.out.println(longestValidParentheses("") == 0);
        System.out.println(longestValidParentheses("()(())") == 6);
        System.out.println(longestValidParentheses("(()))())(") == 4);
        System.out.println(longestValidParentheses("()") == 2);
        System.out.println(longestValidParentheses("(())()(()((") == 6);
        System.out.println(longestValidParentheses("(") == 0);
        System.out.println(longestValidParentheses(")") == 0);
        System.out.println(longestValidParentheses("(((()(((((((()))())((((())())(()())))))))))") == 42);
    }
}
