package leetcode.p7.p716;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MaxStack {

    Stack<Integer> stack;
    Stack<Integer> maxStack;

    public MaxStack() {
        stack = new Stack<>();
        maxStack = new Stack<>();
    }

    /**
     * Time complexity: O(1)
     */
    public void push(int x) {
        stack.push(x);
        if (maxStack.isEmpty()) {
            maxStack.push(x);
        } else {
            maxStack.push(Math.max(maxStack.peek(), x));
        }
    }

    /**
     * Time complexity: O(1)
     */
    public int pop() {
        maxStack.pop();
        return stack.pop();
    }

    /**
     * Time complexity: O(1)
     */
    public int top() {
        return stack.peek();
    }

    /**
     * Time complexity: O(1)
     */
    public int peekMax() {
        return maxStack.peek();
    }


    /**
     * Time complexity: O(n)
     */
    public int popMax() {
        int max = maxStack.peek();
        Stack<Integer> buffer = new Stack<>();
        while (stack.peek() != max) {
            buffer.push(pop());
        }
        pop();
        while (!buffer.isEmpty()) {
            push(buffer.pop());
        }
        return max;
    }
}
