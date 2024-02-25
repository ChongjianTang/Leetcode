package leetcode.p16.p1642;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

public class FurthestBuilding {
    /**
     * Feb 17, 2024 15:43
     * Greedy
     * Time Complexity: O(nlogn)
     * Space Complexity: O(n)
     */
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > heights[i - 1]) {
                int diff = heights[i] - heights[i - 1];
                if (bricks >= diff) {
                    pq.offer(diff);
                    bricks -= diff;
                } else {
                    if (ladders != 0) {
                        ladders--;
                        if (!pq.isEmpty() && pq.peek() > diff) {
                            bricks += pq.poll();
                            bricks -= diff;
                            pq.offer(diff);
                        }
                    } else {
                        return i - 1;
                    }
                }
            }
        }
        return heights.length - 1;
    }

    // TODO: Check the solution.

    public static void main(String[] args) {
        FurthestBuilding furthestBuilding = new FurthestBuilding();
        int[] heights = new int[]{2, 7, 9, 12};
        int bricks = 5;
        int ladders = 1;
        System.out.println(furthestBuilding.furthestBuilding(heights, bricks, ladders) == 3);
    }
}
