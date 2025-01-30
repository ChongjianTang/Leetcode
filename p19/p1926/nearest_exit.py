from collections import deque
from typing import List


class Solution:
    """
    Graph DFS
    Jan 04, 2025 15:53
    Time Complexity: O(n*m)
    Space Complexity: O(m+n)
    """

    def nearestExit(self, maze: List[List[str]], entrance: List[int]) -> int:
        queue = deque()
        queue.append(entrance)
        visited = set()
        visited.add(tuple(entrance))
        count = 0
        moves = [[1, 0], [0, 1], [-1, 0], [0, -1]]
        while queue:
            next_queue = deque()
            while queue:
                node = queue.popleft()
                if (node[0] == 0 or node[0] == len(maze) - 1) or (node[1] == 0 or node[1] == len(maze[0]) - 1):
                    if node != entrance:
                        return count

                for move in moves:
                    next_node = [node[0] + move[0], node[1] + move[1]]
                    if 0 <= next_node[0] < len(maze) and 0 <= next_node[1] < len(
                            maze[0]) and tuple(next_node) not in visited and maze[next_node[0]][next_node[1]] == '.':
                        next_queue.append(next_node)
                        visited.add(tuple(next_node))

            count += 1
            queue = next_queue

        return -1


if __name__ == '__main__':
    sol = Solution()
    maze = [["+", "+", ".", "+"], [".", ".", ".", "+"], ["+", "+", "+", "."]]
    entrance = [1, 2]
    print(sol.nearestExit(maze, entrance))
