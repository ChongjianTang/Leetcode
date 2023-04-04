package leetcode.p2.p225;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {

    Queue<Integer> queue;
    int front;

    public MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.add(x);
        front=x;
    }

    public int pop() {
        for (int i = 0; i < queue.size() - 2; i++) {
            queue.add(queue.poll());
        }
        assert !queue.isEmpty();
        front =queue.poll();
        queue.add(front);
        return queue.poll();
    }

    public int top() {
        return front;
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
