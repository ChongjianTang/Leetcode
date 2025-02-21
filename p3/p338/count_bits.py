from typing import List


class Solution:
    """
    Feb 19, 2025 15:11
    Time Complexity: O(nlogn)
    Space Complexity: O(1)
    """

    def countBits(self, n: int) -> List[int]:
        ans = []
        for i in range(n + 1):
            ans.append(bin(i).count("1"))

        return ans


class Solution1:
    """
    Feb 19, 2025 15:30
    Time Complexity: O(n)
    Space Complexity: O(1)
    """

    def countBits(self, n: int) -> List[int]:
        ans = [0]
        if n == 0:
            return ans

        for i in range(1, n + 1):
            ans.append(ans[i >> 1] + (i & 1))
        return ans
