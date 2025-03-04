from typing import List


class Solution:
    """
    Mar 02, 2025 16:53
    Time Complexity: O(nlogn)
    Space Complexity: O(n)
    """

    def findMinArrowShots(self, points: List[List[int]]) -> int:
        sorted_points = sorted(points, key=lambda x: x[1])
        count = 1
        arrow = sorted_points[0][1]
        for i in range(1, len(points)):
            if sorted_points[i][0] > arrow:
                count += 1
                arrow = sorted_points[i][1]

        return count
