package leetcode.p16.p1611;

import java.util.Stack;

public class MinimumOneBitOperations {
    /**
     * Feb 16, 2024 01:10
     * My method.
     * Time Complexity: O(logn)
     * Space complexity: O(logn)
     */
    public int minimumOneBitOperations(int n) {
        int i = 0;
        Stack<Integer> stack = new Stack<>();
        while (n != 0) {
            if ((n & 1) == 1) {
                stack.push(i);
            }
            n >>= 1;
            i++;
        }
        int result = 0;
        while (!stack.isEmpty() && stack.size() > 1) {
            result += helper(stack.pop(), stack.pop());
        }
        if (stack.isEmpty()) {
            return result;
        } else {
            return result + remove(stack.pop());
        }
    }

    public int helper(int left, int right) {
        return (int) (Math.pow(2, left + 1) - Math.pow(2, right + 1));
    }

    public int remove(int position) {
        return (int) (Math.pow(2, position + 1) - 1);
    }

    // TODO: Check the solution. There are huge things to learn.

    public static void main(String[] args) {
        MinimumOneBitOperations m = new MinimumOneBitOperations();
        int n = 3;
        System.out.println(m.minimumOneBitOperations(n) == 2);
        n = 6;
        System.out.println(m.minimumOneBitOperations(n) == 4);
        n = 9;
        System.out.println(m.minimumOneBitOperations(n) == 14);
    }
}
