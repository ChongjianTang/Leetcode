package leetcode.p12.p1235;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class JobScheduling {
    static class Interval {
        int start;
        int end;
        int profit;

        public Interval(int start, int end, int profit) {
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }

    /**
     * DP + BinarySearch
     * We can use a simple List to replace the Interval class
     */
    public static int jobScheduling1(int[] startTime, int[] endTime, int[] profit) {
        PriorityQueue<Interval> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.end));
        for (int i = 0; i < startTime.length; i++) {
            Interval temp = new Interval(startTime[i], endTime[i], profit[i]);
            priorityQueue.add(temp);
        }
        Interval[] intervals = new Interval[priorityQueue.size()];
        int[] p = new int[intervals.length];
        intervals[0] = priorityQueue.poll();
        p[0] = 0;
        for (int i = 1; i < intervals.length; i++) {
            intervals[i] = priorityQueue.poll();
            p[i] = binarySearch1(intervals, 0, i - 1, intervals[i].start);
        }
        int[] OPT = new int[intervals.length + 1];
        OPT[0] = 0;
        for (int i = 1; i < OPT.length; i++) {
            OPT[i] = Math.max(OPT[p[i - 1]] + intervals[i - 1].profit, OPT[i - 1]);
        }
        return OPT[intervals.length];
    }

    public static int binarySearch1(Interval[] intervals, int start, int end, int startTime) {
        if (end - start <= 1) {
            if (intervals[start].end > startTime) {
                return start;
            }
            if (intervals[end].end > startTime) {
                return end;
            } else {
                return end + 1;
            }
        }
        int index = (end + start) / 2;
        if (intervals[index].end <= startTime && intervals[index + 1].end > startTime) {
            return index + 1;
        } else if (intervals[index].end <= startTime && intervals[index + 1].end <= startTime) {
            return binarySearch1(intervals, index + 1, end, startTime);
        } else {
            return binarySearch1(intervals, start, index, startTime);
        }
    }

    /**
     * After I change the class to a list
     * it became super slow
     * 250+ ms
     */
    public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        PriorityQueue<List<Integer>> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.get(1)));
        for (int i = 0; i < startTime.length; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(startTime[i]);
            temp.add(endTime[i]);
            temp.add(profit[i]);
            priorityQueue.add(temp);
        }
        List<List<Integer>> intervals = new ArrayList<>();
        int[] p = new int[startTime.length];
        intervals.add(priorityQueue.poll());
        p[0] = 0;
        for (int i = 1; i < startTime.length; i++) {
            List<Integer> temp = priorityQueue.poll();
            intervals.add(temp);
            p[i] = binarySearch(intervals, 0, i - 1, temp.get(0));
        }
        int[] OPT = new int[startTime.length + 1];
        OPT[0] = 0;
        for (int i = 1; i < OPT.length; i++) {
            OPT[i] = Math.max(OPT[p[i - 1]] + intervals.get(i - 1).get(2), OPT[i - 1]);
        }
        return OPT[startTime.length];
    }

    /**
     * The start and end are inclusive
     */
    public static int binarySearch(List<List<Integer>> intervals, int start, int end, int startTime) {
        if (end - start <= 1) {
            if (intervals.get(start).get(1) > startTime) {
                return start;
            }
            if (intervals.get(end).get(1) > startTime) {
                return end;
            } else {
                return end + 1;
            }
        }
        int index = (end + start) / 2;
        if (intervals.get(index).get(1) <= startTime && intervals.get(index + 1).get(1) > startTime) {
            return index + 1;
        } else if (intervals.get(index).get(1) <= startTime && intervals.get(index + 1).get(1) <= startTime) {
            return binarySearch(intervals, index + 1, end, startTime);
        } else {
            return binarySearch(intervals, start, index, startTime);
        }
    }


    public static void main(String[] args) {
        int[] startTime, endTime, profit;

        startTime = new int[]{1, 1, 1};
        endTime = new int[]{2, 3, 4};
        profit = new int[]{5, 6, 4};

        System.out.println(jobScheduling(startTime, endTime, profit) == 6);

        startTime = new int[]{1, 2, 3, 4, 6};
        endTime = new int[]{3, 5, 10, 6, 9};
        profit = new int[]{20, 20, 100, 70, 60};

        System.out.println(jobScheduling(startTime, endTime, profit) == 150);

        startTime = new int[]{1, 2, 3, 3};
        endTime = new int[]{3, 4, 5, 6};
        profit = new int[]{50, 10, 40, 70};

        System.out.println(jobScheduling(startTime, endTime, profit) == 120);
    }
}
