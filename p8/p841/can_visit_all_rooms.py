from typing import List


class Solution:
    """
    DFS
    Jan 02, 2025 20:44
    Time Complexity: O(n+e)
    Space Complexity: O(n)
    """
    def canVisitAllRooms(self, rooms: List[List[int]]) -> bool:
        stack = [0]

        visited = set()
        while stack:
            room = stack.pop()
            visited.add(room)

            keys = rooms[room]
            for key in keys:
                if key not in visited:
                    stack.append(key)

        return len(visited) == len(rooms)
