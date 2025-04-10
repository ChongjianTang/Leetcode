class Solution:
    """
    Mar 18, 2025 14:22
    """
    def canPermutePalindrome(self, s: str) -> bool:
        frequencies = {}
        odd_num_count = 0
        for char in s:
            if char not in frequencies:
                frequencies[char] = 1
                odd_num_count += 1
            else:
                if frequencies[char] % 2 == 1:
                    odd_num_count -= 1
                else:
                    odd_num_count += 1
                frequencies[char] += 1

        return odd_num_count == 1 or odd_num_count == 0
