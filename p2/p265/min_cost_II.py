from typing import List


class Solution:
    """
    Oct 30, 2024 13:35
    DP
    Time Complexity: O(m*n^2)
    Space Complexity: O(mn)
    """

    def minCostII(self, costs: List[List[int]]) -> int:
        m = len(costs)
        n = len(costs[0])
        dp = [[0] * n for _ in range(m)]
        dp[0] = costs[0]
        for i in range(1, m, 1):
            for j in range(n):
                dp[i][j] = float('inf')
                for k in range(n):
                    if j != k:
                        dp[i][j] = min(dp[i][j], dp[i - 1][k] + costs[i][j])

        return min(dp[-1])


class Solution1:
    """
    Nov 03, 2024 17:35
    Time Complexity: O(nk)
    Space Complexity: O(1)
    """

    def minCostII(self, costs: List[List[int]]) -> int:
        m = len(costs)
        n = len(costs[0])

        min1 = min2 = -1
        for i in range(n):
            if min1 == -1 or costs[0][i] < costs[0][min1]:
                min2 = min1
                min1 = i
            elif min2 == -1 or costs[0][i] < costs[0][min2]:
                min2 = i

        for i in range(1, m):
            next_min1 = next_min2 = -1
            for j in range(n):
                if j == min1:
                    costs[i][j] += costs[i - 1][min2]
                else:
                    costs[i][j] += costs[i - 1][min1]

                if next_min1 == -1 or costs[i][j] < costs[i][next_min1]:
                    next_min2 = next_min1
                    next_min1 = j
                elif next_min2 == -1 or costs[i][j] < costs[i][next_min2]:
                    next_min2 = j

            min1 = next_min1
            min2 = next_min2

        return costs[-1][min1]

    def minCostII_test(self, costs: List[List[int]]) -> int:
        m = len(costs)
        n = len(costs[0])
        dp = [[0] * n for _ in range(m)]
        # 记录路径
        path = [[-1] * n for _ in range(m)]

        # 初始化第一行
        dp[0] = costs[0].copy()
        min_cost = min(dp[0])
        min_idx = dp[0].index(min_cost)

        # 处理后续行
        for i in range(1, m):
            for j in range(n):
                dp[i][j] = float('inf')
                for k in range(n):
                    if j != k:
                        cost = dp[i - 1][k] + costs[i][j]
                        if cost < dp[i][j]:
                            dp[i][j] = cost
                            path[i][j] = k  # 记录这个位置是从上一行的哪个k转移来的

            min_cost = min(dp[i])
            min_idx = dp[i].index(min_cost)

        # 找出最优路径
        final_cost = min(dp[-1])
        curr_pos = dp[-1].index(final_cost)
        final_path = [curr_pos]

        for i in range(m - 1, 0, -1):
            curr_pos = path[i][curr_pos]
            final_path.append(curr_pos)

        # 添加第一行的选择
        final_path.append(dp[0].index(min(dp[0])))
        final_path.reverse()

        return final_cost


if __name__ == '__main__':
    s = Solution1()

    costs = [
        [3, 20, 7, 8, 11],
        [1, 12, 2, 2, 2],
        [14, 17, 15, 10, 9],
    ]
    print(s.minCostII(costs) == s.minCostII_test(costs))
    print(s.minCostII(costs))
    print(s.minCostII_test(costs))

    costs = [[1, 5, 3], [2, 9, 4]]
    print(s.minCostII(costs) == 5)

    costs = [
        [15, 17, 15, 20, 7, 16, 6, 10, 4, 20, 7, 3, 4],
        [11, 3, 9, 13, 7, 12, 6, 7, 5, 1, 7, 18, 9]
    ]
    print(s.minCostII(costs) == 4)

    costs = [
        [19, 3, 18, 4, 13, 1, 12, 6, 3, 12, 3, 3, 9],
        [11, 5, 9, 16, 2, 19, 15, 10, 13, 20, 15, 2, 13],
        [19, 6, 18, 7, 6, 10, 11, 13, 8, 19, 4, 14, 18],
        [3, 18, 18, 9, 3, 6, 18, 11, 7, 4, 13, 3, 12]
    ]

    print(s.minCostII(costs) == 10)

    costs = [
        [4, 16],
        [15, 5],
        [18, 17],
        [10, 12],
        [14, 10],
        [3, 10],
        [2, 11],
        [18, 14],
        [9, 1],
        [14, 13]
    ]
    print(s.minCostII(costs) == 101)

    path = [[-1, -1, -1, -1, -1], [3, 3, 3, 1, 3], [3, 0, 0, 0, 0], [2, 0, 0, 0, 0], [1, 2, 1, 1, 1], [3, 3, 3, 0, 3],
            [4, 4, 4, 4, 3], [1, 0, 1, 1, 1], [4, 4, 4, 4, 1], [2, 2, 0, 2, 2], [3, 0, 0, 0, 0], [2, 2, 3, 2, 2],
            [4, 4, 4, 4, 3], [2, 2, 0, 2, 2], [3, 3, 3, 0, 3], [1, 3, 1, 1, 1], [1, 4, 1, 1, 1], [2, 0, 0, 0, 0],
            [2, 2, 0, 2, 2], [3, 3, 3, 4, 3], [1, 4, 1, 1, 1]]
