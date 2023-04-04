package leetcode.p2.p295;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * My approach
 * Two heaps with a int median
 */
public class MedianFinder {

    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    Boolean isOdd;
    int median;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        isOdd = false;
    }

    public void addNum(int num) {
        if (!isOdd) {
            if (minHeap.isEmpty() || maxHeap.isEmpty() || (num <= minHeap.peek() && num >= maxHeap.peek())) {
                median = num;
            } else if (num > minHeap.peek()) {
                median = minHeap.poll();
                minHeap.add(num);
            } else {
                median = maxHeap.poll();
                maxHeap.add(num);
            }
        } else {
            if (minHeap.isEmpty() || maxHeap.isEmpty() || (num <= minHeap.peek() && num >= maxHeap.peek())) {
                if (num > median) {
                    minHeap.add(num);
                    maxHeap.add(median);
                } else {
                    minHeap.add(median);
                    maxHeap.add(num);
                }
            } else if (num > minHeap.peek()) {
                minHeap.add(num);
                maxHeap.add(median);
            } else {
                maxHeap.add(num);
                minHeap.add(median);
            }
        }
        isOdd = !isOdd;
    }

    public double findMedian() {
        if (isOdd) {
            return median;
        } else {
            System.out.println(maxHeap.peek());
            System.out.println(minHeap.peek());
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
    }

    public static void main(String[] args) {
        MedianFinder m = new MedianFinder();
        m.addNum(-1);
        m.addNum(-2);
        m.addNum(-3);
        m.addNum(-4);
        System.out.println(m.findMedian());
    }
}

// TODO a lot of to do
