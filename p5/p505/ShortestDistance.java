package leetcode.p5.p505;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistance {
    /**
     * BFS
     * it is important that there may be some paths is better than previous one so we need to update the distance matrix
     * and push these nodes into queue again.
     * Here is an example!
     * S - n
     * |   |
     * |   n - n
     * |       |
     * |       n - E
     * |           |
     * |           |
     * |           |
     * n - - - - - n
     * There are two path from S to E.
     * The first one is at level 4 and its length is 8 + 6 + 4 = 18
     * The second one is at level6 and its length is 2 + 2 + 2 + 2 + 2 = 10
     */
    public int shortestDistance1(int[][] maze, int[] start, int[] destination) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, 1, 0, -1};
        int[][] distance = new int[maze.length][maze[0].length];
        for (int i = 0; i < maze.length; i++) {
            Arrays.fill(distance[i], -1);
        }
        distance[start[0]][start[1]] = 0;
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            for (int i = 0; i < dx.length; i++) {
                int newX = pos[0] + dx[i], newY = pos[1] + dy[i];
                int step = distance[pos[0]][pos[1]];
                while (newX >= 0 && newX < maze.length && newY >= 0 && newY < maze[0].length && maze[newX][newY] == 0) {
                    newX += dx[i];
                    newY += dy[i];
                    step++;
                }
                newX -= dx[i];
                newY -= dy[i];
                if (distance[newX][newY] == -1) {
                    distance[newX][newY] = step;
                    if (newX != destination[0] || newY != destination[1]) {
                        queue.offer(new int[]{newX, newY});
                    }
                } else {
                    if (step < distance[newX][newY]) {
                        distance[newX][newY] = step;
                        queue.offer(new int[]{newX, newY});
                    }
                }
            }
        }
        return distance[destination[0]][destination[1]];
    }

    /**
     * DFS
     */
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        return 0;
        // TODO and the dijkstra one
    }
}
