package leetcode.p2.p224;

import java.util.Stack;

public class Calculate {
    /**
     * My method
     * I use a stack to do the calculation.
     * O(n)
     */
    public static int calculate1(String s) {
        Stack<String> stack = new Stack<>();
        s = s.replace(" ", "");
        s = s.replace("(-", "(0-");
        if (s.charAt(0) == '-') {
            s = "0" + s;
        }
        int i = 0;
        while (i < s.length()) {
            String next;
            if (s.charAt(i) == '(') {
                next = s.substring(i, i + 1);
                stack.push(next);
                i++;
            } else if (s.charAt(i) == ')') {
                String temp = stack.pop();
                while (!stack.peek().equals("(")) {
                    pushIntoStack(stack, temp);
                    temp = stack.pop();
                }
                stack.pop();
                pushIntoStack(stack, temp);
                i++;
            } else if (Character.isDigit(s.charAt(i))) {
                int start = i;
                i++;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    i++;
                }
                next = s.substring(start, i);
                if (stack.isEmpty() || stack.peek().equals("(")) {
                    stack.push(next);
                } else if (stack.peek().equals("+") || stack.peek().equals("-")) {
                    pushIntoStack(stack, next);
                }
            } else {
                next = s.substring(i, i + 1);
                stack.push(next);
                i++;
            }
        }
        return Integer.parseInt(stack.pop());
    }

    /**
     * The number in the stack change when I push a number into a stack
     * For example:
     * stack: ( 1 +
     * I pushed a '1'
     * Then the stack will be ( 1 + 1 => ( 2
     */
    public static void pushIntoStack(Stack<String> stack, String val) {
        if (stack.isEmpty()) {
            stack.push(val);
        } else {
            int operand2 = Integer.parseInt(val);
            String op = stack.pop();
            if (op.equals("+")) {
                int operand1 = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(operand1 + operand2));
            } else if (op.equals("-")) {
                int operand1 = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(operand1 - operand2));
            } else {
                stack.push(val);
            }
        }
    }

    /**
     * Stack and String Reversal
     */
    public static int calculate(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        s = s.replace(" ", "");
        s = s.replace("(-", "(0-");
        if (s.charAt(0) == '-') {
            s = "0" + s;
        }
        stringBuilder.append(s);
        stringBuilder.reverse();
        s = String.valueOf(stringBuilder);

        // push into a stack
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')' || c == '+' || c == '-') {
                stack.push(s.substring(i, i + 1));
            } else if (Character.isDigit(c)) {
                int start = i;
                i++;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    i++;
                }
                StringBuilder num = new StringBuilder(s.substring(start, i));
                num.reverse();
                stack.push(String.valueOf(num));
                i--;
            } else {
                int num = Integer.parseInt(stack.pop());
                String op = stack.pop();
                while (!op.equals(")")) {
                    if (op.equals("+")) {
                        num += Integer.parseInt(stack.pop());
                    } else {
                        num -= Integer.parseInt(stack.pop());
                    }
                    op = stack.pop();
                }
                stack.push(String.valueOf(num));
            }
        }
        int num = Integer.parseInt(stack.pop());
        while (!stack.isEmpty()) {
            String op = stack.pop();
            if (op.equals("+")) {
                num += Integer.parseInt(stack.pop());
            } else {
                num -= Integer.parseInt(stack.pop());
            }
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(calculate("11+1") == 12);
        System.out.println(calculate("1 + 1") == 2);
        System.out.println(calculate(" 2-1 + 2") == 3);
        System.out.println(calculate("(1+(4+5+2)-3)+(6+8)") == 23);
        System.out.println(calculate("-(2+3)") == -5);
        System.out.println(calculate("2147483647") == 2147483647);
    }
}
