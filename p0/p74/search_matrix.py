"""
You are given an m x n integer matrix matrix with the following two properties:

Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.

You must write a solution in O(log(m * n)) time complexity.



Example 1:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true
Example 2:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false


Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 100
-104 <= matrix[i][j], target <= 104
"""
import math
from typing import List


class Solution:
    """
    Jul 08, 2025 16:43
    Time Complexity: O(log(nm))
    Space Complexity: O(1)
    """

    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        n = len(matrix)
        m = len(matrix[0])
        left = 0
        right = n * m
        while left + 1 < right:
            mid = (left + right) // 2
            val = self.get_val(matrix, mid)
            if val == target:
                return True
            elif val < target:
                left = mid
            else:
                right = mid
        return self.get_val(matrix, left) == target

    def get_val(self, matrix: List[List[int]], index: int) -> int:
        n = len(matrix)
        m = len(matrix[0])
        i = index // m
        j = index % m
        return matrix[i][j]


if __name__ == '__main__':
    obj = Solution()
    matrix = [[1], [3]]
    target = 3
    print(obj.searchMatrix(matrix, target))

    matrix = [[1, 3]]
    target = 3
    print(obj.searchMatrix(matrix, target))

    matrix = [[1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 60]]
    target = 3
    print(obj.searchMatrix(matrix, target))

    matrix = [[1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 60]]
    target = 13
    print(obj.searchMatrix(matrix, target))
