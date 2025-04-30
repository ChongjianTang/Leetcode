from typing import List


class Solution:
    """
    Mar 26, 2025 14:12
    """
    def minOperations(self, grid: List[List[int]], x: int) -> int:
        n = len(grid)
        m = len(grid[0])

        pivot = grid[0][0]
        delta_list = []
        for i in range(n):
            for j in range(m):
                if (grid[i][j] - pivot) % x != 0:
                    return -1
                delta_list.append((grid[i][j] - pivot) // x)

        delta_list.sort()
        median = delta_list[len(delta_list) // 2]

        result_list = [abs(x - median) for x in delta_list]
        return sum(result_list)


if __name__ == '__main__':
    obj = Solution()
    grid = [[2, 4], [6, 8]]
    print(obj.minOperations(grid, 2))
