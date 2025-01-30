from collections import deque
from typing import List


class Solution:
    """
    Graph DFS
    Jan 04, 2025 17:43
    Time Complexity: O(m*n)
    Space Complexity: O(m*n)
    """

    def orangesRotting(self, grid: List[List[int]]) -> int:
        count = -1
        queue = deque()

        dx = [1, -1, 0, 0]
        dy = [0, 0, 1, -1]
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 2:
                    queue.append((i, j))

        while queue:
            next_queue = deque()
            while queue:
                node = queue.popleft()
                for i in range(len(dx)):
                    next_node = (node[0] + dx[i], node[1] + dy[i])
                    if 0 <= next_node[0] < len(grid) and 0 <= next_node[1] < len(grid[0]) and grid[next_node[0]][
                        next_node[1]] == 1:
                        next_queue.append(next_node)
                        grid[next_node[0]][next_node[1]] = 2

            count += 1

            queue = next_queue

        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 1:
                    return -1

        if count > 0:
            return count
        else:
            return 0
