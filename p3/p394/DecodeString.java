package leetcode.p3.p394;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DecodeString {
    /**
     * My approach
     * Time complexity: O(n)
     * Space complexity: not sure
     * Use Stringbuilder is much faster
     */
    public static String decodeString1(String s) {
        StringBuilder result = new StringBuilder();
        int k;
        String subString;
        int i = 0;
        while (i < s.length()) {
            if (Character.isDigit(s.charAt(i))) {
                int start = i;
                i++;
                while (Character.isDigit(s.charAt(i))) {
                    i++;
                }
                int end = i;
                k = Integer.parseInt(s.substring(start, end));
                i = i + 1;
                start = i;
                int count = 1;
                while (count != 0) {
                    if (s.charAt(i) == '[') {
                        count++;
                    } else if (s.charAt(i) == ']') {
                        count--;
                    }
                    i++;
                }
                end = i - 1;
                subString = decodeString1(s.substring(start, end));
                result.append(subString.repeat(k));
                i = end + 1;
            } else {
                result.append(s.charAt(i));
                i++;
            }
        }
        return result.toString();
    }

    /**
     * Using one stack
     */
    public static String decodeString2(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ']') {
                stack.push(s.charAt(i));
            } else {
                List<Character> str = new ArrayList<>();
                while (stack.peek() != '[') {
                    str.add(stack.pop());
                }
                stack.pop();

                int num = 0;
                int base = 1;
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    num += (stack.pop() - '0') * base;
                    base *= 10;
                }
                while (num != 0) {
                    for (int j = str.size() - 1; j >= 0; j--) {
                        stack.push(str.get(j));
                    }
                    num--;
                }
            }
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }
        return result.toString();
    }

    /**
     * Using two stacks
     * faster
     */
    public static String decodeString(String s) {
        Stack<String> stringStack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            if (Character.isDigit(s.charAt(i))) {
                int end = i + 1;
                while (Character.isDigit(s.charAt(end))) {
                    end++;
                }
                countStack.push(Integer.parseInt(s.substring(i, end)));
                i = end;
            } else if (s.charAt(i) == '[') {
                i++;
                stringStack.push(currentString.toString());
                currentString = new StringBuilder();
            } else if (s.charAt(i) == ']') {
                currentString = new StringBuilder(currentString.toString().repeat(countStack.pop()));
                if (!stringStack.isEmpty()) {
                    currentString.insert(0, stringStack.pop());
                }
                i++;
            } else {
                int end = i + 1;
                while (end < s.length() && Character.isLetter(s.charAt(end))) {
                    end++;
                }
                currentString.append(s, i, end);
                i = end;
            }
        }
        return currentString.toString();
    }

    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]").equals("aaabcbc"));
        System.out.println(decodeString("3[a2[c]]").equals("accaccacc"));
        System.out.println(decodeString("3[a2[c2[b]]]").equals("acbbcbbacbbcbbacbbcbb"));
        System.out.println(decodeString("2[abc]3[cd]ef").equals("abcabccdcdcdef"));
        System.out.println(decodeString("100[leetcode]").equals("leetcode".repeat(100)));
        System.out.println(decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef").equals("zzzyypqjkjkefjkjkefjkjkefjkjkefyypqjkjkefjkjkefjkjkefjkjkefef"));
        System.out.println(decodeString("2[2[y]a]").equals("yyayya"));
    }
}
