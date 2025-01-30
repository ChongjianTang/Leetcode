from typing import List


class Solution:
    """
    DFS
    Jan 04, 2025 14:43
    Time Complexity: O(E+V)
    Space Complexity: O(E)
    """

    def calcEquation(self, equations: List[List[str]], values: List[float], queries: List[List[str]]) -> List[float]:
        graph = {}
        for i, equation in enumerate(equations):
            if equation[0] not in graph:
                graph[equation[0]] = {}
            graph[equation[0]][equation[1]] = values[i]

            if equation[1] not in graph:
                graph[equation[1]] = {}
            graph[equation[1]][equation[0]] = 1 / values[i]

        results = []
        for query in queries:
            if query[0] not in graph or query[1] not in graph:
                results.append(-1)
                continue
            visited = set()
            stack = [(query[0], 1)]
            result = -1
            while stack:
                node, val = stack.pop()
                if node == query[1]:
                    result = val
                    break

                visited.add(node)
                for next in graph[node]:
                    if next not in visited:
                        stack.append((next, val * graph[node][next]))
            results.append(result)

        return results