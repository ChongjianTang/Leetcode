package leetcode.p13.p1326;

import java.util.*;

public class MinTaps {
//    https://leetcode.com/problems/minimum-number-of-taps-to-open-to-water-a-garden/
    /**
     * Jan 11, 2024 08:29
     * Greedy algorithm
     * Time complexity: O(nlogn)
     * Space complexity: O(n)
     */
    public int minTaps(int n, int[] ranges) {
        List<int[]> intervals = new ArrayList<>();
        for (int i = 0; i < ranges.length; i++) {
            if (ranges[i] != 0) {
                intervals.add(new int[]{i - ranges[i], i + ranges[i]});
            }
        }

        intervals.sort((o1, o2) -> {
            if (o1[0] - o2[0] != 0) {
                return o1[0] - o2[0];
            } else {
                return o1[1] - o2[1];
            }
        });
        int count = 0;
        int wateredRange = 0;
        int i = 0;
        while (wateredRange < n) {
            if (i >= intervals.size() || intervals.get(i)[0] > wateredRange) {
                return -1;
            }
            int nextWaterRange = wateredRange;
            while (i < intervals.size() && intervals.get(i)[0] <= wateredRange) {
                nextWaterRange = Math.max(nextWaterRange, intervals.get(i)[1]);
                i++;
            }
            wateredRange = nextWaterRange;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        MinTaps minTaps = new MinTaps();
        int n;
        int[] ranges;

        n = 5;
        ranges = new int[]{3, 4, 1, 1, 0, 0};

        System.out.println(minTaps.minTaps(n, ranges) == 1);

        n = 3;
        ranges = new int[]{0, 0, 0, 0};
        System.out.println(minTaps.minTaps(n, ranges) == -1);

        n = 7;
        ranges = new int[]{1, 2, 1, 0, 2, 1, 0, 1};
        System.out.println(minTaps.minTaps(n, ranges) == 3);

        n = 5;
        ranges = new int[]{3, 0, 1, 1, 0, 0};
        System.out.println(minTaps.minTaps(n, ranges) == -1);
    }
}
