package leetcode.p0.p56;

import java.util.*;

public class Merge {
    /**
     * bubble sort and merge
     * Too slow -- 597ms
     */
    public static int[][] merge1(int[][] intervals) {
        for (int i = 0; i < intervals.length - 1; i++) {
            for (int j = 0; j < intervals.length - 1 - i; j++) {
                if (intervals[j][0] > intervals[j + 1][0]) {
                    int temp = intervals[j][0];
                    intervals[j][0] = intervals[j + 1][0];
                    intervals[j + 1][0] = temp;
                    temp = intervals[j][1];
                    intervals[j][1] = intervals[j + 1][1];
                    intervals[j + 1][1] = temp;
                }
            }
        }
        List<int[]> listOfResult = new ArrayList<>(List.of(intervals[0]));
        for (int i = 1; i < intervals.length; i++) {
            int[] temp = listOfResult.get(listOfResult.size() - 1);
            if (temp[1] >= intervals[i][0]) {
                listOfResult.get(listOfResult.size() - 1)[0] = Math.min(temp[0], intervals[i][0]);
                listOfResult.get(listOfResult.size() - 1)[1] = Math.max(temp[1], intervals[i][1]);
            } else {
                listOfResult.add(intervals[i]);
            }
        }
        int[][] result = new int[listOfResult.size()][2];
        for (int i = 0; i < listOfResult.size(); i++) {
            result[i] = listOfResult.get(i);
        }
        return result;
    }

    /**
     * PriorityQueue instead of bubble
     * Much better -- around 20 ms
     * Time complexity: O(nlogn)
     * <p>
     * If we do sort on the array, the alg can be faster
     */
    public static int[][] merge2(int[][] intervals) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        queue.addAll(Arrays.asList(intervals));
        List<int[]> listOfResult = new ArrayList<>(List.of(queue.poll()));
        while (!queue.isEmpty()) {
            int[] interval = queue.poll();
            int[] temp = listOfResult.get(listOfResult.size() - 1);
            if (temp[1] >= interval[0]) {
                listOfResult.get(listOfResult.size() - 1)[1] = Math.max(temp[1], interval[1]);
            } else {
                listOfResult.add(interval);
            }
        }
        int[][] result = new int[listOfResult.size()][2];
        for (int i = 0; i < listOfResult.size(); i++) {
            result[i] = listOfResult.get(i);
        }
        return result;
    }

    /**
     * Updated from method 2
     * Directly used Arrays.sort instead PriorityQueue
     * faster
     * Around 10ms
     */
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int i = 0;
        for (int j = 1; j < intervals.length; j++) {
            if (intervals[i][1] < intervals[j][0]) {
                i++;
                intervals[i] = intervals[j];
            } else {
                intervals[i][1] = Math.max(intervals[i][1], intervals[j][1]);
            }
        }
        int[][] result = new int[i + 1][];
        for (int j = 0; j < result.length; j++) {
            result[j] = intervals[j];
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] intervals;
        int[][] answer;
        intervals = new int[][]{
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        };
        answer = new int[][]{
                {1, 6},
                {8, 10},
                {15, 18}
        };
        System.out.println(Arrays.deepEquals(merge(intervals), answer));


        intervals = new int[][]{
                {1, 4},
                {0, 4}
        };
        answer = new int[][]{
                {0, 4}
        };
        System.out.println(Arrays.deepEquals(merge(intervals), answer));
    }
}
