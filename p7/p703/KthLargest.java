package leetcode.p7.p703;

import java.util.PriorityQueue;

/**
 * Heap
 * 08/25/2022 15:28
 */
public class KthLargest {

    PriorityQueue<Integer> priorityQueue;
    int count;
    int k;

    public KthLargest(int k, int[] nums) {
        priorityQueue = new PriorityQueue<>();
        count = 0;
        this.k = k;
        for (int i = 0; i < nums.length; i++) {
            add(nums[i]);
        }
    }

    public int add(int val) {
        if (count < k || val > priorityQueue.peek()) {
            priorityQueue.add(val);
            if (count < k) {
                count++;
            } else {
                priorityQueue.poll();
            }
        }
        return priorityQueue.peek();
    }
}
