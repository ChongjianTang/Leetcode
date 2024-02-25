package leetcode.p2.p200;

import java.util.*;

public class NumIslands {
    /**
     * Recursion
     * Backtracking
     * DFS
     */
    public static int numIslands1(char[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    dfs1(grid, i, j);
                }
            }
        }
        return result;
    }

    public static void dfs1(char[][] grid, int x, int y) {
        grid[x][y] = '0';
        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, 1, 0, -1};

        for (int i = 0; i < dx.length; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length && grid[newX][newY] == 1) {
                dfs1(grid, newX, newY);
            }
        }
    }


    /**
     * Feb 10, 2024 18:12
     * Iterative BFS
     * Time Complexity: O(n*m)
     * Space Complexity: O(min(n.m))
     */
    public static int numIslands2(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    IterativeBFS2(grid, i, j);
                }
            }
        }
        return count;
    }

    public static void IterativeBFS2(char[][] grid, int i, int j) {
        int[] di = new int[]{1, -1, 0, 0};
        int[] dj = new int[]{0, 0, 1, -1};
        Queue<int[]> queueOfLands = new LinkedList<>();
        queueOfLands.offer(new int[]{i, j});
        grid[i][j] = '0';
        while (!queueOfLands.isEmpty()) {
            int[] position = queueOfLands.poll();
            for (int k = 0; k < di.length; k++) {
                int newI = position[0] + di[k];
                int newJ = position[1] + dj[k];
                if (newI >= 0 && newI < grid.length && newJ >= 0 && newJ < grid[0].length && grid[newI][newJ] == '1') {
                    queueOfLands.offer(new int[]{newI, newJ});
                    grid[newI][newJ] = '0';
                }
            }
        }
    }

    public static int numIslands(char[][] grid) {
        //TODO: Union Find
        return 0;
    }


    public static void main(String[] args) {
        char[][] grid;
        grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println(numIslands(grid) == 1);

        grid = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println(numIslands(grid) == 3);
    }
}
