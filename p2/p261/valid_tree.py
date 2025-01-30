from typing import List


class Solution:
    def validTree(self, n: int, edges: List[List[int]]) -> bool:
        if len(edges) != n - 1:
            return False
        if n == 1:
            return True
        graph_map = {}
        for edge in edges:
            if edge[0] not in graph_map:
                graph_map[edge[0]] = set()
            graph_map[edge[0]].add(edge[1])

            if edge[1] not in graph_map:
                graph_map[edge[1]] = set()
            graph_map[edge[1]].add(edge[0])

        visited = set()

        stack = [edges[0][0]]
        while stack:
            node = stack.pop()
            visited.add(node)

            for next_node in graph_map[node]:
                if next_node not in visited:
                    stack.append(next_node)

        if len(visited) != n:
            return False

        return True


if __name__ == '__main__':
    sol = Solution()
    print(sol.validTree(5, [[0, 1], [0, 2], [0, 3], [1, 4]]))
