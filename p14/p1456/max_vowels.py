class Solution:
    """
    Dec 22, 2024 17:25
    Time Complexity: O(n)
    Space Complexity: O(1)
    """

    def maxVowels(self, s: str, k: int) -> int:
        left = 0
        right = k - 1

        vowels = {'a', 'e', 'i', 'o', 'u'}

        vowels_num = 0
        for i in range(k):
            if s[i] in vowels:
                vowels_num += 1

        max_vowels_num = vowels_num

        while right + 1 < len(s):
            right += 1
            if s[right] in vowels:
                vowels_num += 1
            if s[left] in vowels:
                vowels_num -= 1
            left += 1

            max_vowels_num = max(max_vowels_num, vowels_num)

        return max_vowels_num
