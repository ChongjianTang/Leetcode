package leetcode.p2.p207;

import java.util.*;

public class CanFinish {
    /**
     * 08/04/2022 19:09
     * Topological Sort
     * Time complexity: O(|E|+|V|)
     * Space complexity: O(|E|+|V|)
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        int[] preNum = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[1]).add(prerequisite[0]);
            preNum[prerequisite[0]]++;
        }
        for (int i = 0; i < numCourses; i++) {
            boolean availableCourses = false;
            for (int j = 0; j < preNum.length; j++) {
                if (preNum[j] == 0) {
                    for (int k : graph.get(j)) {
                        preNum[k]--;
                    }
                    preNum[j] = -1;
                    availableCourses = true;
                    break;
                }
            }
            if (!availableCourses) {
                return false;
            }
        }
        return true;
    }
}
