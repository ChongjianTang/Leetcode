import heapq
from typing import List


class Solution:
    """
    Mar 23, 2025 17:00
    """
    def countPaths(self, n: int, roads: List[List[int]]) -> int:
        if n == 1:
            return 1
        costs = [-1] * n
        ways = [1] * n
        MOD = 10 ** 9 + 7

        graph = [[] for _ in range(n)]
        for u, v, edge_cost in roads:
            graph[u].append([v, edge_cost])
            graph[v].append([u, edge_cost])

        costs[0] = 0
        ways[0] = 1

        pq = [(0, 0)]

        while pq:
            curr_cost, curr_node = heapq.heappop(pq)
            if curr_cost > costs[curr_node]:
                continue
            for node, edge_cost in graph[curr_node]:
                if costs[node] == -1 or edge_cost + curr_cost < costs[node]:
                    ways[node] = ways[curr_node]
                    costs[node] = curr_cost + edge_cost
                    heapq.heappush(pq, (costs[node], node))
                elif edge_cost + curr_cost == costs[node]:
                    ways[node] = (ways[node] + ways[curr_node]) % MOD

        return ways[n - 1]


if __name__ == '__main__':
    obj = Solution()
    roads = [[0, 1, 1], [1, 2, 4], [0, 4, 3], [3, 2, 5], [3, 4, 1], [3, 0, 5], [1, 3, 1]]
    print(obj.countPaths(5, roads))
