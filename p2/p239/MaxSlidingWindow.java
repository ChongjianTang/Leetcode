package leetcode.p2.p239;

import java.util.*;

public class MaxSlidingWindow {
    /**
     * Brute force
     * Time complexity: O(nk)
     * Space complexity: O(1)
     * TLE - 37/51
     */
    public static int[] maxSlidingWindow1(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        Arrays.fill(result, Integer.MIN_VALUE);
        for (int i = 0; i < nums.length - k + 1; i++) {
            for (int j = 0; j < k; j++) {
                result[i] = Math.max(result[i], nums[i + j]);
            }
        }
        return result;
    }

    /**
     * Heap
     * Time complexity: O(nk) pq.remove is a O(k) action
     * Space complexity: O(k)
     * TLE - 37/51
     */
    public static int[] maxSlidingWindow2(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < k; i++) {
            priorityQueue.add(nums[i]);
        }
        int[] result = new int[nums.length - k + 1];
        result[0] = priorityQueue.peek();
        for (int i = 0; i < nums.length - k; i++) {
            priorityQueue.remove(nums[i]);
            priorityQueue.add(nums[i + k]);
            result[i + 1] = priorityQueue.peek();
        }
        return result;
    }


    /**
     * Deque
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.addLast(i);
        }

        int[] result = new int[nums.length - k + 1];
        result[0] = nums[deque.peekFirst()];
        for (int i = 0; i < nums.length - k; i++) {
            if (!deque.isEmpty() && deque.peekFirst() == i) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i + k]) {
                deque.pollLast();
            }
            deque.addLast(i + k);
            result[i + 1] = nums[deque.peekFirst()];
        }
        return result;
    }

    //TODO dp one


    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }
}
