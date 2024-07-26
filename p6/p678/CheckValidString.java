package leetcode.p6.p678;

import java.util.Stack;

public class CheckValidString {
    /**
     * Apr 06, 2024 22:32
     * My approach
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public boolean checkValidString1(String s) {
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                if (stack.isEmpty() || stack.peek()[0] == 0) {
                    stack.push(new int[]{1, 1});
                } else {
                    int[] leftArray = stack.pop();
                    leftArray[1]++;
                    stack.push(leftArray);
                }
            } else if (s.charAt(i) == '*') {
                if (stack.isEmpty() || stack.peek()[0] == 1) {
                    stack.push(new int[]{0, 1});
                } else {
                    int[] starArray = stack.pop();
                    starArray[1]++;
                    stack.push(starArray);
                }
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else if (stack.peek()[0] == 1) {
                    int[] leftArray = stack.pop();
                    leftArray[1]--;
                    if (leftArray[1] > 0) {
                        stack.push(leftArray);
                    }
                } else {
                    if (stack.size() > 1) {
                        int[] starArray = stack.pop();
                        int[] leftArray = stack.pop();
                        leftArray[1]--;
                        if (leftArray[1] > 0) {
                            stack.push(leftArray);
                        }
                        if (!stack.isEmpty() && stack.peek()[0] == 0) {
                            int[] prevStar = stack.pop();
                            starArray[1] += prevStar[1];
                        }
                        stack.push(starArray);
                    } else {
                        int[] starArray = stack.pop();
                        starArray[1]--;
                        if (starArray[1] > 0) {
                            stack.push(starArray);
                        }
                    }
                }
            }
        }
        int star = 0;
        while (!stack.isEmpty()) {
            if (stack.peek()[0] == 1) {
                star -= stack.pop()[1];
                if (star < 0) {
                    return false;
                }
            } else {
                star += stack.pop()[1];
            }
        }
        return true;
    }


    public boolean checkValidString(String s) {
        return true;
//        TODO: Two Pointer
    }

    public static void main(String[] args) {
        CheckValidString c = new CheckValidString();
        String s;


        s = "(*)(*((*(((*)*)(((((*)(((*)))((**)((*)*)";
//        s = "(*())(()*((*(((()*())*()())(((((()*)()(((((()()))*)()))((())((((())))**(())()()()())((())(*())()*)()";
        System.out.println(c.checkValidString(s));

        s = "(((((*(((((*)*(**)))))))))))((((*)))))(((**(*)))(*)";
        System.out.println(c.checkValidString(s));

        s = "((((()(()()()*()(((((*)()*(**(())))))(())()())(((())())())))))))(((((())*)))()))(()((*()*(*)))(*)()";
        System.out.println(c.checkValidString(s));

        s = "(";
        System.out.println(!c.checkValidString(s));
    }
}
