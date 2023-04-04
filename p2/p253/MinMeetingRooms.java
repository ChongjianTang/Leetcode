package leetcode.p2.p253;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinMeetingRooms {
    /**
     * My approach
     */
    public static int minMeetingRooms1(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        int max = 1;
        for (int i = 0; i < intervals.length; i++) {
            if (queue.isEmpty()) {
                queue.add(intervals[i]);
            } else {
                int[] nextRoom = queue.peek();
                while (nextRoom[1] <= intervals[i][0]) {
                    queue.poll();
                    if (queue.isEmpty()) {
                        break;
                    }
                    nextRoom = queue.peek();
                }
                queue.add(intervals[i]);
                if (queue.size() > max) {
                    max = queue.size();
                }
            }
        }
        return max;
    }

    /**
     * PriorityQueue
     * Time complexity: O(nlogn)
     * Space complexity: O(n)
     */
    public static int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        int result = 0;
        for (int[] interval : intervals) {
            while (!queue.isEmpty() && queue.peek()[1] <= interval[0]) {
                queue.poll();
            }
            queue.offer(interval);
            result = Math.max(result, queue.size());
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] intervals;

        intervals = new int[][]{
                {0, 30},
                {5, 10},
                {15, 20}
        };

        System.out.println(minMeetingRooms(intervals) == 2);

        intervals = new int[][]{
                {7, 10},
                {2, 4}
        };
        System.out.println(minMeetingRooms(intervals) == 1);
    }
}

