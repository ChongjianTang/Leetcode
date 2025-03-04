import heapq
from typing import List


class Solution:
    """
    Mar 02, 2025 22:06
    Time Complexity: O(nlogn)
    Space Complexity: O(n)
    """

    def canAttendMeetings(self, intervals: List[List[int]]) -> bool:
        sorted_intervals = sorted(intervals, key=lambda x: x[1])
        for i in range(1, len(sorted_intervals)):
            if sorted_intervals[i][0] < sorted_intervals[i - 1][1]:
                return False

        return True


class Solution1:
    """
    Mar 02, 2025 22:17
    Time Complexity: O(nlogn)
    Space Complexity: O(n)
    """

    def canAttendMeetings(self, intervals: List[List[int]]) -> bool:
        if len(intervals) == 0:
            return True
        heap = [(x[1], x) for x in intervals]
        heapq.heapify(heap)

        prev = heapq.heappop(heap)[1]
        while heap:
            curr = heapq.heappop(heap)[1]
            if prev[1] > curr[0]:
                return False

            prev = curr

        return True


if __name__ == '__main__':
    obj = Solution1()
    print(obj.canAttendMeetings([[7,10],[2,4]]))