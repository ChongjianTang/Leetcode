package leetcode.p3.p341;

import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Stack;


interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}

/**
 * My approach
 * The basic idea is making a flat list recursion
 */
class NestedIterator1 implements Iterator<Integer> {

    private Queue<Integer> queue;

    public NestedIterator1(List<NestedInteger> nestedList) {
        helper(nestedList);
    }

    public void helper(List<NestedInteger> nestedList) {
        for (NestedInteger n : nestedList) {
            if (n.isInteger()) {
                queue.offer(n.getInteger());
            } else {
                helper(n.getList());
            }
        }
    }

    @Override
    public Integer next() {
        return queue.poll();
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }
}

/**
 * One stack
 */
public class NestedIterator implements Iterator<Integer> {

    Stack<NestedInteger> stack = new Stack<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
        makeTopAInteger();
    }

    public void makeTopAInteger() {
        while (!stack.isEmpty() && !stack.peek().isInteger()) {
            NestedInteger n = stack.pop();
            List<NestedInteger> list = n.getList();
            for (int i = list.size() - 1; i >= 0; i--) {
                stack.push(list.get(i));
            }
        }
    }

    @Override
    public Integer next() {
        int result = stack.pop().getInteger();
        makeTopAInteger();
        return result;
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

//TODO check the two stacks approach
