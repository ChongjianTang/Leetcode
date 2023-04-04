package leetcode.p0.p57;

import java.util.ArrayList;
import java.util.List;

public class Insert {
    /**
     * 08/30/2022 17:20
     * My approach
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> resultList = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            if (newInterval[1] < intervals[i][0]) {
                resultList.add(newInterval);
                for (int j = i; j < intervals.length; j++) {
                    resultList.add(intervals[j]);
                }
                newInterval = null;
                break;
            } else if (newInterval[0] > intervals[i][1]) {
                resultList.add(intervals[i]);
            } else {
                newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
                newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            }
        }
        if (newInterval != null) {
            resultList.add(newInterval);
        }

        int[][] result = new int[resultList.size()][];
        for (int i = 0; i < result.length; i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }
}
