package leetcode.p0.p79;

import java.util.Arrays;

public class Exist {
    /**
     * My method
     * TODO to check the solution
     */
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            Arrays.fill(visited[i], false);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    visited[i][j] = true;
                    if (backtracking1(board, visited, word, 1, i, j)) {
                        return true;
                    }
                    visited[i][j] = false;
                }
            }
        }
        return false;
    }

    public boolean backtracking1(char[][] board, boolean[][] visited, String word, int index, int x, int y) {
        if (index == word.length()) {
            return true;
        } else {
            if (x + 1 < board.length && !visited[x + 1][y] && board[x + 1][y] == word.charAt(index)) {
                visited[x + 1][y] = true;
                if (backtracking1(board, visited, word, index + 1, x + 1, y)) {
                    return true;
                }
                visited[x + 1][y] = false;
            }
            if (x - 1 >= 0 && !visited[x - 1][y] && board[x - 1][y] == word.charAt(index)) {
                visited[x - 1][y] = true;
                if (backtracking1(board, visited, word, index + 1, x - 1, y)) {
                    return true;
                }
                visited[x - 1][y] = false;
            }
            if (y + 1 < board[0].length && !visited[x][y + 1] && board[x][y + 1] == word.charAt(index)) {
                visited[x][y + 1] = true;
                if (backtracking1(board, visited, word, index + 1, x, y + 1)) {
                    return true;
                }
                visited[x][y + 1] = false;
            }
            if (y - 1 >= 0 && !visited[x][y - 1] && board[x][y - 1] == word.charAt(index)) {
                visited[x][y - 1] = true;
                if (backtracking1(board, visited, word, index + 1, x, y - 1)) {
                    return true;
                }
                visited[x][y - 1] = false;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
