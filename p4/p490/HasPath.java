package leetcode.p4.p490;

import java.util.LinkedList;
import java.util.Queue;

public class HasPath {
    /**
     * My method
     * BFS
     */
    public boolean hasPath1(int[][] maze, int[] start, int[] destination) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, 1, 0, -1};
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        visited[start[0]][start[1]] = true;
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            for (int i = 0; i < dx.length; i++) {
                int newX = pos[0] + dx[i], newY = pos[1] + dy[i];
                while (newX >= 0 && newX < maze.length && newY >= 0 && newY < maze[0].length && maze[newX][newY] == 0) {
                    newX += dx[i];
                    newY += dy[i];
                }
                newX -= dx[i];
                newY -= dy[i];
                if (newX == destination[0] && newY == destination[1]) {
                    return true;
                }
                if (!visited[newX][newY]) {
                    queue.offer(new int[]{newX, newY});
                    visited[newX][newY] = true;
                }
            }
        }
        return false;
    }


    /**
     * DFS
     * Recursion
     */
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        return backtracking2(maze, visited, start[0], start[1], destination[0], destination[1]);
    }

    public boolean backtracking2(int[][] maze, boolean[][] visited, int x, int y, int destinationX, int destinationY) {
        if (x == destinationX && y == destinationY) {
            return true;
        }
        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, 1, 0, -1};
        for (int i = 0; i < dx.length; i++) {
            int newX = x + dx[i], newY = y + dy[i];
            while (newX >= 0 && newX < maze.length && newY >= 0 && newY < maze[0].length && maze[newX][newY] == 0) {
                newX += dx[i];
                newY += dy[i];
            }
            newX -= dx[i];
            newY -= dy[i];
            if (!visited[newX][newY]) {
                visited[newX][newY] = true;
                if (backtracking2(maze, visited, newX, newY, destinationX, destinationY)) {
                    return true;
                }
            }
        }
        return false;
    }
}
