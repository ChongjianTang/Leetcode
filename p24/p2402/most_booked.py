"""
You are given an integer n. There are n rooms numbered from 0 to n - 1.

You are given a 2D integer array meetings where meetings[i] = [starti, endi] means that a meeting will be held during the half-closed time interval [starti, endi). All the values of starti are unique.

Meetings are allocated to rooms in the following manner:

Each meeting will take place in the unused room with the lowest number.
If there are no available rooms, the meeting will be delayed until a room becomes free. The delayed meeting should have the same duration as the original meeting.
When a room becomes unused, meetings that have an earlier original start time should be given the room.
Return the number of the room that held the most meetings. If there are multiple rooms, return the room with the lowest number.

A half-closed interval [a, b) is the interval between a and b including a and not including b.



Example 1:

Input: n = 2, meetings = [[0,10],[1,5],[2,7],[3,4]]
Output: 0
Explanation:
- At time 0, both rooms are not being used. The first meeting starts in room 0.
- At time 1, only room 1 is not being used. The second meeting starts in room 1.
- At time 2, both rooms are being used. The third meeting is delayed.
- At time 3, both rooms are being used. The fourth meeting is delayed.
- At time 5, the meeting in room 1 finishes. The third meeting starts in room 1 for the time period [5,10).
- At time 10, the meetings in both rooms finish. The fourth meeting starts in room 0 for the time period [10,11).
Both rooms 0 and 1 held 2 meetings, so we return 0.
Example 2:

Input: n = 3, meetings = [[1,20],[2,10],[3,5],[4,9],[6,8]]
Output: 1
Explanation:
- At time 1, all three rooms are not being used. The first meeting starts in room 0.
- At time 2, rooms 1 and 2 are not being used. The second meeting starts in room 1.
- At time 3, only room 2 is not being used. The third meeting starts in room 2.
- At time 4, all three rooms are being used. The fourth meeting is delayed.
- At time 5, the meeting in room 2 finishes. The fourth meeting starts in room 2 for the time period [5,10).
- At time 6, all three rooms are being used. The fifth meeting is delayed.
- At time 10, the meetings in rooms 1 and 2 finish. The fifth meeting starts in room 1 for the time period [10,12).
Room 0 held 1 meeting while rooms 1 and 2 each held 2 meetings, so we return 1.


Constraints:

1 <= n <= 100
1 <= meetings.length <= 105
meetings[i].length == 2
0 <= starti < endi <= 5 * 105
All the values of starti are unique.
"""
import heapq
import random
from typing import List


class Solution:
    """
    Jul 11, 2025 16:35
    Time Complexity: O(MlogM+MlogN) Let N be the number of rooms. Let M be the number of meetings.
    Space Complexity: O(N)
    """
    def mostBooked(self, n: int, meetings: List[List[int]]) -> int:
        count = [0 for _ in range(n)]
        rooms_in_used = []
        rooms_available = [i for i in range(n)]
        sorted_meetings = sorted(meetings, key=lambda x: x[0])
        i = 0
        while i < len(sorted_meetings):
            while rooms_in_used and rooms_in_used[0][0] <= sorted_meetings[i][0]:
                _, room_num = heapq.heappop(rooms_in_used)
                heapq.heappush(rooms_available, room_num)

            if rooms_available:
                room_num = heapq.heappop(rooms_available)
                heapq.heappush(rooms_in_used, (sorted_meetings[i][1], room_num))
                count[room_num] += 1
                i += 1
            else:
                time_offset = rooms_in_used[0][0] - sorted_meetings[i][0]
                _, room_num = heapq.heappop(rooms_in_used)
                heapq.heappush(rooms_available, room_num)
                room_num = heapq.heappop(rooms_available)
                heapq.heappush(rooms_in_used, (sorted_meetings[i][1] + time_offset, room_num))
                count[room_num] += 1
                i += 1

        print(count)
        return count.index(max(count))

class Solution1:
    def mostBooked(self, n: int, meetings: List[List[int]]) -> int:
        unused_rooms, used_rooms = list(range(n)), []
        heapq.heapify(unused_rooms)
        meeting_count = [0] * n
        for start, end in sorted(meetings):
            while used_rooms and used_rooms[0][0] <= start:
                _, room = heapq.heappop(used_rooms)
                heapq.heappush(unused_rooms, room)
            if unused_rooms:
                room = heapq.heappop(unused_rooms)
                heapq.heappush(used_rooms, [end, room])
            else:
                room_availability_time, room = heapq.heappop(used_rooms)
                heapq.heappush(
                    used_rooms,
                    [room_availability_time + end - start, room]
                )
            meeting_count[room] += 1

        print(meeting_count)
        return meeting_count.index(max(meeting_count))


def test_generator():
    visited = set()
    while True:
        visited.clear()
        n = random.randint(1, 5)
        meetings_len = random.randint(1, 10)
        meetings = []
        for i in range(meetings_len):
            start = random.randint(0, 20)
            while start in visited:
                start = random.randint(0, 20)
            visited.add(start)
            end = random.randint(start + 1, start + 20)
            meetings.append([start, end])

        obj1 = Solution1()
        obj = Solution()
        if obj1.mostBooked(n, meetings) != obj.mostBooked(n, meetings):
            print(n, meetings)
            return


if __name__ == '__main__':
    # test_generator()
    obj = Solution()
    # n = 3
    # meetings = [[16, 23], [19, 35], [12, 28], [17, 23], [13, 29], [10, 28]]
    # print(obj.mostBooked(n, meetings))
    #
    # obj1 = Solution1()
    # n = 3
    # meetings = [[16, 23], [19, 35], [12, 28], [17, 23], [13, 29], [10, 28]]
    # print(obj1.mostBooked(n, meetings))

    # n = 3
    # meetings = [[0, 5], [1, 10], [2, 5], [8, 12]]
    # print(obj.mostBooked(n, meetings))
    #
    n = 3
    meetings = [[39, 49], [28, 39], [9, 29], [10, 36], [22, 47], [2, 3], [4, 49], [46, 50], [45, 50], [17, 33]]
    print(obj.mostBooked(n, meetings))
    #
    # n = 2
    # meetings = [[0, 10], [1, 5], [2, 7], [3, 4], [8, 11], [9, 12]]
    # print(obj.mostBooked(n, meetings))
    #
    # n = 3
    # meetings = [[1, 20], [2, 10], [3, 5], [4, 9], [6, 8]]
    # print(obj.mostBooked(n, meetings))
    #
    # n = 2
    # meetings = [[0, 10], [1, 5], [2, 7], [3, 4]]
    # print(obj.mostBooked(n, meetings))
