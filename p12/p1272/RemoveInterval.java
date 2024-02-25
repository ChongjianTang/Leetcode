package leetcode.p12.p1272;

import java.util.ArrayList;
import java.util.List;

public class RemoveInterval {
    /**
     * Feb 17, 2024 15:06
     * Nothing to say. Way too easy.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][1] <= toBeRemoved[0]) {
                List<Integer> interval = new ArrayList<>();
                interval.add(intervals[i][0]);
                interval.add(intervals[i][1]);
                result.add(interval);
            } else if (intervals[i][0] < toBeRemoved[0] && intervals[i][1] > toBeRemoved[0] && intervals[i][1] <= toBeRemoved[1]) {
                List<Integer> interval = new ArrayList<>();
                interval.add(intervals[i][0]);
                interval.add(toBeRemoved[0]);
                result.add(interval);
            } else if (intervals[i][0] < toBeRemoved[0] && intervals[i][1] > toBeRemoved[1]) {
                List<Integer> interval1 = new ArrayList<>();
                interval1.add(intervals[i][0]);
                interval1.add(toBeRemoved[0]);
                result.add(interval1);
                List<Integer> interval2 = new ArrayList<>();
                interval2.add(toBeRemoved[1]);
                interval2.add(intervals[i][1]);
                result.add(interval2);
            } else if (intervals[i][0] < toBeRemoved[1] && intervals[i][1] > toBeRemoved[1]) {
                List<Integer> interval = new ArrayList<>();
                interval.add(toBeRemoved[1]);
                interval.add(intervals[i][1]);
                result.add(interval);
            } else if (intervals[i][0] > toBeRemoved[1]) {
                List<Integer> interval = new ArrayList<>();
                interval.add(intervals[i][0]);
                interval.add(intervals[i][1]);
                result.add(interval);
            }
        }
        return result;
    }
}
