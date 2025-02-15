from typing import List


class Solution:
    """
    DFS
    Jan 02, 2025 20:55
    Time Complexity: O(n^2)
    Space Complexity: O(n)
    """

    def findCircleNum(self, isConnected: List[List[int]]) -> int:
        visited = set()
        count = 0

        for i in range(len(isConnected)):
            if i not in visited:
                count += 1
                stack = [i]
                while stack:
                    city = stack.pop()
                    visited.add(city)
                    for index, connection in enumerate(isConnected[city]):
                        if connection == 1 and index != city and index not in visited:
                            stack.append(index)
        return count
