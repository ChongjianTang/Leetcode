package leetcode.p3.p317;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistance {
    /**
     * BFS
     * TLE  //TODO
     */
    public int shortestDistance(int[][] grid) {
        int min = Integer.MAX_VALUE;
        int numOfBuildings = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    numOfBuildings++;
                }
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    int distance = bfs1(grid, i, j, numOfBuildings, min);
                    if (distance != -1) {
                        min = Math.min(min, distance);
                    }
                }
            }
        }
        if (min == Integer.MAX_VALUE) {
            return -1;
        }
        return min;
    }

    public static int bfs1(int[][] grid, int x, int y, int numOfBuildings, int minimumDistance) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, 1, 0, -1};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        int distance = 0;
        int level = 1;
        while (!queue.isEmpty()) {
            Queue<int[]> nextQueue = new LinkedList<>();
            while (!queue.isEmpty()) {
                int[] pos = queue.poll();
                for (int i = 0; i < dx.length; i++) {
                    int newX = pos[0] + dx[i];
                    int newY = pos[1] + dy[i];
                    if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length && !visited[newX][newY]) {
                        if (grid[newX][newY] == 1) {
                            distance += level;
                            if (distance > minimumDistance) {
                                return distance;
                            }
                            numOfBuildings--;
                            if (numOfBuildings == 0) {
                                return distance;
                            }
                        } else if (grid[newX][newY] == 0) {
                            nextQueue.offer(new int[]{newX, newY});
                        }
                        visited[newX][newY] = true;
                    }
                }
            }
            queue = nextQueue;
            level++;
        }
        if (numOfBuildings != 0) {
            return -1;
        } else {
            return distance;
        }
    }
}
