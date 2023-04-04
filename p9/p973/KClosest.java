package leetcode.p9.p973;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosest {
    /**
     * PriorityQueue
     */
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1, o2) -> o1[0] * o1[0] + o1[1] * o1[1] - o2[0] * o2[0] - o2[1] * o2[1]);
        for (int[] point : points) {
            priorityQueue.offer(point);
        }

        int[][] result = new int[k][];
        for (int i = 0; i < k; i++) {
            result[i] = priorityQueue.poll();
        }
        return result;
    }
}
