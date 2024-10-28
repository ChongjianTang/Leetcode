from typing import List


class Solution:
    """
    Oct 27, 2024 18:58
    Not very efficient
    Time Complexity: O(n)
    Space Complexity: o(n)
    """
    def longestSquareStreak(self, nums: List[int]) -> int:
        map = {}
        for num in nums:
            map[num] = num * num

        result = -1
        for num in nums:
            len = 0
            while num in map:
                len += 1
                num = map[num]

            if len >= 2 and len > result:
                result = len

        return result


if __name__ == '__main__':
    s = Solution()
    print(s.longestSquareStreak([2, 3, 5, 6, 7]) == -1)
    print(s.longestSquareStreak([4, 3, 6, 16, 8, 2]) == 3)
