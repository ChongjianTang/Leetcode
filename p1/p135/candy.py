from typing import List


class Solution:
    """
    Jun 02, 2025 14:05
    Time Complexity: O(n)
    Space Complexity: O(1)
    """

    def candy(self, ratings: List[int]) -> int:
        up = 0
        down = 0
        total = 1
        peak = 0

        for i in range(1, len(ratings)):
            if ratings[i] > ratings[i - 1]:
                down = 0
                up += 1
                total += up + 1
                peak = up + 1
            elif ratings[i] < ratings[i - 1]:
                up = 0
                down += 1
                total += down
                if peak <= down:
                    total += 1

            else:
                up = down = peak = 0
                total += 1
        return total


class Solution1:
    """
    Jun 02, 2025 11:29
    Time Complexity: O(n)
    Space Complexity: O(n)
    """

    def candy(self, ratings: List[int]) -> int:
        result = [1 for _ in ratings]
        for i in range(1, len(ratings)):
            if ratings[i] > ratings[i - 1]:
                result[i] = result[i - 1] + 1

        for i in range(len(ratings) - 2, -1, -1):
            if ratings[i] > ratings[i + 1]:
                result[i] = max(result[i + 1] + 1, result[i])

        return sum(result)


if __name__ == '__main__':
    sol = Solution()

    ratings = [1, 3, 2, 2, 1]
    print(sol.candy(ratings))
