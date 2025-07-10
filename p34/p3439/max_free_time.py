"""
You are given an integer eventTime denoting the duration of an event, where the event occurs from time t = 0 to time
t = eventTime.

You are also given two integer arrays startTime and endTime, each of length n. These represent the start and end time
of n non-overlapping meetings, where the ith meeting occurs during the time [startTime[i], endTime[i]].

You can reschedule at most k meetings by moving their start time while maintaining the same duration, to maximize
the longest continuous period of free time during the event.

The relative order of all the meetings should stay the same and they should remain non-overlapping.

Return the maximum amount of free time possible after rearranging the meetings.

Note that the meetings can not be rescheduled to a time outside the event.



Example 1:

Input: eventTime = 5, k = 1, startTime = [1,3], endTime = [2,5]

Output: 2

Explanation:



Reschedule the meeting at [1, 2] to [2, 3], leaving no meetings during the time [0, 2].

Example 2:

Input: eventTime = 10, k = 1, startTime = [0,2,9], endTime = [1,4,10]

Output: 6

Explanation:



Reschedule the meeting at [2, 4] to [1, 3], leaving no meetings during the time [3, 9].

Example 3:

Input: eventTime = 5, k = 2, startTime = [0,1,2,3,4], endTime = [1,2,3,4,5]

Output: 0

Explanation:

There is no time during the event not occupied by meetings.



Constraints:

1 <= eventTime <= 109
n == startTime.length == endTime.length
2 <= n <= 105
1 <= k <= n
0 <= startTime[i] < endTime[i] <= eventTime
endTime[i] <= startTime[i + 1] where i lies in the range [0, n - 2].
"""
from typing import List


class Solution:
    """
    Jul 09, 2025 11:40
    Time Complexity: O(n)
    Space Complexity: O(n)
    """

    def maxFreeTime(self, eventTime: int, k: int, startTime: List[int], endTime: List[int]) -> int:
        free_times = []
        if startTime[0] > 0:
            free_times.append(startTime[0])
        for i in range(1, len(startTime)):
            free_times.append(startTime[i] - endTime[i - 1])

        if eventTime - endTime[-1] > 0:
            free_times.append(eventTime - endTime[-1])

        left = 0
        right = 0
        max_free_time = 0
        total = 0
        while right < len(free_times):
            if right - left == k + 1:
                total -= free_times[left]
                left += 1
            total += free_times[right]
            right += 1
            max_free_time = max(total, max_free_time)

        return max_free_time


if __name__ == '__main__':
    obj = Solution()
    eventTime = 21
    k = 1
    startTime = [7, 10, 16]
    endTime = [10, 14, 18]
    print(obj.maxFreeTime(eventTime, k, startTime, endTime))

    eventTime = 10
    k = 1
    startTime = [0, 2, 9]
    endTime = [1, 4, 10]
    print(obj.maxFreeTime(eventTime, k, startTime, endTime))

    eventTime = 5
    k = 1
    startTime = [1, 3]
    endTime = [2, 5]
    print(obj.maxFreeTime(eventTime, k, startTime, endTime))
