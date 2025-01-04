from typing import List, Dict


class Solution:
    """
    DFS
    Jan 03, 2025 16:17
    Time Complexity: O(n)
    Space Complexity: O(n)
    """

    def minReorder(self, n: int, connections: List[List[int]]) -> int:
        stack = [0]

        count = 0

        visited = set()

        cities_map = {}
        for connection in connections:
            from_city = connection[0]
            to_city = connection[1]
            if from_city not in cities_map:
                cities_map[from_city] = {}
            if to_city not in cities_map:
                cities_map[to_city] = {}

            cities_map[from_city][to_city] = 1
            cities_map[to_city][from_city] = -1

        while stack:
            current_city = stack.pop()
            visited.add(current_city)
            for city in cities_map[current_city]:
                if city not in visited:
                    if cities_map[current_city][city] == 1:
                        count += 1
                    stack.append(city)

        return count


if __name__ == '__main__':
    sol = Solution()
    n = 6
    connections = [[0, 1], [1, 3], [2, 3], [4, 0], [4, 5]]
    print(sol.minReorder(n, connections))
