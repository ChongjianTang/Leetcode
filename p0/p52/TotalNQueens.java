package leetcode.p0.p52;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TotalNQueens {
    /**
     * From p51
     * Time complexity: O(n!)
     * Space complexity: O(n)
     */
    public int totalNQueens(int n) {
        return backtracking1(n, 0, new HashSet<>(), new HashSet<>(), new HashSet<>());
    }

    public static int backtracking1(int n, int row, Set<Integer> diagonals, Set<Integer> antiDiagonals, Set<Integer> cols) {
        if (row == n) {
            return 1;
        } else {
            int result = 0;
            for (int i = 0; i < n; i++) {
                if (!cols.contains(i) && !diagonals.contains(row - i) && !antiDiagonals.contains(row + i)) {
                    diagonals.add(row - i);
                    antiDiagonals.add(row + i);
                    cols.add(i);
                    result += backtracking1(n, row + 1, diagonals, antiDiagonals, cols);
                    diagonals.remove(row - i);
                    antiDiagonals.remove(row + i);
                    cols.remove(i);
                }
            }
            return result;
        }
    }
}
