"""
You are given an array of events where events[i] = [startDayi, endDayi, valuei]. The ith event starts at startDayi and
ends at endDayi, and if you attend this event, you will receive a value of valuei. You are also given an integer k which
represents the maximum number of events you can attend.

You can only attend one event at a time. If you choose to attend an event, you must attend the entire event. Note that
the end day is inclusive: that is, you cannot attend two events where one of them starts and the other ends on the same
day.

Return the maximum sum of values that you can receive by attending events.



Example 1:



Input: events = [[1,2,4],[3,4,3],[2,3,1]], k = 2
Output: 7
Explanation: Choose the green events, 0 and 1 (0-indexed) for a total value of 4 + 3 = 7.
Example 2:



Input: events = [[1,2,4],[3,4,3],[2,3,10]], k = 2
Output: 10
Explanation: Choose event 2 for a total value of 10.
Notice that you cannot attend any other event as they overlap, and that you do not have to attend k events.
Example 3:



Input: events = [[1,1,1],[2,2,2],[3,3,3],[4,4,4]], k = 3
Output: 9
Explanation: Although the events do not overlap, you can only attend 3 events. Pick the highest valued three.


Constraints:

1 <= k <= events.length
1 <= k * events.length <= 106
1 <= startDayi <= endDayi <= 109
1 <= valuei <= 106
"""
from typing import List


# TODO: Check this problem
class Solution:
    """
    Jul 08, 2025 15:36
    DP
    Time Complexity: O(nklogn)
    Space Complexity: O(nk)
    """

    def maxValue(self, events: List[List[int]], k: int) -> int:
        sorted_events = sorted(events, key=lambda x: x[1])
        dp = [[0 for _ in range(k + 1)] for _ in range(len(events))]
        dp[0][0] = 0
        for i in range(1, k + 1):
            dp[0][i] = sorted_events[0][2]

        for i in range(len(sorted_events)):
            dp[i][0] = 0

        for i in range(1, len(sorted_events)):
            for j in range(1, k + 1):
                prev = self.binary_search(sorted_events, sorted_events[i][0])
                if prev == -1:
                    dp[i][j] = max(dp[i - 1][j], sorted_events[i][2])
                else:
                    dp[i][j] = max(dp[i - 1][j], dp[prev][j - 1] + sorted_events[i][2])

        return dp[-1][k]

    def binary_search(self, sorted_events: List[List[int]], start_time: int) -> int:
        left = -1
        right = len(sorted_events)

        while left + 1 < right:
            mid = (left + right) // 2
            if sorted_events[mid][1] < start_time:
                left = mid
            else:
                right = mid

        return left


if __name__ == '__main__':
    obj = Solution()
    events = [[1, 1, 1], [2, 2, 2], [3, 3, 3], [4, 4, 4]]
    k = 3
    print(obj.maxValue(events, k))

    events = [[1, 2, 4], [3, 4, 3], [2, 3, 10]]
    k = 2
    print(obj.maxValue(events, k))

    events = [[1, 2, 4], [3, 4, 3], [2, 3, 1]]
    k = 2
    print(obj.maxValue(events, k))
