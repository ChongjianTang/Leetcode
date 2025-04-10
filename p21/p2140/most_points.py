from typing import List


class Solution:
    """
    Apr 01, 2025 15:59
    DP
    Time Complexity: O(n)
    Space Complexity: O(n)
    """

    def mostPoints(self, questions: List[List[int]]) -> int:
        n = len(questions)
        dp = [0] * (n + 1)
        for i in range(n - 1, -1, -1):
            if questions[i][1] + i + 1 > n:
                dp[i] = max(questions[i][0], dp[i + 1])
            else:
                dp[i] = max(questions[i][0] + dp[questions[i][1] + i + 1], dp[i + 1])
        return dp[0]


class Solution2:
    """
    Apr 01, 2025 15:49
    DP
    Time Complexity: O(n)
    Space Complexity: O(n)
    """

    def mostPoints(self, questions: List[List[int]]) -> int:
        n = len(questions)
        dp = [0] * n
        curr = 0

        max_points = 0
        for i in range(n):
            next_start = i + questions[i][1] + 1
            curr = max(curr, dp[i])
            max_points = max(max_points, curr + questions[i][0])
            if next_start < n:
                dp[next_start] = max(dp[next_start], curr + questions[i][0])

        return max_points


class Solution1:
    """
    TLE
    """

    def mostPoints(self, questions: List[List[int]]) -> int:
        n = len(questions)
        dp = [0] * n
        dp[0] = questions[0][0]

        for i in range(1, n):
            temp = 0
            for j in range(0, i - 1):
                if j + questions[j][1] < i:
                    temp = max(temp, dp[j])

            dp[i] = temp + questions[i][0]

        return max(dp)


if __name__ == '__main__':
    obj = Solution()
    questions = [[3, 2], [4, 3], [4, 4], [2, 5]]
    print(obj.mostPoints(questions))
