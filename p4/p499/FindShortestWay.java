package leetcode.p4.p499;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FindShortestWay {
    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(ball);
        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, 1, 0, -1};
        int[][] distance = new int[maze.length][maze[0].length];
        for (int i = 0; i < maze.length; i++) {
            Arrays.fill(distance[i], -1);
        }
        distance[ball[0]][ball[1]] = 0;
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
                    if (newX != hole[0] || newY != hole[1]) {
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
//        return distance[hole[0]][hole[1]];
        return null;
    }
}
