class Solution:
    """
    May 27, 2025 13:59
    Time Complexity: O(n/m)
    Space Complexity: O(1)
    """
    def differenceOfSums(self, n: int, m: int) -> int:
        total = (1 + n) * n // 2
        val = m
        while val <= n:
            total -= 2 * val
            val += m

        return total

# TODO: There is a O(1) time solution.