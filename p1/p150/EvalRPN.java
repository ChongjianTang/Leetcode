package leetcode.p1.p150;

import java.util.Stack;

public class EvalRPN {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+": {
                    int num2 = stack.pop();
                    int num1 = stack.pop();
                    stack.push(num1 + num2);
                    break;
                }
                case "-": {
                    int num2 = stack.pop();
                    int num1 = stack.pop();
                    stack.push(num1 - num2);
                    break;
                }
                case "*": {
                    int num2 = stack.pop();
                    int num1 = stack.pop();
                    stack.push(num1 * num2);
                    break;
                }
                case "/": {
                    int num2 = stack.pop();
                    int num1 = stack.pop();
                    stack.push(num1 / num2);
                    break;
                }
                default:
                    stack.push(Integer.parseInt(token));
                    break;
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] tokens;
        int output;

        tokens = new String[5];
        tokens[0] = "2";
        tokens[1] = "1";
        tokens[2] = "+";
        tokens[3] = "3";
        tokens[4] = "*";
        output = 9;

        System.out.println(evalRPN(tokens) == output);
        tokens = new String[5];
        tokens[0] = "4";
        tokens[1] = "13";
        tokens[2] = "5";
        tokens[3] = "/";
        tokens[4] = "+";
        output = 6;
        System.out.println(evalRPN(tokens) == output);

        tokens = new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        output = 22;
        System.out.println(evalRPN(tokens) == output);
    }
}
