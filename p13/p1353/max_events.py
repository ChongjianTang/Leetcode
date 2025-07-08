"""
You are given an array of events where events[i] = [startDayi, endDayi]. Every event i starts at startDayi and ends at endDayi.

You can attend an event i at any day d where startTimei <= d <= endTimei. You can only attend one event at any time d.

Return the maximum number of events you can attend.



Example 1:


Input: events = [[1,2],[2,3],[3,4]]
Output: 3
Explanation: You can attend all the three events.
One way to attend them all is as shown.
Attend the first event on day 1.
Attend the second event on day 2.
Attend the third event on day 3.
Example 2:

Input: events= [[1,2],[2,3],[3,4],[1,2]]
Output: 4


Constraints:

1 <= events.length <= 105
events[i].length == 2
1 <= startDayi <= endDayi <= 105
"""
import heapq
from turtledemo.penrose import start
from typing import List


class Solution:
    """
    Jul 07, 2025 15:36
    """
    def maxEvents(self, events: List[List[int]]) -> int:
        day = 1
        start_day_heap = [(event[0], event[1]) for event in events]
        heapq.heapify(start_day_heap)
        count = 0

        end_day_heap = []
        while True:
            while start_day_heap and day == start_day_heap[0][0]:
                start_day, end_day = heapq.heappop(start_day_heap)
                heapq.heappush(end_day_heap, (end_day, start_day))

            if end_day_heap:
                heapq.heappop(end_day_heap)
                count += 1
                while end_day_heap and end_day_heap[0][0] == day:
                    heapq.heappop(end_day_heap)
            if not end_day_heap and not start_day_heap:
                break

            if end_day_heap:
                day += 1
            else:
                day = start_day_heap[0][0]

        return count


if __name__ == '__main__':
    obj = Solution()
    events = [[1, 2], [1, 2], [3, 3], [1, 5], [1, 5]]
    print(obj.maxEvents(events) == 5)
    events = [[1, 2], [2, 3], [3, 4], [1, 2]]
    print(obj.maxEvents(events) == 4)
