package leetcode.p6.p695;

public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs1(grid, i, j);
                    if (area > max) {
                        max = area;
                    }
                }
            }
        }
        return max;
    }

    public int dfs1(int[][] grid, int x, int y) {
        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, 1, 0, -1};
        if (grid[x][y] == 0) {
            return 0;
        }
        grid[x][y] = 0;
        int area = 1;
        for (int i = 0; i < dx.length; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length && grid[newX][newY] == 1) {
                area += dfs1(grid, newX, newY);
            }
        }
        return area;
    }
}
