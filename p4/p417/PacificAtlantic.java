package leetcode.p4.p417;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PacificAtlantic {
    /**
     * DFS
     */
    public List<List<Integer>> pacificAtlantic1(int[][] heights) {
        boolean[][] toPacific = new boolean[heights.length][heights[0].length];
        boolean[][] toAtlantic = new boolean[heights.length][heights[0].length];

        for (int i = 0; i < heights.length; i++) {
            dfs1(heights, toPacific, i, 0);
            dfs1(heights, toAtlantic, i, heights[0].length - 1);
        }
        for (int i = 0; i < heights[0].length; i++) {
            dfs1(heights, toPacific, 0, i);
            dfs1(heights, toAtlantic, heights.length - 1, i);
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                if (toAtlantic[i][j] && toPacific[i][j]) {
                    List<Integer> coordinate = new ArrayList<>();
                    coordinate.add(i);
                    coordinate.add(j);
                    result.add(coordinate);
                }
            }
        }
        return result;
    }

    public void dfs1(int[][] heights, boolean[][] visited, int x, int y) {
        visited[x][y] = true;
        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, 1, 0, -1};

        for (int i = 0; i < dx.length; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (newX >= 0 && newX < heights.length && newY >= 0 && newY < heights[0].length && !visited[newX][newY] && heights[newX][newY] >= heights[x][y]) {
                dfs1(heights, visited, newX, newY);
            }
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean[][] toPacific = new boolean[heights.length][heights[0].length];
        boolean[][] toAtlantic = new boolean[heights.length][heights[0].length];

        for (int i = 0; i < heights.length; i++) {
            bfs1(heights, toPacific, i, 0);
            bfs1(heights, toAtlantic, i, heights[0].length - 1);
        }
        for (int i = 0; i < heights[0].length; i++) {
            bfs1(heights, toPacific, 0, i);
            bfs1(heights, toAtlantic, heights.length - 1, i);
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                if (toAtlantic[i][j] && toPacific[i][j]) {
                    List<Integer> coordinate = new ArrayList<>();
                    coordinate.add(i);
                    coordinate.add(j);
                    result.add(coordinate);
                }
            }
        }
        return result;
    }

    public void bfs1(int[][] heights, boolean[][] visited, int x, int y) {
        if (!visited[x][y]) {
            int[] dx = new int[]{1, 0, -1, 0};
            int[] dy = new int[]{0, 1, 0, -1};
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{x, y});
            visited[x][y] = true;
            while (!queue.isEmpty()) {
                int[] pos = queue.poll();
                for (int i = 0; i < dx.length; i++) {
                    int newX = pos[0] + dx[i];
                    int newY = pos[1] + dy[i];
                    if (newX >= 0 && newX < heights.length && newY >= 0 && newY < heights[0].length && !visited[newX][newY] && heights[newX][newY] >= heights[pos[0]][pos[1]]) {
                        queue.add(new int[]{newX, newY});
                        visited[newX][newY] = true;
                    }
                }
            }
        }
    }
}
