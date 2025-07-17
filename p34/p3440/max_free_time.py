"""
You are given an integer eventTime denoting the duration of an event. You are also given two integer arrays startTime and endTime, each of length n.

These represent the start and end times of n non-overlapping meetings that occur during the event between time t = 0 and time t = eventTime, where the ith meeting occurs during the time [startTime[i], endTime[i]].

You can reschedule at most one meeting by moving its start time while maintaining the same duration, such that the meetings remain non-overlapping, to maximize the longest continuous period of free time during the event.

Return the maximum amount of free time possible after rearranging the meetings.

Note that the meetings can not be rescheduled to a time outside the event and they should remain non-overlapping.

Note: In this version, it is valid for the relative ordering of the meetings to change after rescheduling one meeting.



Example 1:

Input: eventTime = 5, startTime = [1,3], endTime = [2,5]

Output: 2

Explanation:



Reschedule the meeting at [1, 2] to [2, 3], leaving no meetings during the time [0, 2].

Example 2:

Input: eventTime = 10, startTime = [0,7,9], endTime = [1,8,10]

Output: 7

Explanation:



Reschedule the meeting at [0, 1] to [8, 9], leaving no meetings during the time [0, 7].

Example 3:

Input: eventTime = 10, startTime = [0,3,7,9], endTime = [1,4,8,10]

Output: 6

Explanation:



Reschedule the meeting at [3, 4] to [8, 9], leaving no meetings during the time [1, 7].

Example 4:

Input: eventTime = 5, startTime = [0,1,2,3,4], endTime = [1,2,3,4,5]

Output: 0

Explanation:

There is no time during the event not occupied by meetings.



Constraints:

1 <= eventTime <= 109
n == startTime.length == endTime.length
2 <= n <= 105
0 <= startTime[i] < endTime[i] <= eventTime
endTime[i] <= startTime[i + 1] where i lies in the range [0, n - 2].
"""
from typing import List


class Solution:
    """
    Jul 10, 2025 12:19
    Time Complexity: O(n)
    Space Complexity; O(1)
    """

    def maxFreeTime(self, eventTime: int, startTime: List[int], endTime: List[int]) -> int:
        longest_free_times = []
        result = 0
        for i in range(len(startTime)):
            if i == 0:
                prev_free_time = startTime[i]
                next_free_time = startTime[i + 1] - endTime[i]
            elif i == len(startTime) - 1:
                prev_free_time = startTime[i] - endTime[i - 1]
                next_free_time = eventTime - endTime[i]
            else:
                prev_free_time = startTime[i] - endTime[i - 1]
                next_free_time = startTime[i + 1] - endTime[i]
            curr_free_time = prev_free_time
            result = max(result, prev_free_time + next_free_time)

            for j in range(len(longest_free_times)):
                if longest_free_times[j] == 0:
                    time = startTime[0]
                elif longest_free_times[j] == len(startTime):
                    time = eventTime - endTime[-1]
                else:
                    time = startTime[longest_free_times[j]] - endTime[longest_free_times[j] - 1]
                if curr_free_time > time:
                    i, longest_free_times[j] = longest_free_times[j], i
                    time, curr_free_time = curr_free_time, time

            if len(longest_free_times) < 3:
                longest_free_times.append(i)

        curr_free_time = eventTime - endTime[-1]
        index = len(startTime)
        for j in range(len(longest_free_times)):
            if longest_free_times[j] == 0:
                time = startTime[0]
            elif longest_free_times[j] == len(startTime):
                time = eventTime - endTime[-1]
            else:
                time = startTime[longest_free_times[j]] - endTime[longest_free_times[j] - 1]
            if curr_free_time > time:
                index, longest_free_times[j] = longest_free_times[j], index
                time, curr_free_time = curr_free_time, time

        if len(longest_free_times) < 3:
            longest_free_times.append(index)

        for i in range(len(startTime)):
            if i == 0:
                prev_free_time = startTime[i]
                next_free_time = startTime[i + 1] - endTime[i]
            elif i == len(startTime) - 1:
                prev_free_time = startTime[i] - endTime[i - 1]
                next_free_time = eventTime - endTime[i]
            else:
                prev_free_time = startTime[i] - endTime[i - 1]
                next_free_time = startTime[i + 1] - endTime[i]
            for j in longest_free_times:
                if j == 0:
                    time = startTime[0]
                elif j == len(startTime):
                    time = eventTime - endTime[-1]
                else:
                    time = startTime[j] - endTime[j - 1]
                if j != i and j != i + 1 and endTime[i] - startTime[i] <= time:
                    result = max(result, prev_free_time + next_free_time + endTime[i] - startTime[i])
                    break

        return result


class Solution1:
    """
    TLE
    """

    def maxFreeTime(self, eventTime: int, startTime: List[int], endTime: List[int]) -> int:
        events = []
        free_times = [startTime[0]]
        for i in range(len(startTime)):
            events.append(endTime[i] - startTime[i])

        for i in range(1, len(startTime)):
            free_times.append(startTime[i] - endTime[i - 1])

        free_times.append(eventTime - endTime[-1])

        sorted_free_time_index = [i for i in range(len(free_times))]

        sorted_free_time_index.sort(key=lambda x: -free_times[x])

        result = 0
        for i in range(len(events)):
            result = max(result, free_times[i] + free_times[i + 1])
            for j in sorted_free_time_index:
                if j != i and j != i + 1 and free_times[j] >= events[i]:
                    result = max(result, free_times[i] + free_times[i + 1] + events[i])
                    break
        return result


if __name__ == '__main__':
    obj = Solution()

    eventTime = 330
    startTime = [213, 276, 320, 322]
    endTime = [223, 283, 322, 327]
    print(obj.maxFreeTime(eventTime, startTime, endTime))

    eventTime = 20
    startTime = [2, 4, 6, 9, 18]
    endTime = [4, 6, 9, 16, 20]
    print(obj.maxFreeTime(eventTime, startTime, endTime))

    eventTime = 5
    startTime = [0, 1, 2, 3, 4]
    endTime = [1, 2, 3, 4, 5]
    print(obj.maxFreeTime(eventTime, startTime, endTime))

    eventTime = 10
    startTime = [0, 3, 7, 9]
    endTime = [1, 4, 8, 10]
    print(obj.maxFreeTime(eventTime, startTime, endTime))

    eventTime = 10
    startTime = [0, 7, 9]
    endTime = [1, 8, 10]
    print(obj.maxFreeTime(eventTime, startTime, endTime))

    eventTime = 5
    startTime = [1, 3]
    endTime = [2, 5]
    print(obj.maxFreeTime(eventTime, startTime, endTime))
