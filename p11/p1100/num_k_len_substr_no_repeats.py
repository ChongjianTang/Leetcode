class Solution:
    """
    Mar 13, 2025 15:14
    Time Complexity: O(n)
    Space Complexity: O(k)
    """

    def numKLenSubstrNoRepeats(self, s: str, k: int) -> int:
        if k > len(s):
            return 0

        count = 0
        left = 0
        right = 0
        frequencies = set()
        while right < len(s) and left <= len(s) - k:
            if s[right] not in frequencies:
                frequencies.add(s[right])
                if right - left + 1 == k:
                    count += 1
                    frequencies.remove((s[left]))
                    left += 1
            else:
                while s[left] != s[right]:
                    frequencies.remove(s[left])
                    left += 1
                frequencies.remove(s[left])
                frequencies.add(s[right])
                left += 1

            right += 1

        return count
