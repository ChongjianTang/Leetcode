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
    def minCostII(self, costs: List[List[int]]) -> int:
        m = len(costs)
        n = len(costs[0])

        dp = [[float('inf')] * 2 for _ in range(2)]
        index_dp = [[-1] * 2 for _ in range(2)]

        print("第0行初始状态:")
        for i in range(n):
            if costs[0][i] <= dp[0][0]:
                dp[0][1] = dp[0][0]
                index_dp[0][1] = index_dp[0][0]
                dp[0][0] = costs[0][i]
                index_dp[0][0] = i
            elif costs[0][i] <= dp[0][1]:
                dp[0][1] = costs[0][i]
                index_dp[0][1] = i
        print(f"最小值: {dp[0][0]} (颜色{index_dp[0][0]})")
        print(f"次小值: {dp[0][1]} (颜色{index_dp[0][1]})")

        total_cost = dp[0][0]
        path = [index_dp[0][0]]

        for i in range(1, m, 1):
            print(f"\n处理第{i}行:")
            print(f"当前各颜色成本: {costs[i]}")

            for j in range(n):
                if costs[i][j] <= dp[1][0]:
                    dp[1][1] = dp[1][0]
                    index_dp[1][1] = index_dp[1][0]
                    dp[1][0] = costs[i][j]
                    index_dp[1][0] = j
                elif costs[i][j] <= dp[1][1]:
                    dp[1][1] = costs[i][j]
                    index_dp[1][1] = j

            print(f"本行最小值: {dp[1][0]} (颜色{index_dp[1][0]})")
            print(f"本行次小值: {dp[1][1]} (颜色{index_dp[1][1]})")

            if index_dp[1][0] != index_dp[0][0]:
                if index_dp[1][1] != index_dp[0][0]:
                    old_cost = dp[1][0]
                    dp[1][0] += dp[0][0]
                    index_dp[0][0] = index_dp[1][0]

                    dp[1][1] += dp[0][0]
                    index_dp[0][1] = index_dp[1][1]
                    print(f"选择颜色{index_dp[1][0]}, 成本增加{old_cost}")
                else:
                    old_cost = dp[1][0]
                    dp[1][0] += dp[0][0]
                    index_dp[0][0] = index_dp[1][0]

                    dp[1][1] += dp[0][1]
                    index_dp[0][1] = index_dp[1][1]
                    print(f"选择颜色{index_dp[1][0]}, 成本增加{old_cost}")
            else:
                temp1 = dp[0][0] + dp[1][1]
                index1 = index_dp[1][1]

                temp2 = dp[0][1] + dp[1][0]
                index2 = index_dp[1][0]

                print(f"颜色冲突:")
                print(f"方案1: 颜色{index1}, 总成本{temp1}")
                print(f"方案2: 颜色{index2}, 总成本{temp2}")

                if temp1 < temp2:
                    dp[1][0] = temp1
                    index_dp[0][0] = index1

                    dp[1][1] = temp2
                    index_dp[0][1] = index2
                    print(f"选择方案1: 颜色{index1}")
                else:
                    dp[1][0] = temp2
                    index_dp[0][0] = index2

                    dp[1][1] = temp1
                    index_dp[0][1] = index1
                    print(f"选择方案2: 颜色{index2}")

            path.append(index_dp[0][0])

            dp[0][0] = dp[1][0]
            dp[0][1] = dp[1][1]

            dp[1][0] = float('inf')
            dp[1][1] = float('inf')

            print(f"累计成本: {dp[0][0]}")

        print("\n最终路径:", path)
        return int(dp[0][0])

    def minCostII_test(self, costs: List[List[int]]) -> int:
        m = len(costs)
        n = len(costs[0])
        dp = [[0] * n for _ in range(m)]
        # 记录路径
        path = [[-1] * n for _ in range(m)]

        # 初始化第一行
        dp[0] = costs[0].copy()
        print(f"第0行dp: {dp[0]}")
        min_cost = min(dp[0])
        min_idx = dp[0].index(min_cost)
        print(f"当前最小成本: {min_cost}, 位置: {min_idx}")

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

            print(f"\n第{i}行dp: {dp[i]}")
            min_cost = min(dp[i])
            min_idx = dp[i].index(min_cost)
            print(f"当前最小成本: {min_cost}, 位置: {min_idx}")

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

        print("\n最终结果:")
        print(f"总成本: {final_cost}")
        print(f"路径: {final_path}")

        return final_cost


if __name__ == '__main__':
    s = Solution1()

    costs = [
        [1, 1, 1, 1, 1],  # 第一行随便选
        [2, 2, 3, 4, 2],  # 关键：有多个相同的最小值2
        [9, 3, 9, 9, 2]  # 最后一行：展示不同选择导致的结果差异
    ]
    print(s.minCostII_test(costs) == s.minCostII(costs))


    costs = [
        [20, 7, 7, 5, 12],
        [3, 19, 9, 4, 15],
        [2, 16, 8, 17, 15],
        [7, 3, 8, 11, 13],
        [3, 14, 19, 2, 17],

        [11, 19, 17, 6, 1],
        [4, 2, 11, 12, 6],
        [9, 2, 9, 15, 1],
        [5, 7, 3, 20, 14],
        [3, 20, 7, 8, 11],

        [1, 12, 2, 2, 2],
        [14, 17, 15, 10, 9],
        [10, 12, 9, 19, 20],
        [4, 6, 10, 3, 10],
        [7, 3, 10, 4, 12],

        [7, 2, 8, 6, 4],
        [3, 10, 5, 9, 10],
        [7, 12, 1, 12, 12],
        [20, 17, 19, 1, 10],
        [13, 2, 7, 20, 2],
        [13, 8, 18, 13, 2]
    ]
    print(s.minCostII(costs) == 67)
    print(s.minCostII_test(costs) == 67)


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
