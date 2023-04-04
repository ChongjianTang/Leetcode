package leetcode.p2.p284;

import java.util.Iterator;

public class PeekingIterator implements Iterator<Integer> {

    int next;
    Iterator<Integer> iterator;

    public PeekingIterator(Iterator<Integer> iterator) {
        if (iterator.hasNext()) {
            this.iterator = iterator;
            next = this.iterator.next();
        } else {
            this.iterator = null;
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        int temp = next;
        if (iterator.hasNext()) {
            next = iterator.next();
        } else {
            iterator = null;
        }
        return temp;
    }

    @Override
    public boolean hasNext() {
        return iterator != null;
    }
}
