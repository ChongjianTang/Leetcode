package leetcode.p32;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class LongestValidParentheses {
    /**
     * My approach.
     * Time O(n^2)
     * Space O(n)
     */
    public static int longestValidParentheses1(String s) {
        int[] array = new int[s.length()];
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else {
                count--;
            }
            array[i] = count;
        }
        int max = 0;
        for (int i = 0; i < array.length - 1; i++) {
            if (s.charAt(i) == '(') {
                for (int j = i + 1; j < array.length; j++) {
                    if (s.charAt(j) == ')') {
                        if (array[i] - 1 == array[j]) {
                            if (j - i > max) {
                                max = j - i + 1;
                            }
                        } else if (array[j] == array[i] - 2) {
                            break;
                        }
                    }
                }
            }
        }
        return max;
    }


    /**
     * Dynamic Programming.
     * A really smart dynamic programming example.
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
     * Two pointers without extra space.
     */
    public static int longestValidParentheses(String s) {
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
