from typing import List


class Solution:
    """
    Mar 20, 2025 18:08
    Union Find
    """
    def minimumCost(self, n: int, edges: List[List[int]], query: List[List[int]]) -> List[int]:
        union_find = UnionFind(n)
        result = []
        for edge in edges:
            union_find.union(edge[0], edge[1], edge[2])

        for single_query in query:
            root1, cost1 = union_find.find(single_query[0])
            root2, cost2 = union_find.find(single_query[1])

            if root1 == root2:
                result.append(-cost1 - 2)
            else:
                result.append(-1)

        return result


class UnionFind:

    def __init__(self, n):
        self.root = [-1] * n

    def find(self, num):
        if self.root[num] == -1:
            return num, -1

        if self.root[num] >= 0:
            root, cost = self.find(self.root[num])
            self.root[num] = root
            return root, cost

        return num, self.root[num]

    def union(self, num1, num2, weight):
        root1, cost1 = self.find(num1)
        root2, cost2 = self.find(num2)

        cost = weight
        if cost1 != -1:
            cost &= -cost1 - 2
        if cost2 != -1:
            cost &= -cost2 - 2

        cost = -cost - 2
        self.root[root2] = root1
        self.root[root1] = cost


if __name__ == '__main__':
    obj = Solution()
    n = 4
    edges = [[3, 1, 9], [1, 2, 12], [2, 1, 11], [2, 3, 6], [2, 1, 11], [3, 2, 7], [2, 0, 8], [2, 3, 11]]
    query = [[1, 3], [2, 0], [1, 0], [3, 2], [0, 3], [0, 2], [2, 0]]
    print(obj.minimumCost(n, edges, query))
