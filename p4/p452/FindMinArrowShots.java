package leetcode.p4.p452;


import java.util.*;

public class FindMinArrowShots {
    /**
     * Mar 17, 2024 19:41
     * My approach, two sorted arrays
     * Time Complexity: O(nlogn)
     * Space Complexity: O(nlogn)
     */
    public int findMinArrowShots(int[][] points) {
        Map<Integer, int[]> map = new HashMap<>();
        Integer[] start = new Integer[points.length];
        for (int i = 0; i < points.length; i++) {
            map.put(i, points[i]);
            start[i] = i;
        }
        Integer[] end = start.clone();
        Arrays.sort(start, Comparator.comparingInt(o -> map.get(o)[0]));
        Arrays.sort(end, Comparator.comparingInt(o -> map.get(o)[1]));

        int count = 0;
        int i = 0;
        int j = 0;
        while (i < end.length) {
            int balloon = end[i];
            if (map.containsKey(balloon)) {
                int endVale = map.get(balloon)[1];
                while (j < start.length && (!map.containsKey(start[j]) || map.get(start[j])[0] <= endVale)) {
                    map.remove(start[j]);
                    j++;
                }
                count++;
            }
            i++;
        }
        return count;
    }

    //TODO try find a better solution.

    public static void main(String[] args) {
        FindMinArrowShots f = new FindMinArrowShots();
        int[][] points;

        points = new int[][]{
                {10, 16},
                {2, 8},
                {1, 6},
                {7, 12}
        };

        System.out.println(f.findMinArrowShots(points) == 2);
    }
}