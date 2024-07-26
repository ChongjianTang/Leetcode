package leetcode.p4.p402;

import java.util.Objects;
import java.util.Stack;

public class RemoveKdigits {
    /**
     * Apr 11, 2024 17:51
     * Monotonic stack
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public String removeKdigits(String num, int k) {
        if (num.length() == k) {
            return "0";
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            int val = Character.getNumericValue(num.charAt(i));
            while (!stack.isEmpty() && stack.peek() > val && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(val);
        }

        String result = "";
        while (!stack.isEmpty()) {
            if (k > 0) {
                stack.pop();
                k--;
            } else {
                result = stack.pop() + result;
            }
        }

        int index = 0;
        while (index < result.length() - 1 && result.charAt(index) == '0') {
            index++;
        }
        result = result.substring(index);
        return result;
    }

    public static void main(String[] args) {
        RemoveKdigits r = new RemoveKdigits();
        String num;
        int k;

        num = "112";
        k = 1;
        System.out.println(Objects.equals(r.removeKdigits(num, k), "11"));

        num = "1234567890";
        k = 9;
        System.out.println(Objects.equals(r.removeKdigits(num, k), "0"));

        num = "10200";
        k = 1;
        System.out.println(Objects.equals(r.removeKdigits(num, k), "200"));

        num = "1432219";
        k = 3;
        System.out.println(Objects.equals(r.removeKdigits(num, k), "1219"));
    }
}
