package leetcode.p2.p215;

import java.util.Arrays;
import java.util.PriorityQueue;

public class FindKthLargest {
    /**
     * Sort
     * O(nlogn) time complexity and O(1) space complexity.
     */
    public int findKthLargest1(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    /**
     * heap
     * O(nlogk) time complexity and O(k) to store the heap elements.
     */
    public static int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            heap.add(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            heap.add(nums[i]);
            heap.poll();
        }
        return heap.poll();
    }

    /**
     * Quickselect
     * O(n) in the average case, O(n2) in the worse case
     * O(1)
     */
    public static int findKthLargest(int[] nums, int k) {
        return 0; //TODO
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        int[] nums;

        nums = new int[]{3, 2, 1, 5, 6, 4};
        System.out.println(findKthLargest(nums, 2) == 5);

        nums = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(findKthLargest(nums, 4) == 4);
    }
}
