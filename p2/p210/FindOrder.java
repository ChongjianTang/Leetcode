package leetcode.p2.p210;

import java.util.ArrayList;
import java.util.List;

public class FindOrder {
    /**
     * 08/13/2022 14:39
     * Topological Sort
     * Time complexity: O(|E|+|V|)
     * Space complexity: O(|E|+|V|)
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        int[] preNum = new int[numCourses];
        int[] result = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[1]).add(prerequisite[0]);
            preNum[prerequisite[0]]++;
        }

        int index = 0;
        for (int i = 0; i < numCourses; i++) {
            boolean availableCourses = false;
            for (int j = 0; j < preNum.length; j++) {
                if (preNum[j] == 0) {
                    result[index] = j;
                    index++;
                    for (int k : graph.get(j)) {
                        preNum[k]--;
                    }
                    preNum[j] = -1;
                    availableCourses = true;
                    break;
                }
            }
            if (!availableCourses) {
                return new int[0];
            }
        }
        return result;
    }
}
