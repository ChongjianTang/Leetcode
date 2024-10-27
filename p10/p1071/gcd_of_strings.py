import math


class Solution:
    """
    Oct 20, 2024 00:19
    Time Complexity: O(n)
    Space Complexity: O(1)
    """
    def gcdOfStrings(self, str1: str, str2: str) -> str:
        gcd_length = math.gcd(len(str1), len(str2))
        candidate = str1[:gcd_length]

        if self.can_form_from(str1, candidate) and self.can_form_from(str2, candidate):
            return candidate
        return ""

    def can_form_from(self, s, part):
        times = len(s) // len(part)
        return part * times == s
