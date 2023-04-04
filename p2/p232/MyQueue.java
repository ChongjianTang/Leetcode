package leetcode.p2.p232;

import java.util.Stack;

/**
 * My method
 * push(int x):
 *  Time complexity: O(1)
 *  Space complexity: O(1)
 * pop():
 *  Time complexity: Amortized O(1) and Worst-case O(n)
 *  space complexity: O(1)
 */
public class MyQueue {

    Stack<Integer> in;
    Stack<Integer> out;

    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }

    public void push(int x) {
        in.push(x);
    }

    public int pop() {
        if (out.empty()) {
            while (!in.empty()) {
                out.push(in.pop());
            }
        }
        return out.pop();
    }

    public int peek() {
        if (out.empty()) {
            while (!in.empty()) {
                out.push(in.pop());
            }
        }
        return out.peek();
    }

    public boolean empty() {
        return in.empty() && out.empty();
    }
}
