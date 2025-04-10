from collections import deque
from typing import List


class Solution:
    """
    Apr 02, 2025 13:52
    """

    def shortestDistance(self, grid: List[List[int]]) -> int:
        queue_list = []
        visited = {}
        x = [0, 0, 1, -1]
        y = [1, -1, 0, 0]
        n = len(grid)
        m = len(grid[0])
        for i in range(n):
            for j in range(m):
                if grid[i][j] == 1:
                    queue_list.append(deque())
                    queue_list[-1].append((i, j))

        k = len(queue_list)
        count = 0
        flag = True
        min_val = -1
        while flag:
            flag = False
            next_queue_list = []
            count += 1
            for i in range(k):
                queue = queue_list[i]
                next_queue = deque()
                while queue:
                    flag = True
                    node = queue.popleft()

                    for j in range(len(x)):
                        next_node = (node[0] + x[j], node[1] + y[j])
                        if 0 <= next_node[0] < n and 0 <= next_node[1] < m and grid[next_node[0]][next_node[1]] == 0:
                            if next_node not in visited:
                                visited[next_node] = {}

                            if i not in visited[next_node]:
                                visited[next_node][i] = count

                                if len(visited[next_node]) == k:
                                    if min_val == -1:
                                        min_val = sum(visited[next_node].values())
                                    else:
                                        min_val = min(min_val, sum(visited[next_node].values()))

                                next_queue.append(next_node)

                next_queue_list.append(next_queue)
            queue_list = next_queue_list
        return min_val


class Solution1:
    def shortestDistance(self, grid: List[List[int]]) -> int:
        min_distance = float('inf')
        num_of_buildings = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 1:
                    num_of_buildings += 1

        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 0:
                    distance = self.bfs(grid, i, j, num_of_buildings, min_distance)
                    if distance != -1:
                        min_distance = min(min_distance, distance)

        if min_distance == float('inf'):
            return -1
        return min_distance

    def bfs(self, grid, x, y, num_of_buildings, minimum_distance):
        rows, cols = len(grid), len(grid[0])
        visited = [[False for _ in range(cols)] for _ in range(rows)]
        dx = [1, 0, -1, 0]
        dy = [0, 1, 0, -1]

        queue = deque([(x, y)])
        visited[x][y] = True
        distance = 0
        level = 1

        while queue:
            next_queue = deque()
            while queue:
                pos_x, pos_y = queue.popleft()
                for i in range(4):
                    new_x = pos_x + dx[i]
                    new_y = pos_y + dy[i]

                    if 0 <= new_x < rows and 0 <= new_y < cols and not visited[new_x][new_y]:
                        if grid[new_x][new_y] == 1:
                            distance += level
                            if distance > minimum_distance:
                                return distance
                            num_of_buildings -= 1
                            if num_of_buildings == 0:
                                return distance
                        elif grid[new_x][new_y] == 0:
                            next_queue.append((new_x, new_y))
                        visited[new_x][new_y] = True

            queue = next_queue
            level += 1

        if num_of_buildings != 0:
            return -1
        else:
            return distance


if __name__ == '__main__':
    obj = Solution()
    a = [
        [7, 6, 5, 4, 3, 0],
        [0, 0, 0, 0, 0, 3],
        [0, 6, 3, 0, 0, 2],
        [8, 0, 0, 1, 0, 1],
        [7, 0, 3, 0, 0, 2],
        [6, 0, 0, 0, 0, 3],
        [0, 6, 5, 4, 3, 0]
    ]
    grid = [
        [1, 1, 1, 1, 1, 0],
        [0, 0, 0, 0, 0, 1],
        [0, 1, 1, 0, 0, 1],
        [1, 0, 0, 1, 0, 1],
        [1, 0, 1, 0, 0, 1],
        [1, 0, 0, 0, 0, 1],
        [0, 1, 1, 1, 1, 0]
    ]
    print(sum([sum(x) for x in a]))
    print(obj.shortestDistance(grid))
