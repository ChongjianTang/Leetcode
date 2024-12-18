class Solution:
    """
    Dec 17, 2024 17:40
    Time Complexity: O(n+m)
    Space Complexity: O(1)
    """

    def isSubsequence(self, s: str, t: str) -> bool:
        if s == "":
            return True
        if t == "":
            return False
        i = j = 0
        while j < len(t):
            if s[i] == t[j]:
                i += 1
                if i == len(s):
                    return True
                j += 1
            else:
                j += 1

        return False
