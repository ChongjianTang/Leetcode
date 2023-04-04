package leetcode.p2.p218;

import java.util.*;

public class GetSkyline {
    /**
     * Jan 23, 2023 18:02
     * Brute Force 1
     * we can iterate over all the buildings, and for each building we find
     * the positions of its left edge and right edge and their corresponding
     * indexes left_index and right_index. Then we update the maximum height
     * for all the indexes within the range [left_index, right_index).
     * Finally, traverse the updated heights and output all the positions
     * where height changes as skyline key points!
     * Time complexity: O(n^2)
     * Space complexity: O(n)
     */
    public static List<List<Integer>> getSkyline1(int[][] buildings) {
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> indexMap = new HashMap<>();
        // Iterate through all buildings and get a sorted list for all x positions and an index map for x positions.
        for (int i = 0; i < buildings.length; i++) {
            int x1 = buildings[i][0];
            int x2 = buildings[i][1];
            set.add(x1);
            set.add(x2);
        }
        List<Integer> xPos = new ArrayList<>(set);
        xPos.sort((o1, o2) -> o1 - o2);
        for (int i = 0; i < xPos.size(); i++) {
            indexMap.put(xPos.get(i), i);
        }

        // Update the max height array.
        int[] height = new int[xPos.size()];
        for (int i = 0; i < buildings.length; i++) {
            int x1 = buildings[i][0];
            int x2 = buildings[i][1];
            int h = buildings[i][2];
            int start = indexMap.get(x1);
            int end = indexMap.get(x2);
            for (int j = start; j < end; j++) {
                if (height[j] < h) {
                    height[j] = h;
                }
            }
        }

        // the points where height changes are skyline key points.
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(new ArrayList<>());
        answer.get(0).add(xPos.get(0));
        answer.get(0).add(height[0]);
        for (int i = 1; i < height.length; i++) {
            if (height[i] != answer.get(answer.size() - 1).get(1)) {
                answer.add(new ArrayList<>());
                answer.get(answer.size() - 1).add(xPos.get(i));
                answer.get(answer.size() - 1).add(height[i]);
            }
        }
        return answer;
    }


    public static List<List<Integer>> getSkyline(int[][] buildings) {
        return null;
    }


    public static void main(String[] args) {
        int[][] buildings;

        buildings = new int[][]{
                {2, 9, 10},
                {3, 7, 15},
                {5, 12, 12},
                {15, 20, 10},
                {19, 24, 8}
        };
        getSkyline(buildings);
    }
}
