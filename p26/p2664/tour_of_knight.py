from typing import List


class Solution:
    """
    Oct 28, 2024 13:15
    Time Complexity: O(8^mn)
    Space Complexity: O(mn)
    """
    def tourOfKnight(self, m: int, n: int, r: int, c: int) -> List[List[int]]:
        if m == 1 and n == 1 and r == 0 and c == 0:
            return [[0]]
        broad = [[-1] * n for _ in range(m)]
        broad[r][c] = 0
        _, result = self.dfs(broad, r, c, 1)
        return result

    def dfs(self, broad: List[List[int]], x: int, y: int, count: int) -> (bool, List[List[int]]):
        if count == len(broad) * len(broad[0]):
            return True, broad
        next_moves = [[1, 2], [-1, 2], [-1, -2], [1, -2], [2, 1], [-2, 1], [-2, -1], [2, -1]]
        for next_move in next_moves:
            new_x = x + next_move[0]
            new_y = y + next_move[1]
            if 0 <= new_x < len(broad) and 0 <= new_y < len(broad[0]) and broad[new_x][new_y] == -1:
                broad[new_x][new_y] = count
                found_result, result = self.dfs(broad, new_x, new_y, count + 1)
                if found_result:
                    return True, result

                broad[new_x][new_y] = -1

        return False, broad


if __name__ == '__main__':
    s = Solution()
    print(s.tourOfKnight(1, 1, 0, 0) == [[0]])
