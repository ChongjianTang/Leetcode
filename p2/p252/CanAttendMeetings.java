package leetcode.p2.p252;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class CanAttendMeetings {
    public static boolean canAttendMeetings1(int[][] intervals) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        pq.addAll(Arrays.asList(intervals));
        int[] prev = pq.poll();
        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            if (temp[0] < prev[1]) {
                return false;
            }
            prev = temp;
        }
        return true;
    }

    public static boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] > intervals[i + 1][0]) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {

    }

}
