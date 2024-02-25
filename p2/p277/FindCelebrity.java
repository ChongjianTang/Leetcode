package leetcode.p2.p277;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FindCelebrity {
    Map<Integer, Set<Integer>> knowMap = new HashMap<>();

    boolean knows(int a, int b) {
        if (knowMap.containsKey(a) && knowMap.get(a).contains(b)) {
            return true;
        }
        return false;
    }

    /**
     * Feb 24, 2024 15:38
     * My approach based on degree of nodes. Just from problem 977.
     * Time Complexity: O(n^2)
     * Space Complexity: O(n)
     */
    public int findCelebrity1(int n) {
        int[] degree = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (knows(i, j)) {
                    degree[i]--;
                    degree[j]++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (degree[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }


    /**
     * Feb 24, 2024 16:30
     * The first traversal eliminates any impossible candidates. The second traversal checks if he is a celebrity.
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int findCelebrity(int n) {
        int index = 0;
        for (int i = 1; i < n; i++) {
            if (index != i) {
                if (knows(index, i)) {
                    index = i;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (index != i) {
                if (!knows(i, index) || knows(index, i)) {
                    return -1;
                }
            }
        }
        return index;
    }
}
