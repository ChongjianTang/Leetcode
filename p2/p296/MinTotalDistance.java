package leetcode.p2.p296;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MinTotalDistance {
    /**
     * Sorting
     * Time complexity: O(mnlognm)
     * Space complexity: O(mn)
     */
    public int minTotalDistance(int[][] grid) {
        List<Integer> iPos = new ArrayList<>();
        List<Integer> jPos = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    iPos.add(i);
                    jPos.add(j);
                }
            }
        }

        Collections.sort(iPos);
        Collections.sort(jPos);

        int result = 0;
        int start = 0;
        int end = iPos.size() - 1;
        while (start < end) {
            result += iPos.get(end) - iPos.get(start);
            result += jPos.get(end) - jPos.get(start);
            start++;
            end--;
        }

        return result;
    }
}
