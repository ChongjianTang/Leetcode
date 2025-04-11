from typing import List


class Solution:
    """
    Mar 24, 2025 13:53
    """
    def countCompleteComponents(self, n: int, edges: List[List[int]]) -> int:
        union_find = UnionFind(n)
        for edge in edges:
            union_find.union(edge[0], edge[1])

        return union_find.get_count()

class UnionFind:
    def __init__(self, n):
        self.parent = [i for i in range(n)]
        self.info = [[1, 0] for _ in range(n)]
        self.count = n

    def find(self, i):
        if self.parent[i] != i:
            self.parent[i] = self.find(self.parent[i])

        return self.parent[i]

    def union(self, x, y):
        root_x = self.find(x)
        root_y = self.find(y)
        if root_x == root_y:
            self.info[root_x][1] += 1
            return

        self.parent[root_y] = root_x
        self.info[root_x][0] += self.info[root_y][0]
        self.info[root_x][1] += (self.info[root_y][1] + 1)
        self.info[root_y] = [-1, -1]

    def get_count(self):
        count = 0
        for i in range(len(self.info)):
            info = self.info[i]
            if info[0] != -1 and info[1] == (info[0] * (info[0] - 1)) // 2:
                count += 1

        return count


if __name__ == '__main__':
    obj = Solution()
    edges = [[0, 1], [0, 2], [1, 2], [3, 4], [3, 5]]
    print(obj.countCompleteComponents(6, edges))
