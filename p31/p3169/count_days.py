from typing import List


class Solution:
    """
    Mar 23, 2025 17:25
    Time Complexity: O(nlogn)
    Space Complexity: O(n)
    """
    def countDays(self, days: int, meetings: List[List[int]]) -> int:
        sorted_meetings = sorted(meetings, key=lambda x: x[0])

        result = days
        slot = sorted_meetings[0]
        for i in range(1, len(sorted_meetings)):
            meeting = sorted_meetings[i]
            if meeting[0] <= slot[1]:
                slot = [slot[0], max(slot[1], meeting[1])]
            else:
                result -= (slot[1] - slot[0] + 1)
                slot = meeting

        result -= (slot[1] - slot[0] + 1)
        return result


if __name__ == '__main__':
    obj = Solution()
    meetings = [[3, 49], [23, 44], [21, 56], [26, 55], [23, 52], [2, 9], [1, 48], [3, 31]]
    print(obj.countDays(57, meetings))
