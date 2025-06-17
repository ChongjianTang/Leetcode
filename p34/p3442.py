class Solution:
    """
    Jun 10, 2025 16:31
    Time Complexity: O(n)
    Space Complexity: O(n)
    """

    def maxDifference(self, s: str) -> int:
        max_val = 0
        min_val = len(s)
        freq = {}
        for c in s:
            if c not in freq:
                freq[c] = 1
            else:
                freq[c] += 1

        for c in freq:
            if freq[c] % 2 == 0:
                min_val = min(freq[c], min_val)
            else:
                max_val = max(freq[c], max_val)

        return max_val - min_val
