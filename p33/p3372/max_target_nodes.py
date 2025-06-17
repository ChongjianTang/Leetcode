from collections import deque
from typing import List, Set, Dict


class Solution:
    """
    May 28, 2025 18:51
    Time Complexity: O(v1^2+v2^2)
    Space Complexity: O(v1+v2)
    """

    def maxTargetNodes(self, edges1: List[List[int]], edges2: List[List[int]], k: int) -> List[int]:
        tree_dict1 = {}
        for edge in edges1:
            if edge[0] not in tree_dict1:
                tree_dict1[edge[0]] = set()
            if edge[1] not in tree_dict1:
                tree_dict1[edge[1]] = set()
            tree_dict1[edge[0]].add(edge[1])
            tree_dict1[edge[1]].add(edge[0])

        tree_dict2 = {}
        for edge in edges2:
            if edge[0] not in tree_dict2:
                tree_dict2[edge[0]] = set()
            if edge[1] not in tree_dict2:
                tree_dict2[edge[1]] = set()
            tree_dict2[edge[0]].add(edge[1])
            tree_dict2[edge[1]].add(edge[0])

        if k == 0:
            return [1 for _ in range(len(tree_dict1))]

        result = self.find_target_node(tree_dict1, k)
        extra = self.find_target_node(tree_dict2, k - 1)

        result = [i + max(extra) for i in result]
        return result

    def find_target_node(self, tree_dict: Dict[int, Set[int]], k: int):
        result = [0 for _ in range(len(tree_dict))]
        visited = set()
        for root_node in tree_dict:
            visited.clear()
            queue = deque()
            queue.append(root_node)
            visited.add(root_node)
            i = 0
            while i < k:
                next_queue = deque()
                while queue:
                    node = queue.popleft()
                    for next_node in tree_dict[node]:
                        if next_node not in visited:
                            next_queue.append(next_node)
                            visited.add(next_node)

                queue = next_queue
                i += 1

            result[root_node] = len(visited)

        return result


if __name__ == '__main__':
    sol = Solution()
    edges1 = [[0, 1], [0, 2], [2, 3], [2, 4]]
    edges2 = [[0, 1], [0, 2], [0, 3], [2, 7], [1, 4], [4, 5], [4, 6]]
    k = 2
    print(sol.maxTargetNodes(edges1, edges2, k))
