package leetcode.p13.p1381;

public class CustomStack {

    int maxSize;
    int[] stack;
    int top;

    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
        top = 0;
    }

    public void push(int x) {
        if (top != stack.length) {
            stack[top] = x;
            top++;
        }
    }

    public int pop() {
        if (top == 0) {
            return -1;
        } else {
            top--;
            return stack[top];
        }
    }

    public void increment(int k, int val) {
        for (int i = 0; i < k && i < stack.length; i++) {
            stack[i] += val;
        }
    }

    public static void main(String[] args) {
        CustomStack customStack = new CustomStack(3);
        customStack.push(1);
        customStack.push(2);
        customStack.pop();
        customStack.push(2);
        customStack.push(3);
        customStack.push(4);
        customStack.increment(5, 100);
        customStack.increment(2, 100);
        System.out.println(customStack.pop() == 103);
        System.out.println(customStack.pop() == 202);
        System.out.println(customStack.pop() == 201);
    }
}
