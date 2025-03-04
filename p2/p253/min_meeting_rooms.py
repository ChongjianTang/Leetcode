import heapq
from collections import deque
from typing import List


class Solution:
    """
    Mar 02, 2025 23:14
    Time Complexity: O(nlogn)
    Space Complexity: O(n)
    """

    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        sorted_intervals = sorted(intervals, key=lambda x: x[0])

        heap = []
        max_meeting_rooms = 1
        for interval in sorted_intervals:
            while heap and heap[0] <= interval[0]:
                heapq.heappop(heap)

            heapq.heappush(heap, interval[1])
            max_meeting_rooms = max(len(heap), max_meeting_rooms)

        return max_meeting_rooms


if __name__ == '__main__':
    obj = Solution()
    print(obj.minMeetingRooms([[6, 17], [8, 9], [11, 12], [6, 9]]))
