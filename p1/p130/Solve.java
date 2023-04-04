package leetcode.p1.p130;

import java.util.LinkedList;
import java.util.Queue;

public class Solve {
    /**
     * DFS
     */
    public void solve1(char[][] board) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board[0].length; i++) {
            dfs1(board, 0, i);
            dfs1(board, board.length - 1, i);
        }
        for (int i = 0; i < board.length; i++) {
            dfs1(board, i, 0);
            dfs1(board, i, board[0].length - 1);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'E') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void dfs1(char[][] board, int x, int y) {
        if (board[x][y] == 'O') {
            board[x][y] = 'E';
            int[] dx = new int[]{1, 0, -1, 0};
            int[] dy = new int[]{0, 1, 0, -1};

            for (int i = 0; i < dx.length; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length) {
                    dfs1(board, newX, newY);
                }
            }
        }
    }

    /**
     * BFS
     */
    public static void solve(char[][] board) {
        for (int i = 0; i < board[0].length; i++) {
            bfs1(board, 0, i);
            bfs1(board, board.length - 1, i);
        }
        for (int i = 0; i < board.length; i++) {
            bfs1(board, i, 0);
            bfs1(board, i, board[0].length - 1);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'E') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public static void bfs1(char[][] board, int x, int y) {
        if (board[x][y] == 'O') {
            int[] dx = new int[]{1, 0, -1, 0};
            int[] dy = new int[]{0, 1, 0, -1};

            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{x, y});
            board[x][y] = 'E';
            while (!queue.isEmpty()) {
                int[] pos = queue.poll();
                for (int i = 0; i < dx.length; i++) {
                    int newX = pos[0] + dx[i];
                    int newY = pos[1] + dy[i];
                    if (newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length && board[newX][newY] == 'O') {
                        queue.add(new int[]{newX, newY});
                        board[newX][newY] = 'E';
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] board;
        board = new char[4][4];
        board[0] = new char[]{'X', 'X', 'X', 'X'};
        board[1] = new char[]{'X', 'O', 'O', 'X'};
        board[2] = new char[]{'X', 'O', 'O', 'X'};
        board[3] = new char[]{'X', 'O', 'X', 'X'};

        solve(board);
    }
}
