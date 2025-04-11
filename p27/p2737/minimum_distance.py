import heapq
from typing import List


class Solution:
    """
    Mar 24, 2025 12:06
    """

    def minimumDistance(self, n: int, edges: List[List[int]], s: int, marked: List[int]) -> int:
        graph = [[] for _ in range(n)]
        for edge in edges:
            graph[edge[0]].append([edge[1], edge[2]])

        pq = [(0, s)]
        marked_set = set(marked)

        visited = set()

        while pq:
            distance, curr_node = heapq.heappop(pq)
            visited.add(curr_node)
            if curr_node in marked_set:
                return distance

            for next_node, edge_distance in graph[curr_node]:
                if next_node not in visited:
                    heapq.heappush(pq, (distance + edge_distance, next_node))

        return -1
