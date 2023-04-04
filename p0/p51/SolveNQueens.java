package leetcode.p0.p51;

import java.util.*;

public class SolveNQueens {
    /**
     * My method
     * Brute Force
     * Recursive
     * Basically it is n^2*(n^2-1)*(n^2-2)*...*(n^2-n)
     * So the time complexity is n^2n
     * Time: 724sm too slow
     * Space: 118.4MB
     */
    public static List<List<String>> solveNQueens1(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        List<List<String>> result = new ArrayList<>();
        backtracking1(board, 0, 0, new HashSet<>(), result);
        return result;
    }

    public static void backtracking1(char[][] board, int x, int y, HashSet<Integer> queens, List<List<String>> result) {
        if (queens.size() == board.length) {
            List<String> boardList = new ArrayList<>();
            for (char[] chars : board) {
                boardList.add(String.valueOf(chars));
            }
            result.add(boardList);
        } else if (x < board.length) {
            boolean flag = true;
            for (int queen : queens) {
                if (check1(x, y, queen / board.length, queen % board.length)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                board[x][y] = 'Q';
                queens.add(x * board.length + y);
                backtracking1(board, x + 1, 0, queens, result);
                board[x][y] = '.';
                queens.remove(x * board.length + y);

            }
            if (x != board.length - 1 || y != board.length - 1) {
                if (y != board.length - 1) {
                    backtracking1(board, x, y + 1, queens, result);
                } else {
                    backtracking1(board, x + 1, 0, queens, result);
                }
            }
        }
    }

    private static boolean check1(int x1, int y1, int x2, int y2) {
        return x1 == x2 || y1 == y2 || Math.abs(x1 - x2) == Math.abs(y1 - y2);
    }

    /**
     * Try to optimize the first method
     * Time complexity: O(n!)
     * Space complexity: O(n^2)
     */
    public static List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        List<List<String>> result = new ArrayList<>();
        backtracking2(board, 0, new HashSet<>(), new HashSet<>(), new HashSet<>(), result);
        return result;
    }

    public static void backtracking2(char[][] board, int row, Set<Integer> diagonals, Set<Integer> antiDiagonals, Set<Integer> cols, List<List<String>> result) {
        if (row == board.length) {
            List<String> boardList = new ArrayList<>();
            for (char[] chars : board) {
                boardList.add(String.valueOf(chars));
            }
            result.add(boardList);
        } else {
            for (int i = 0; i < board.length; i++) {
                if (!cols.contains(i) && !diagonals.contains(row - i) && !antiDiagonals.contains(row + i)) {
                    diagonals.add(row - i);
                    antiDiagonals.add(row + i);
                    cols.add(i);
                    board[row][i] = 'Q';
                    backtracking2(board, row + 1, diagonals, antiDiagonals, cols, result);
                    board[row][i] = '.';
                    diagonals.remove(row - i);
                    antiDiagonals.remove(row + i);
                    cols.remove(i);
                }
            }
        }
    }
}
